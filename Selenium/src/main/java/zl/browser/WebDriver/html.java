package zl.browser.WebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


//操作DOM:  http://m.blog.csdn.net/smilings/article/details/7395509   [WebDriver使用指南- 操作DOM（完整篇）]
//驱动下载:  http://code.google.com/p/chromedriver/downloads/list]
public class html
{


    /**
     * 获取下拉列表
     */
    public Select getSelect(WebDriver WEB_DRIVER,String select_id)
    {
        //WebElement element=WEB_DRIVER.findElement(By.id("seleyear"));
        WebElement element=WEB_DRIVER.findElement(By.id("select_id"));
        Select select_Dom = new Select(element);

        return select_Dom;
    }

    /**
     * 获取下拉列表
     */
    public List<Select> getSelect_list_contanis(WebDriver WEB_DRIVER,String select_id)
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
}
