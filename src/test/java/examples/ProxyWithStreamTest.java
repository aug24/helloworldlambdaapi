package examples;

import junit.framework.TestCase;
import methods.UnknownRequest;

/**
 * Unit test for simple App.
 */
public class ProxyWithStreamTest 
    extends TestCase
{
    /**
     * We would usually have a bunch of tests that the input was interpreted correctly etc
     */
    public void testHandleUnknownPath()
    {
        assertEquals(new ProxyWithStream().getMethod("rubbish").getClass(), UnknownRequest.class);
    }
}
