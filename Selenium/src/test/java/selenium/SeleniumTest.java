package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import zl.selenium.Drivers;
import zl.selenium.Utils_Selenium;

import java.util.List;

public class SeleniumTest {





@Test
public  void  testChrome()
{
/*
<select onchange="redirectpage(this.value)" id="seleyear" value="2018年">
	<option value="2018年">0</option>
	<option value="2017年" >1</option>
	<option value="2016年">2</option>
	<option value="2015年">3</option>
	<option value="2014年">4</option>
	<option value="2013年">5</option>
	<option value="2012年">6</option>
	<option value="2011年">7</option>
	<option value="2010年">8</option>
	<option value="2009年">9</option>
	<option value="2008年">10</option>
</select>
* */

        WebDriver WEB_DRIVER=new Drivers().getDriver_chrome();
        //指定chromedriver的路径

/*        //chrome没有安装在默认路径时，指定chrome.exe的路径
        //System.setProperty("webdriver.chrome.bin","C:/Documents and Settings/gongjf/Local Settings/Application Data/Google/Chrome/Application/chrome.exe");
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        WEB_DRIVER = new Chrome();
        */
        WEB_DRIVER.get("http://data.eastmoney.com/dxf/default.html");

        Actions actions=new Actions(WEB_DRIVER);

        //获取下拉选择框[年份]
/*
    HtmlSelect hs = (HtmlSelect) htmlpage_root.getElementById("seleyear");
    System.out.println("-----------------------------------------------------------------正在跳转…"+hs.getOption(year).getText());
    //按要求选择第一个数据库 - 获取刷新后的页面--选择[year]年
    HtmlPage htmlpage_year= (HtmlPage) hs.getOption(year).setSelected(true);//1.选择年份=>获取刷新后的页面
*/
        //1.下拉选择框(Select)-年份
        //找到下拉选择框的元素：
        WebElement element=WEB_DRIVER.findElement(By.id("seleyear"));
        org.openqa.selenium.support.ui.Select select = new Select(element);

        //2.选择对应的选择项：
        //select.selectByVisibleText("mediaAgencyA");
        select.selectByIndex(5);//1.点击下拉年份后-Ajax刷新页面
        try
        {
            Thread.sleep(4000);//页面点击后必须这个
        } catch (InterruptedException e) {     }


        System.out.println("------------------------------- = " + select.getFirstSelectedOption().getText());

        //3.月份
        //WebElement  month_1=WEB_DRIVER.findElement(By.id("month_11"));
        //month_1.click();

        //选择  [a] 标签 [id] 属性包含 [month_1] 的所有a标签
        List<WebElement> month_list =WEB_DRIVER.findElements(By.xpath("//a[contains(@id, 'month_')]"));//过滤月份


        for (WebElement month_a:month_list)
        {

            System.out.println(" a= "+month_a.getText());
            month_a.click();//2.点击月份后-Ajax刷新页面
            try
            {
                Thread.sleep(6000);
            } catch (InterruptedException e) {     }


            List<WebElement> jjmx_list  =WEB_DRIVER.findElements(By.xpath("//a[contains(@href, '/dxf/detail/')]"));//刷新页面后--获取加载后的解禁详细
       /* for (WebElement jjmx_a:jjmx_list)
        {
            System.out.println(" a= "+jjmx_a.getAttribute("href").toString());
        }*/
            System.out.println("解禁数量 = " + jjmx_list.size());


        }




        // quit();
    }





    @Test
    public  void  testFireFox()
    {

/*
        System.setProperty("webdriver.gecko.driver", "E:\\Program Files\\browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        //如果以上还不行，那再添加下面这句吧
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files\\Mozilla Firefox\\56\\firefox.exe");

        //System.setProperty("webdriver.firefox.marionette", "false");

        selenium   dr = new FirefoxDriver();
*/
        WebDriver   dr =new Drivers().getDriver_firefox();
/*
                    dr.get("http://www.baidu.com");


        WebElement element = dr.findElement(By.name("wd"));
        element.sendKeys("webdriver");
        element.submit();

*/


        String contains="http://www.baidu.com";
        new Utils_Selenium(dr).printHtml(contains);

/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("page title is:"+dr.getTitle());*/
    }

}
