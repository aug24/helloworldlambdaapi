package examples;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public interface Method {
	public void handle(JSONObject event, Map<String, Object> response);
}
