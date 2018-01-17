package zl.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//操作DOM:  http://m.blog.csdn.net/smilings/article/details/7395509   [WebDriver使用指南- 操作DOM（完整篇）]
//驱动下载:  https://github.com/mozilla/geckodriver/releases，请选择对应的版本
public class FireFoxDriver
{


    //驱动名字
    private final static String webdriver_firefox_driver="webdriver.gecko.driver";
    private final static String webdriver_firefox_bin="webdriver.firefox.bin";

    //驱动路径
    private final static String Driver_Firefox_Path="E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe";
    //浏览器路径
    private final static String Browser_Firefox_Path="E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe";



    public WebDriver getDriver_firefox()
    {
/*
        System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");
*/
        System.setProperty(webdriver_firefox_driver, Driver_Firefox_Path);
        //如果以上还不行，那再添加下面这句吧
        System.setProperty(webdriver_firefox_bin, Browser_Firefox_Path);

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




}
