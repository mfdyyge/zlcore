import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.zl.core.jdbc.DataSource.DsFactory;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import zl.selenium.Drivers;
import zl.selenium.Utils_Selenium;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class htmlunit_main
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
static int year=3;
static String month="";

private static DsFactory dsFactory;
private static Connection connection;
static
{
    dsFactory=new DsFactory("dbtt");
    connection= dsFactory.getConnection();
}


public static void main(String[] as) throws IOException
{
        //谷歌
        //WebClient webclient = new WebClient(BrowserVersion.CHROME);
        //火狐
        final WebClient webclient = new WebClient(BrowserVersion.FIREFOX_52);
        WebDriver dr =new Drivers().getDriver_firefox();

        // 这里是配置一下不加载css和javaScript,配置起来很简单，是不是

        webclient.getOptions().setUseInsecureSSL(true);//支持https
        webclient.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
        webclient.getOptions().setCssEnabled(false); // 禁用css支持
        webclient.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
        webclient.getOptions().setTimeout(0); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
        webclient.getOptions().setDoNotTrackEnabled(false);
        webclient.setJavaScriptTimeout(1000);//设置js运行超时时间
        webclient.waitForBackgroundJavaScript(200);//设置页面等待js响应时间,
        //webclient.setAjaxController(new NicelyResynchronizingAjaxController());

        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
        // 默认加载:2017.12 月数据-解禁企业列表
        final HtmlPage htmlpage_root = (HtmlPage) webclient.getPage("http://data.eastmoney.com/dxf/default.html");

    //      该方法在getPage()方法之后调用才能生效
            webclient.waitForBackgroundJavaScript(1000);
            webclient.setJavaScriptTimeout(200);

    // 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
/*        final HtmlForm form = htmlpage.getFormByName("f");
        // 同样道理，获取”百度一下“这个按钮
        final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("百度一下");
        // 得到搜索框
        final HtmlTextInput textField = (HtmlTextInput) form.getInputByName("q1");*/

        //** ***********************************************************************1.年份 [select:id=seleyear]-选择2015年
        //获取下拉选择框[年份]
         HtmlSelect hs = (HtmlSelect) htmlpage_root.getElementById("seleyear");
        System.out.println("-----------------------------------------------------------------正在跳转…"+hs.getOption(year).getText());
        //按要求选择第一个数据库 - 获取刷新后的页面--选择[year]年
         HtmlPage htmlpage_year= (HtmlPage) hs.getOption(year).setSelected(true);//1.选择年份=>获取刷新后的页面
        System.out.println("-----------------------------------------------------------------选择年份:"+hs.getOption(year).getText());

        //** ***********************************************************************2.月份 [a:id=month_X]-选择 1 月份
         List<HtmlAnchor> achList= htmlpage_year.getAnchors();//选择年份=>获取刷新后的页面=>获取页面全部链接=>
        //htmlpage_root.getFullyQualifiedUrl("ID=953")
        String anchor_id="";
        Integer month_i=1;

        for(HtmlAnchor ach:achList)//选择年份=>获取刷新后的页面=>获取页面全部链接=>
        {
            anchor_id=ach.getId();
            //1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签
            //if(anchor_id.contains("month_12"))
            month="month_"+month_i;

            if(anchor_id.equals(month))//1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签
            //if(anchor_id.equals("month_2"))
            {
                System.out.println("-----------------------------------------------------------------点击月份="+month);//
                System.out.println("anchor_id="+anchor_id);

                //1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签=>5.点击月份-获取=>6.刷新后的页面
                HtmlPage htmlpage_month = ach.click();

                String table_jjqy_list_str=htmlpage_month.getElementById("table_listcontent").getFirstElementChild().asText();//获取=>解禁企业列表
                //System.out.println("= " +table_jjqy_list_str );//打印=>解禁企业列表

                System.out.println("解禁详细数据,保存中......." );
                //System.out.println("title = " + htmlpage_month.getTitleText());

                //5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)
                //打印=>解禁详细链接
                //utils_Html_jsoup.printHtmlAnchor_containsXXX_AsText(htmlpage_month,"/dxf/detail/300217");
                //5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接
                List<HtmlAnchor>    jjxqUrlList= Utils_Html.getUrlList_HtmlAnchor(htmlpage_month,"/dxf/detail/","");
                //** ***********************************************************************//5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接
                int js=1;
                for (HtmlAnchor jjxqurl:jjxqUrlList)
                {
                    System.out.println(" 开始打开页面: "+jjxqurl);
                    String jjmx_url=jjxqurl.getHrefAttribute();

                    System.out.println("jjmx_url = " + jjmx_url);
                    String html="http://data.eastmoney.com";

                    //打印
                    //Utils_Selenium.printHtml(html+jjmx_url);
                    //Utils_Selenium.getHtml(html+jjmx_url,"no");
                    //必须用完关闭
                    //Utils_Selenium.close();

                    //1.获取页面
                    //HtmlPage htmlpage_jjmx=jjxqurl.click();//5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接=>9.点击解禁详细-获取解禁详细页面
                    //2.获取页面-html
                    //String html=htmlpage_jjmx.asXml();

                    HtmlService htmlService=new HtmlService();

                    try {
                        Elements elements= htmlService.getTable_JsoupTable(new Utils_Selenium(dr).getHtml(html+jjmx_url,"no"),".tab1","");//9.点击解禁详细-获取解禁详细页面=>10.获取解禁表格
                        htmlService.getTable_trList_Jsoup(elements,"no",connection);
                        System.out.println("-----------------------------------------------------------------完成 " + jjxqurl+" 详细列表的[数据抓取]"+js++);
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("*****************************************************************出现服务器错误无法访问 => "+html+jjmx_url);
                       // e.printStackTrace();
                    } finally {                        continue;                    }


                }
                month_i++;
                System.out.println("month = " + month);
                if(month_i==13)  break;//控制月份[ 1月-12月 ]
            }
        }
        //Utils_Selenium.quit();
        webclient.close();//关闭窗口
}

}