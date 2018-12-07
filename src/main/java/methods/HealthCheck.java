package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class HealthCheck implements Method {

	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

		response.put("isBase64Encoded", false);
		response.put("statusCode", 200);
		response.put("statusDescription", "200 OK");
		Map<String, Object> headers = new HashMap<>();
		//headers.put("Set-cookie", "cookies");
		headers.put("Content-Type", "application/json");
		response.put("headers", new JSONObject(headers)); 
	    response.put("body", "Hello from Lambda");
	}

}
