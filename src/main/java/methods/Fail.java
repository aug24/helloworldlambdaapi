package methods;

import org.json.simple.JSONObject;

import examples.Method;

public class Fail implements Method {

	@Override
	public void handle(JSONObject event, JSONObject responseBody) {
        responseBody.put("statusCode", "400");
        responseBody.put("message", "Unknown request:" + event.get("path"));
	}

}
