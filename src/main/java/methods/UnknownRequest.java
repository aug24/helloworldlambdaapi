package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Fail implements Method {

	@Override
	public final void handle(JSONObject event, Map<String, Object> response) {
        response.put("statusCode", "400");
        response.put("message", "Unknown request:" + event.get("path"));
	}

}
