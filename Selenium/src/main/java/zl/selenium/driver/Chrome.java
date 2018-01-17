package zl.selenium.driver;


import org.openqa.selenium.WebDriver;


//操作DOM:  http://m.blog.csdn.net/smilings/article/details/7395509   [WebDriver使用指南- 操作DOM（完整篇）]
//驱动下载:  http://code.google.com/p/chromedriver/downloads/list]
public class Chrome
{

    //驱动名字
    private static String   Driver_Name="webdriver.chrome.driver";
    private static String   Driver_Bin="webdriver.chrome.bin";


    //驱动路径
    private  static String CHROME_DRIVER_PATH="E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe";
    //谷歌浏览器:[默认路径]
    private  static String DHROME_DEFAULT_PATH="C:/Documents and Settings/gongjf/Local Settings/Application Data/Google/Chrome/Application/chrome.exe";




    public WebDriver getDriver_FireFox()
    {
/*
        System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");
*/
        System.setProperty(Driver_Name, "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty(Driver_Bin, "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");

        WebDriver   webDriver = new org.openqa.selenium.chrome.ChromeDriver();

        return webDriver;
    }

    public WebDriver getDriver_FireFox(String Driver_Path,String Chrome_Path)
    {
        //System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        //System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");

        System.setProperty(Driver_Name, Driver_Path);
        System.setProperty(Driver_Bin, Chrome_Path);

        WebDriver   webDriver = new org.openqa.selenium.chrome.ChromeDriver();

        return webDriver;
    }

}
