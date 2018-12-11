package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class Part implements Method {

	private String greeting = "Red Apples";
	
	@Override
	public Map<String, Object> handle(JSONObject event) {
		Map<String, Object> response = new HashMap<String, Object>();
	    response.put("message", greeting);
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
	    response.put("date", timeStamp);
		response.put("input", event);
		return response;
	}

}
