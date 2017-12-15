package zl.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.zl.core.jdbc.DataSource.DsFactory;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Html_main
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

private static DsFactory dsFactory;
private static Connection connection;
static
{
    dsFactory=new DsFactory("dbtt");
    connection= dsFactory.getConnection();
}


public static void main(String[] month) throws IOException
{


        // 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
        //WebClient webclient = new WebClient();
        //模拟不同浏览器
        //谷歌
        //WebClient webclient = new WebClient(BrowserVersion.CHROME);
        //火狐
        WebClient webclient = new WebClient(BrowserVersion.FIREFOX_52);
        //edge
        //WebClient webclient = new WebClient(BrowserVersion.EDGE);


        // 这里是配置一下不加载css和javaScript,配置起来很简单，是不是
  /*      webclient.getOptions().setCssEnabled(false);
        webclient.getOptions().setJavaScriptEnabled(false);
        */
        webclient.getOptions().setUseInsecureSSL(true);//支持https
        webclient.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
        webclient.getOptions().setCssEnabled(false); // 禁用css支持
        webclient.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
        webclient.getOptions().setTimeout(100000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
        webclient.getOptions().setDoNotTrackEnabled(false);
        webclient.setJavaScriptTimeout(8000);//设置js运行超时时间
        webclient.waitForBackgroundJavaScript(500);//设置页面等待js响应时间,
        //webclient.setAjaxController(new NicelyResynchronizingAjaxController());

        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
        /*
        * 默认加载:2017.12 月数据-解禁企业列表
        * */
        HtmlPage htmlpage_root = (HtmlPage) webclient.getPage("http://data.eastmoney.com/dxf/default.html");

        // 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
/*        final HtmlForm form = htmlpage.getFormByName("f");
        // 同样道理，获取”百度一下“这个按钮
        final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("百度一下");
        // 得到搜索框
        final HtmlTextInput textField = (HtmlTextInput) form.getInputByName("q1");*/

        //** ***********************************************************************1.年份 [select:id=seleyear]-选择2015年
        //获取第一个数据库
        HtmlSelect hs = (HtmlSelect) htmlpage_root.getElementById("seleyear");
        System.out.println("-----------------------------------------------------------------正在跳转…"+hs.getOption(3).getText());
        //按要求选择第一个数据库 - 获取刷新后的页面--选择2015年
        htmlpage_root= (HtmlPage) hs.getOption(year).setSelected(true);//1.选择年份=>获取刷新后的页面
        System.out.println("-----------------------------------------------------------------选择年份:"+hs.getOption(3).getText());

        //** ***********************************************************************2.月份 [a:id=month_X]-选择 1 月份
        List<HtmlAnchor> achList= htmlpage_root.getAnchors();//选择年份=>获取刷新后的页面=>获取页面全部链接=>
        //htmlpage_root.getFullyQualifiedUrl("ID=953")
        String anchor_id="";
        int i=1;

        for(HtmlAnchor ach:achList)//选择年份=>获取刷新后的页面=>获取页面全部链接=>
        {
            anchor_id=ach.getId();
            //1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签
            //if(anchor_id.contains("month_12"))
            if(anchor_id.equals("month_"+i))//1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签
            {

                System.out.println("-----------------------------------------------------------------点击月份="+ach.asText());//
                System.out.println("anchor_id="+anchor_id);

                //1.选择年份=>2.获取刷新后的页面=>3.获取页面全部链接=>4.过滤[id]包含"month_"月份<a>标签=>5.点击月份-获取=>6.刷新后的页面
                htmlpage_root = ach.click();

                String table_jjqy_list_str=htmlpage_root.getElementById("table_listcontent").getFirstElementChild().asText();//获取=>解禁企业列表
                System.out.println("= " +table_jjqy_list_str );//打印=>解禁企业列表

                System.out.println("解禁详细数据,保存中......." );
                System.out.println("title = " + htmlpage_root.getTitleText());

                //5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)
                //打印=>解禁详细链接
                //utils_Html_jsoup.printHtmlAnchor_containsXXX_AsText(htmlpage_root,"/dxf/detail/300217");
                //5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接
                List<HtmlAnchor>    jjxqUrlList= Utils_Html.getUrlList_HtmlAnchor(htmlpage_root,"/dxf/detail/");
                //** ***********************************************************************//5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接
                for (HtmlAnchor jjxqurl:jjxqUrlList)
                {
                    htmlpage_root=jjxqurl.click();//5.点击月份-获取=>6.刷新后的页面=>7.过滤链接(解禁详细)=>8. 获取解禁详细链接=>9.点击解禁详细-获取解禁详细页面
                    //Utils_Html.printTable_containClass_AsText(htmlpage_root,".tab1");
                    Elements elements= new HtmlService().getTable_JsoupTable(htmlpage_root,".tab1","");//9.点击解禁详细-获取解禁详细页面=>10.获取解禁表格

                    HtmlService htmlService=new HtmlService();
                    htmlService.getTable_trList_Jsoup(elements,"no",connection);

                    htmlpage_root =null;
                    htmlService=null;

                }
                System.gc();
                i++;
                if(i==13) break;//控制月份[ 1月-12月 ]
            }
        }
        webclient.close();//关闭窗口
}





}