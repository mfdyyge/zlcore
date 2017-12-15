package zl.htmlunit;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils_HtmlUnit {


    /**
     *
     *  查询包含"X"字符串的Tab对象
     * @param htmlpage      页面对象
     * @param tableClass_contain   class="tab1" 包含的字符
     * @return
     * @throws IOException
     */
    public List<HtmlTable> getTable_contain(HtmlPage htmlpage, String tableClass_contain)
    {

        List<HtmlTable> htmlTableList=new ArrayList<HtmlTable>();
        //htmlTableList=(HtmlTable)htmlpage.getTabbableElements();

        String pageUrl=htmlpage.getUrl().toString();//
        //String pageXml = htmlpage.asXml();      // 以xml的形式获取响应文本

        //String htmlpageText = htmlpage.asText();// text只会获取里面的文本,网页html标签和script脚本会被去掉
        System.out.println("-------HtmlPageUrl部分------");
        System.out.println(pageUrl);


        //////////////////////////////////////////////////////////////////////////////
        // 方法一，通过get方法获取
        // HtmlButton submit = (HtmlButton) htmlpage.getElementById("loginBtn");

        // 方法二，通过XPath获取，XPath通常用于无法通过Id搜索，或者需要更为复杂的搜索时
        //HtmlDivision div = (HtmlDivision) htmlpage.getByXPath("//div").get(0);

        // 网络爬虫中主要目的就是获取页面中所有的链接

/*
        java.util.List<HtmlAnchor> achList = htmlpage.getAnchors();
        for (HtmlAnchor ach : achList) {
            System.out.println(ach.getHrefAttribute());
        }*/

        System.out.println("-------jsoup部分------");
        // 服务器端进行校验并清除有害的HTML代码,防止富文本提交有害代码
        //Jsoup.clean(pageXml, Whitelist.basic());
        /** jsoup解析文档 */
        // 把String转化成document格式

        Document doc = null;
        try {
            doc = Jsoup.connect(pageUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Document doc = Jsoup.parse(pageXml);
        Element element = doc.select(".tab1").get(0);//必须注意参数格式 [".tab1"]
        System.out.println(element.text());
/*        System.out.println("tr 数量:"+element.getElementsByTag("tr").size());
        System.out.println(element.getElementsByTag("tr").get(0).text());
        System.out.println(element.getElementsByTag("tr").get(21).text());*/
/*
        System.out.println(element.getElementsByTag("tr").get(1).text());
        System.out.println(element.getElementsByTag("tr").get(2).text());
*/
        return  htmlTableList;
    }

    /**
     *  查询包含"X"字符串的A标签对象
     * @param htmlpage      页面对象
     * @param inURL         a.Href 包含的字符
     * @return
     * @throws IOException
     */
    public void getAnchors_contain(HtmlPage htmlpage, String inURL) throws IOException
    {
                /*
        * 获取页中所有的链接
        *  解禁链接:/dxf/detail/
        * */
        List<HtmlAnchor> achList=htmlpage.getAnchors();// 获取页面所有链接
        String url="";
        HtmlPage html;//打开的页面

        for(HtmlAnchor ach:achList)
        {
            url=ach.getHrefAttribute().trim();
            //System.out.println("url:"+url);//http://data.eastmoney.com/dxf/detail/603660.html#2017-12-01
            if(url.contains(inURL))
            {

                System.out.println("找到:"+inURL);//http://data.eastmoney.com/dxf/detail/603660.html#2017-12-01

                HtmlPage p = ach.click();//打开链接
                System.out.println(p.getElementById("Div10").asText());

                /*HtmlPage htmlPage_qyxx = ach.click();
                System.out.println("htmlPage_qyxx.getUrl().toString() = " + htmlPage_qyxx.getUrl().toString());*/
                //getTable_contain(htmlPage_qyxx,"");
                break;//测试时找到指定的一个链接就退出
            }
        }

    }
}
