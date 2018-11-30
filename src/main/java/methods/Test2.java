package methods;

import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Test2  implements Method {

	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

	    String greeting = "Green Apples";
	    
	    response.put("input", event);
	    response.put("message", greeting);
	    
	}

}
