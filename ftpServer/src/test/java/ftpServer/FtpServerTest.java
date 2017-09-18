package ftpServer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;

/**
 * Unit test for simple App.
 */
public class FtpServerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FtpServerTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FtpServerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws FtpException
    {
        FtpServerFactory serverFactory = new FtpServerFactory();
        FtpServer server = serverFactory.createServer();
        server.start();

    }
}
