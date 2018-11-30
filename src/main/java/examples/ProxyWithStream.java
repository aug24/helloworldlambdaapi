package examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.Writer;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.LambdaLogger;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import methods.Fail;
import methods.Test;
import methods.Test2;


public class ProxyWithStream implements RequestStreamHandler {
    JSONParser parser = new JSONParser();


    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of ProxyWithStream");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseBody = new JSONObject();
        String responseCode = "200";

        try {
            JSONObject event = (JSONObject)parser.parse(reader);
            Method method;
            if (event.get("path").equals("test"))
        		method = new Test(); 
            else if (event.get("path").equals("test2"))
        		method = new Test2();
            else 
            	method = new Fail();
            method.handle(event, responseBody);
        } catch(ParseException pex) {
            responseBody.put("statusCode", "400");
            responseBody.put("exception", pex);
        }

        logger.log(responseBody.toJSONString());
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseBody.toJSONString());  
        writer.close();
    }
}
