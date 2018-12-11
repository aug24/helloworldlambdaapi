package examples;

import java.util.Map;

import org.json.simple.JSONObject;

public interface Method {
	public Map<String, Object> handle(JSONObject event);
}
