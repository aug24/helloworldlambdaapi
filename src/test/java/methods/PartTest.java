package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import methods.Part;
import junit.framework.TestCase;


public class PartTest extends TestCase {

    /**
     * Check that the original input is returned.  This is used for debugging in the client.
     */
    public void testOriginalInputIsPreserved()
    {
    	final Map<String, Object> response = new HashMap<>();
    	final Map<String, Object> request = new HashMap<>();
    	request.put("one", "two");
        new Part().handle(new JSONObject(request), response);
        assertTrue(response.containsKey("input"));
        assertTrue(((JSONObject)response.get("input")).containsKey("one"));
    }

    /**
     * Check that the message is sent back 
     */
    public void testMessageIsIncluded()
    {
    	final Map<String, Object> response = new HashMap<>();
        new Part().handle(new JSONObject(), response);
        assertTrue(response.containsKey("message"));
    }

    /**
     * Check that the message is sent back correctly
     */
    public void testMessageIsCorrect()
    {
    	final Map<String, Object> response = new HashMap<>();
        new Part().handle(new JSONObject(), response);
        assertTrue(response.get("message").toString().equals("Red Apples"));
    }

}
