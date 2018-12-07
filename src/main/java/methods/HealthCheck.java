package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class HealthCheck implements Method {

	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

	    response.put("statusCode", "200");
	}

}
