package examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import methods.HealthCheck;
import methods.Part;
import methods.User;

public class ProxyWithStream implements RequestStreamHandler {
    JSONParser parser = new JSONParser();


    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of ProxyWithStream");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String responseBody = getResponse(reader, logger);        
        logger.log(responseBody);
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseBody);  
        writer.close();
    }
    
    String getResponse(BufferedReader reader, LambdaLogger logger) throws IOException {
    	Map<String, Object> response;
        try {
            JSONObject event = (JSONObject)parser.parse(reader);
            logger.log(event.toJSONString());
            String path = event.containsKey("path") 
            	? event.get("path").toString().replace("^/", "")
            	: "";
            response = getMethod(path, event, logger);
        } catch(ParseException pex) {
        	response = new HashMap<String, Object>();
            response.put("statusCode", "400");
            response.put("exception", pex);
        }
        return new JSONObject(response).toJSONString();
    }
    
    Map<String, Object> getMethod(String path, JSONObject event, LambdaLogger logger) {
        return event.containsKey("requestContext")
        	? getALBMethod(path, event, logger)
	    	: getAPIGMethod(path, event, logger);
    }
    
    // This could be better rewritten as a map or something.  In Scala, we'd use Map.getOrElse.
    Map<String, Object>  getAPIGMethod(String path, JSONObject event, LambdaLogger logger) {
    	logger.log("Event does not have 'requestContext' key; assuming API Gateway");
    	
    	Map<String, Object> body = getBody(path, event);
    	if (body != null) return body;
    	
        Map<String, Object> response = new HashMap<String, Object>();
    	response.put("statusCode", 400);
    	response.put("statusDescription", "400 Client Error");
        return response;
    }

	private Map<String, Object> getBody(String path, JSONObject event) {
		if (path != null && path.equals("user"))
    		return new User().handle(event); 
        if (path != null && path.equals("part"))
    		return new Part().handle(event);
        if (path != null && path.equals("healthcheck"))
    		return new HealthCheck().handle(event);
        return null;
	}
	
    // This could be better rewritten as a map or something.  In Scala, we'd use Map.getOrElse.
    Map<String, Object> getALBMethod(String path, JSONObject event, LambdaLogger logger) {
    	logger.log("Event has 'requestContext' key; assuming ALB");
    	
    	Map<String, Object> response = new HashMap<String, Object>();
		response.put("isBase64Encoded", false);
		Map<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		response.put("headers", new JSONObject(headers)); 

    	Map<String, Object> body = getBody(path, event);

    	if (body == null) {
	    	response.put("statusCode", 400);
	    	response.put("statusDescription", "400 Client Error");
	    	response.put("body", null);
    	} else {
    		response.put("statusCode", 200);
    		response.put("statusDescription", "200 OK");
    		response.put("body", new JSONObject(body).toJSONString());
    	}
        
        return response;
    }
}
