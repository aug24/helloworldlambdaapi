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

		response.put("isBase64Encoded", false);
		response.put("statusCode", 200);
		response.put("statusDescription", "200 OK");
		Map<String, Object> headers = new HashMap<>();
		//headers.put("Set-cookie", "cookies");
		headers.put("Content-Type", "application/json");
		response.put("headers", new JSONObject(headers)); 

		Map<String, Object> body = new HashMap<>();
	    body.put("message", greeting);
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
	    body.put("date", timeStamp);
		body.put("input", event);

	    response.put("body", new JSONObject(body).toJSONString());
	}

}
