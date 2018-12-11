package examples;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class ProxyWithStreamTest 
    extends TestCase
{
    /**
     * We would usually have a bunch of tests that the input was interpreted correctly etc
     */
	public void testGetCleanRelativePath() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("path",  "/mypath");
		String path = new ProxyWithStream().getPath(new JSONObject(parameters));
		assertEquals("mypath", path);
	}

	public void testGetCleanNonRelativePath() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("path",  "mypath");
		String path = new ProxyWithStream().getPath(new JSONObject(parameters));
		assertEquals("mypath", path);
	}

	public void testGetCleanEmptyPath() {
		Map<String, Object> parameters = new HashMap<>();
		String path = new ProxyWithStream().getPath(new JSONObject(parameters));
		assertEquals("", path);
	}
}
