package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Part  implements Method {

	private String greeting = "Green Apples";
	
	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

	    response.put("input", event);
	    response.put("message", greeting);
	    
	}

}