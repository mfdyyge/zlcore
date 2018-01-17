package zl.selenium.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class htmlUnitDrivers
{

    @Test
    public void test()
    {
        WebDriver webDriver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
        webDriver.get("http://www.baidu.com");


        WebElement element = webDriver.findElement(By.name("wd"));
        element.sendKeys("webdriver");
        element.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("page title is:"+webDriver.getTitle());
    }





}
