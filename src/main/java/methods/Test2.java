package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;

import examples.Method;

public class Test2  implements Method {

	@Override
	public void handle(JSONObject event, JSONObject responseBody) {

	    String greeting = "Apples";
	    
	    responseBody.put("input", event);
	    responseBody.put("message", greeting);
	    
	}

}
