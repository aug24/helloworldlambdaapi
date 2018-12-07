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

import methods.UnknownRequest;
import methods.User;
import methods.Part;


public class ProxyWithStream implements RequestStreamHandler {
    JSONParser parser = new JSONParser();


    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of ProxyWithStream");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Map<String, Object> response = getResponse(reader);        

        String responseBody = new JSONObject(response).toJSONString();
        logger.log(responseBody);
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseBody);  
        writer.close();
    }
    
    Map<String, Object> getResponse(BufferedReader reader) throws IOException {
    	Map<String, Object> response = new HashMap<String, Object>();
        try {
        	Map<String, Object> body = new HashMap<String, Object>();
            JSONObject event = (JSONObject)parser.parse(reader);
            String path = event.get("path").toString();
            getMethod(path).handle(event, body);
            response.put("statusCode", "200");
            response.put("body", body);
        } catch(ParseException pex) {
            response.put("statusCode", "400");
            response.put("exception", pex);
	    } catch(Exception ex) {
	        response.put("statusCode", "500");
	        response.put("exception", ex);
	    }
        return response;
    }
    
    // This could be better rewritten as a map or something.  In Scala, we'd use Map.getOrElse.
    Method getMethod(String path) {
        if (path==null) 
        	return new UnknownRequest();
        
        if (path.equals("user"))
    		return new User(); 

        if (path.equals("part"))
    		return new Part();
        
        return new UnknownRequest();
    }
}
