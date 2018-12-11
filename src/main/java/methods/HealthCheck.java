package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class HealthCheck implements Method {

	@Override
	public Map<String, Object> handle(JSONObject event) {
		return new HashMap<String, Object>();
	}

}
