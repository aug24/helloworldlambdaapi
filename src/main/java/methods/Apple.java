package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Apple  implements Method {

	private String greeting = "Red Apples";
	
	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

	    response.put("input", event);
	    response.put("message", greeting);
	    
	}

}
