package zl.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//操作DOM:  http://m.blog.csdn.net/smilings/article/details/7395509   [WebDriver使用指南- 操作DOM（完整篇）]
//驱动下载:  http://code.google.com/p/chromedriver/downloads/list]
public class Drivers
{

/*****************************************************************************************************************************************/
// Chrome.61
/*****************************************************************************************************************************************/

    //驱动名字
    private static String   webdriver_chrome_driver="webdriver.chrome.driver";
    private static String   webdriver_chrome_bin="webdriver.chrome.bin";


    //驱动路径
    private  static String Chrome_Driver_Path="E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe";
    //谷歌浏览器:[默认路径]
    private  static String Chrome_Path="C:/Documents and Settings/gongjf/Local Settings/Application Data/Google/Chrome/Application/chrome.exe";




    public WebDriver getDriver_chrome()
    {
/*
        System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");
*/
        System.setProperty(webdriver_chrome_driver,Chrome_Driver_Path);
        //如果以上还不行，那再添加下面这句吧
        System.setProperty(webdriver_chrome_bin, Chrome_Path);

        WebDriver   webDriver = new ChromeDriver();

        return webDriver;
    }

    public WebDriver getDriver_chrome(String Driver_Path,String Chrome_Path)
    {
        //System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        //System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");

        System.setProperty(webdriver_chrome_driver, Driver_Path);
        System.setProperty(webdriver_chrome_bin, Chrome_Path);

        WebDriver   webDriver = new ChromeDriver();

        return webDriver;
    }



/*****************************************************************************************************************************************/
// FireFox.56
/*****************************************************************************************************************************************/

    //驱动名字
    private final static String webdriver_firefox_driver="webdriver.gecko.driver";
    private final static String webdriver_firefox_bin="webdriver.firefox.bin";

    //驱动路径
    private final static String Firefox_Driver_Path="E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe";
    //浏览器路径
    private final static String Firefox_Path="E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe";



    public WebDriver getDriver_firefox()
    {
/*
        System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");
*/
        System.setProperty(webdriver_firefox_driver, Firefox_Driver_Path);
        //如果以上还不行，那再添加下面这句吧
        System.setProperty(webdriver_firefox_bin, Firefox_Path);

        //System.setProperty("webdriver.firefox.marionette", "false");

        WebDriver   webDriver = new FirefoxDriver();

        return webDriver;
    }

    public WebDriver getDriver_firefox(String Driver_Path,String FireFox_Path)
    {
        //System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        //System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");

        System.setProperty(webdriver_firefox_driver, Driver_Path);
        System.setProperty(webdriver_firefox_bin, FireFox_Path);

        WebDriver   webDriver = new FirefoxDriver();

        return webDriver;
    }

/*****************************************************************************************************************************************/
// HtmlUnitDriver
/*****************************************************************************************************************************************/


    /**
     *
     * @return
     */
    public  WebDriver gethtmlUnitDriver()
    {
        WebDriver webDriver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
        return webDriver;
    }
}
