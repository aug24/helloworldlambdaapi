package example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ProxyWithStreamTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProxyWithStreamTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProxyWithStreamTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testProxyWithStream()
    {
        assertTrue( true );
    }
}
