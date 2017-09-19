package ftp4j;

import it.sauronsoftware.ftp4j.FTPClient;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Ftp4jTest    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Ftp4jTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Ftp4jTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        FTPClient client = new FTPClient();
    }


}
