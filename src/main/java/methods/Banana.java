package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Banana implements Method {

	private String greeting = "Banana";

	@Override
	public void handle(JSONObject event, Map<String, Object> response) {
	    
	    response.put("input", event);
	    response.put("message", greeting);
	    
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	    response.put("date", timeStamp);
		
	}
}