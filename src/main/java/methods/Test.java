package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;

import examples.Method;

public class Test implements Method {


	@Override
	public void handle(JSONObject event, JSONObject responseBody) {
	    String greeting = "Banana";
	    
	    responseBody.put("input", event);
	    responseBody.put("message", greeting);
	    
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	    responseBody.put("date", timeStamp);
		
	}
}
