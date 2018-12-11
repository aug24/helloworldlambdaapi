package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import junit.framework.TestCase;
import methods.Part;


public class PartTest extends TestCase {

    /**
     * Check that the original input is returned.  This is used for debugging in the client.
     */
    public void testOriginalInputIsPreserved()
    {
    	final Map<String, Object> request = new HashMap<>();
    	request.put("one", "two");
    	final Map<String, Object> response = new Part().handle(new JSONObject(request));
        assertTrue(response.containsKey("input"));
        assertTrue(((JSONObject)response.get("input")).containsKey("one"));
    }

    /**
     * Check that the message is sent back 
     */
    public void testMessageIsIncluded()
    {
    	final Map<String, Object> response = new Part().handle(new JSONObject());
        assertTrue(response.containsKey("message"));
    }

    /**
     * Check that the message is sent back correctly
     */
    public void testMessageIsCorrect()
    {
    	final Map<String, Object> response = new Part().handle(new JSONObject());
        assertTrue(response.get("message").toString().equals("Red Apples"));
    }

}
