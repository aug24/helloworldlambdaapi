package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import methods.Part;
import junit.framework.TestCase;


public class AppleTest extends TestCase {

    /**
     * Check that the original input is returned.  This is used for debugging in the client.
     */
    public void testOriginalInputIsPreserved()
    {
    	final Map<String, Object> response = new HashMap<>();
        new Part().handle(new JSONObject(), response);
        assertTrue(response.containsKey("input"));
    }

    /**
     * Check that the message is sent back correctly
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
        assertTrue(response.get("message").toString().equals("Green Apples"));
    }

}
