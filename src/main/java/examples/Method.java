package examples;

import org.json.simple.JSONObject;

public interface Method {
	public void handle(JSONObject event, JSONObject responseBody);
}
