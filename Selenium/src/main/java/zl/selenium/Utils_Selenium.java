package zl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Utils_Selenium
{
    private  static WebDriver WEB_DRIVER;

    private String url="http://data.eastmoney.com/dxf/default.html";//网址


    public Utils_Selenium() {       }

    public Utils_Selenium(WebDriver webDriver) {        WEB_DRIVER = webDriver;    }

    public static void setWebDriver(WebDriver webDriver) {        WEB_DRIVER = webDriver;    }

    public  void printHtml(String url)
    {

        WEB_DRIVER.get(url);

        String responseBody = WEB_DRIVER.getPageSource();
        System.out.println("Response : " + responseBody);

        //WebElement href_list=  driver.findElement(By.xpath("//a[contains(@href, '/dxf/detail/')]"));
        /*List<WebElement> href_list=  driver.findElements(By.partialLinkText("/dxf/detail/"));
        System.out.println("href_list = " + href_list.size());*/

    }

    public  void printHtml(WebDriver driver, String url)
    {

        driver.get(url);

        String responseBody = driver.getPageSource();
        System.out.println("Response : " + responseBody);

        //WebElement href_list=  driver.findElement(By.xpath("//a[contains(@href, '/dxf/detail/')]"));
        /*List<WebElement> href_list=  driver.findElements(By.partialLinkText("/dxf/detail/"));
        System.out.println("href_list = " + href_list.size());*/

    }


    /**
     * 获取:根据URL 获取HTML
     * @param url
     * @param print
     * @return
     */
    public  String getHtml(String url,String print)
    {

        WEB_DRIVER.get(url);

        String html_responseBody = WEB_DRIVER.getPageSource();

        if("yes".equals(print))
        {
            System.out.println("***********************************************************************************html : \n" + html_responseBody);
        }
        return  html_responseBody;
    }


    /**
     * 获取:根据URL 获取HTML
     * @param webBrowseDriver
     * @param url
     * @param print  是否打印["yes"|"no"]
     * @return
     */
    public  String getHtml(WebDriver webBrowseDriver,String url,String print)
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
     * 获取下拉列表
     */
    public Select getSelect(WebDriver WEB_DRIVER, String select_id)
    {
        //WebElement element=WEB_DRIVER.findElement(By.id("seleyear"));
        WebElement element=WEB_DRIVER.findElement(By.id("select_id"));
        Select select_Dom = new Select(element);

        return select_Dom;
    }

    /**
     * 获取下拉列表
     */
    public List<Select> getSelect_list_contanis(WebDriver WEB_DRIVER, String select_id)
    {
        //WebElement element=WEB_DRIVER.findElement(By.id("seleyear"));
        List<WebElement> webelement_list=WEB_DRIVER.findElements(By.xpath("//a[contains(@id, "+select_id+")]"));

        List<Select>  select_list=new ArrayList<Select>();
        for (WebElement select_element:webelement_list)
        {
            Select select_Dom = new Select(select_element);
            select_list.add(select_Dom);
        }

        return select_list;
    }


    /**
     * 获取-包含id 的 所有[a 标签]:List<WebElement>
     */
    public List<WebElement> getA_list_contains(WebDriver WEB_DRIVER,String a_id)
    {
        List<WebElement> a_list =WEB_DRIVER.findElements(By.xpath("//a[contains(@id, "+a_id+")]"));//过滤月份

        return a_list;
    }


    /**
     * 获取-指定id 的 [a 标签]:WebElement
     */
    public WebElement getA(WebDriver WEB_DRIVER,String a_id)
    {
        WebElement a =WEB_DRIVER.findElement(By.id(a_id));//过滤月份

        return a;
    }


    /**
     * 获取-包含id 的 所有[a 标签]:List<WebElement>
     */
    public List<WebElement> getInput_list_contains(WebDriver WEB_DRIVER,String a_id)
    {
        List<WebElement> a_list =WEB_DRIVER.findElements(By.xpath("//a[contains(@id, "+a_id+")]"));//过滤月份

        return a_list;
    }


    /**
     * 获取-指定id 的 [a 标签]:WebElement
     */
    public WebElement getInput(WebDriver WEB_DRIVER,String a_id)
    {
        WebElement a =WEB_DRIVER.findElement(By.id(a_id));//过滤月份

        return a;
    }


//*****************************************************************************************************************************************

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "E:\\Program Files\\browser\\chromedriver_win32\\chromedriver.exe");
        //selenium driver=new Chrome();
        //driver.get("http://data.eastmoney.com/dxf/default.html");
        String url="http://data.eastmoney.com/dxf/default.html";
        new Utils_Selenium().getHtml(WEB_DRIVER,url,"yes");
        WEB_DRIVER.quit();
    }

}


