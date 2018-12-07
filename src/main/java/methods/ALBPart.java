package methods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import examples.Method;

public class ALBPart implements Method {

	private String greeting = "Blue Apples";
	
	@Override
	public void handle(JSONObject event, Map<String, Object> response) {

		Map<String, Object> body = new HashMap<>();
	    body.put("message", greeting);
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
	    body.put("date", timeStamp);

	    response.put("body", body);
	    response.put("input", event);
	    response.put("statusCode", "400");
	}

}
