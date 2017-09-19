package ftpServer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;

import java.io.File;

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

    public static void main(String[] args) throws FtpException {

/*
        FtpServerFactory serverFactory = new FtpServerFactory();

        BaseUser user = new BaseUser();
        user.setName("anonymous");
        user.setHomeDirectory("D:/test");

        serverFactory.getUserManager().save(user);

        FtpServer server = serverFactory.createServer();
        //System.out.println("server = " + serverFactory.get);
        server.start();
*/


        FtpServerFactory serverFactory = new FtpServerFactory();

        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        userManagerFactory.setFile(new File("users.properties"));

        serverFactory.setUserManager(userManagerFactory.createUserManager());

        FtpServer server = serverFactory.createServer();
        server.start();
    }


}
