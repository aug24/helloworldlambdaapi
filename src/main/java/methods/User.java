package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class User implements Method {

	private String greeting = "Banana";

	@Override
	public Map<String, Object> handle(JSONObject event) {
		Map<String, Object> response = new HashMap<String, Object>();
	    response.put("input", event);
	    response.put("message", greeting);
	    
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	    response.put("date", timeStamp);
	    return response;	
	}
}
