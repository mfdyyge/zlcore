package zl.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.List;

public class HtmlGetAjax
{
   public static void main(String[] args) throws IOException {
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
        webclient.getOptions().setTimeout(5000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
        webclient.getOptions().setDoNotTrackEnabled(false);
        webclient.setJavaScriptTimeout(8000);//设置js运行超时时间
        webclient.waitForBackgroundJavaScript(500);//设置页面等待js响应时间,
        //webclient.setAjaxController(new NicelyResynchronizingAjaxController());


        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
        /*
        * 默认加载:2017.12 月数据-解禁企业列表
        * */
       HtmlPage htmlpage_root = (HtmlPage) webclient.getPage("http://data.eastmoney.com/dxf/default.html");


        //webclient.waitForBackgroundJavaScript(10000);

        // 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
/*        final HtmlForm form = htmlpage.getFormByName("f");
        // 同样道理，获取”百度一下“这个按钮
        final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("百度一下");
        // 得到搜索框
        final HtmlTextInput textField = (HtmlTextInput) form.getInputByName("q1");*/

        //final HTMLDivElement divElement=


        //** ***********************************************************************1 年份 [select:id=seleyear]-选择2015年
        //获取第一个数据库
       final HtmlSelect hs = (HtmlSelect) htmlpage_root.getElementById("seleyear");
        System.out.println("正在跳转…"+hs.getOption(3).getText());
        //按要求选择第一个数据库 - 获取刷新后的页面--选择2015年
        htmlpage_root= (HtmlPage) hs.getOption(3).setSelected(true);//


        //** ***********************************************************************2 月份 [a:id=month_X]-选择 1 月份
        List<HtmlAnchor> achList= htmlpage_root.getAnchors();
        String anchor_id="";
        int i=1;
        for(HtmlAnchor ach:achList)
        {

            anchor_id=ach.getId();
            //if(anchor_id.contains("month_1"))//过滤id 包含"month_"月份<a>标签
            if(anchor_id.equals("month_"+i))//过滤id 包含"month_"月份<a>标签
            {

                System.out.println("点击月份="+ach.asText());//
                System.out.println("anchor_id="+anchor_id);


                //模拟点击Next按钮，跳转到第二个页面
                HtmlPage htmlPage = ach.click(); //点击月份

                String table_jjqy_list_str=htmlpage_root.getElementById("table_listcontent").getFirstElementChild().asText();
                System.out.println("= " +table_jjqy_list_str );;
                System.out.println("解禁详细数据,保存中......." );
                System.out.println("title = " + htmlPage.getTitleText());

                //** ***********************************************************************3  处理解禁详细页面
                //处理子页面(解禁详细)
                GetHtml getHtml=new GetHtml();
                getHtml.getAnchors_contain(htmlPage,"/dxf/detail/300217");

            /*
                HtmlPage p = ach.click(); //点击月份按钮
                //遍历 打开的网页内容
                System.out.println("遍历 打开的网页内容 = ");
                System.out.println(p.getFullyQualifiedUrl("ID=953"));
                break;
            */
                i++;
                if(i==13) break;//控制月份[ 1月-12月 ]
            }
        }


        webclient.close();//关闭窗口
    }





}