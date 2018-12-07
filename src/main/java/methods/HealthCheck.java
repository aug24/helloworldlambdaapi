package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class HealthCheck implements Method {

	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

		response.put("isBase64Encoded", false);
		response.put("statusCode", 200);
		response.put("statusDescription", "200 OK");
//		    "headers": {
//		        "Set-cookie": "cookies",
//		        "Content-Type": "application/json"
//		    },
	    response.put("body", "Hello from Lambda");
	}

}
