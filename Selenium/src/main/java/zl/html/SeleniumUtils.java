package zl.html;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtils
{
    private final static WebDriver WEB_DRIVER;
    private final static String CHROME_DRIVER_NAME="webdriver.chrome.driver";//设置浏览驱动
    private final static String CHROME_DRIVER_PATH="E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe";//设置浏览驱动-路径


    private String url="http://data.eastmoney.com/dxf/default.html";//网址

    static
    {
        //System.setProperty("webdriver.chrome.driver", "E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe");
        System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
        WEB_DRIVER=new ChromeDriver();
    }

    public static void printHtml(WebDriver driver, String url){

        driver.get(url);

        String responseBody = driver.getPageSource();
        System.out.println("Response : " + responseBody);

        //WebElement href_list=  driver.findElement(By.xpath("//a[contains(@href, '/dxf/detail/')]"));
        /*List<WebElement> href_list=  driver.findElements(By.partialLinkText("/dxf/detail/"));
        System.out.println("href_list = " + href_list.size());*/

    }
    public static void printHtml(String url){

        WEB_DRIVER.get(url);

        String responseBody = WEB_DRIVER.getPageSource();
        System.out.println("Response : " + responseBody);

        //WebElement href_list=  driver.findElement(By.xpath("//a[contains(@href, '/dxf/detail/')]"));
        /*List<WebElement> href_list=  driver.findElements(By.partialLinkText("/dxf/detail/"));
        System.out.println("href_list = " + href_list.size());*/

    }

    /**
     * 获取:根据URL 获取HTML
     * @param webBrowseDriver
     * @param url
     * @param print  是否打印["yes"|"no"]
     * @return
     */
    public static String getHtml(WebDriver webBrowseDriver,String url,String print)
    {

        webBrowseDriver.get(url);

        String html_responseBody = webBrowseDriver.getPageSource();

        if("yes".equals(print))
        {
            System.out.println("***********************************************************************************html : \n" + html_responseBody);
        }

        return  html_responseBody;
    }


    /**
     * 获取:根据URL 获取HTML
     * @param url
     * @param print
     * @return
     */
    public static String getHtml(String url,String print)
    {

        WEB_DRIVER.get(url);

        String html_responseBody = WEB_DRIVER.getPageSource();

        if("yes".equals(print))
        {
            System.out.println("***********************************************************************************html : \n" + html_responseBody);
        }
        return  html_responseBody;
    }



















    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver=new Chrome();
        //driver.get("http://data.eastmoney.com/dxf/default.html");
        String url="http://data.eastmoney.com/dxf/default.html";
        getHtml(WEB_DRIVER,url,"yes");
        WEB_DRIVER.quit();
    }






    /**
     * 关闭浏览器驱动
     */
    public static void quit()    {        WEB_DRIVER.quit();    }
    /**
     * 关闭浏览器驱动
     */
    public static void close()    {        WEB_DRIVER.close();    }

}


