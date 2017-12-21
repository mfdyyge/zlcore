
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.zl.core.jdbc.apche.dbutils.dao.SqlDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HtmlService{
    static ResourceBundle resourceBundle;
    private static String xh;
    private static String qymc;//解禁企业代号 | 解禁企业名称
    static Connection connection;
    static String insert="insert into DFCF_JJQY_MX(xh1,JJQYMC,GDMC2,JJRQ3,XZKSSGF4,XSGLX5,XXLY6) values(?,?,?,?,?,?,?)";
    //------------------------------------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void  DsFactory_test()
    {

        Object [] params = new Object[]{"001896","967.74"};

        int zt=SqlDao.addOrUp(connection,insert,params);
        System.out.println("zt = " + zt);
    }

    /**
     * 功能: 处理Table 行
     * @param tables
     */
    public final   void getTable_trList_Jsoup(Elements tables,String print_yes_no,Connection connection)
    {

        Elements tr_list_class_eve;//行class=list_eve 属性
        Elements tr_list_class_odd;//行class=list_odd 属性

        Object [] params ;
        String XH1;
        String GDMC2;
        String JJRQ3;
        String XZKSSGF4;
        String XSGLX5;
        String XXLY6;
        String JJQYMC;

        if ("".equals(print_yes_no) || null==print_yes_no){
            print_yes_no="no";
        }

        for (int i = 0; i < tables.size(); i++)
        {


            //System.out.println("tables = " + tables.get(i).text());
            //获取每一行的列

            tr_list_class_eve = tables.get(i).select(".list_eve");//获取 行 注意:class  属性必须加".list_odd"
            for (Element tr:tr_list_class_eve)//1.开始注入数据库
            {


                if("yes".equals(print_yes_no)){
                    System.out.println("打印列 = " + tr.getElementsByTag("td").get(1).text());
                }
                XH1		    =xh.trim();
                JJQYMC	    =qymc.trim();
                GDMC2	    =tr.getElementsByTag("td").get(1).text().trim();
                JJRQ3	    =tr.getElementsByTag("td").get(2).text().trim();
                XZKSSGF4	=tr.getElementsByTag("td").get(3).text().trim();
                XSGLX5	    =tr.getElementsByTag("td").get(4).text().trim();
                XXLY6       =tr.getElementsByTag("td").get(5).text().trim();

                params = new Object[]{XH1,JJQYMC,GDMC2,JJRQ3,XZKSSGF4,XSGLX5,XXLY6};

                int zt=SqlDao.addOrUp(connection,insert,params);

            }
            /////////////////////////////////////////////////////////////////////////////////////////////////

            tr_list_class_odd = tables.get(i).select(".list_odd");//获取 行
            for (Element tr:tr_list_class_odd)//1.开始注入数据库
            {
                if("yes".equals(print_yes_no)){
                    System.out.println("打印列 = " + tr.getElementsByTag("td").get(1).text());
                }
                XH1		    =xh.trim();
                JJQYMC	    =qymc.trim();
                GDMC2	    =tr.getElementsByTag("td").get(1).text().trim();
                JJRQ3	    =tr.getElementsByTag("td").get(2).text().trim();
                XZKSSGF4	=tr.getElementsByTag("td").get(3).text().trim();
                XSGLX5	    =tr.getElementsByTag("td").get(4).text().trim();
                XXLY6       =tr.getElementsByTag("td").get(5).text().trim();

                params = new Object[]{XH1,JJQYMC,GDMC2,JJRQ3,XZKSSGF4,XSGLX5,XXLY6};

                int zt=SqlDao.addOrUp(connection,insert,params);
            }
        }


    }

    /**
     *  功能:查询包含"table_Class"字符串的Jsoup.Tab对象
     * @param htmlpage      页面对象
     * @param table_Class   class="tab1" 包含的字符
     * @param print_Yes_No  启用打印:[yes | no ],默认不打印,可以不设置值 =>getTable_JsoupTable(jjxqHtmlPage,".tab1","")
     * @return
     */
    public     Elements getTable_JsoupTable(HtmlPage htmlpage, String table_Class,String print_Yes_No)
    {

        String html=htmlpage.asXml();
        System.out.println("-------jsoup部分------");
        Document doc = Jsoup.parse(html);

        Element titleDIV=doc.getElementById("Div10").select(".tit").first();//解禁企业代号 | 解禁企业名称
        qymc=titleDIV.text();//豫能控股（001896）解禁历史一览
        String[] mc_dm=qymc.split("）");
        System.out.println("解禁企业名称 = " + mc_dm[0]+"   解禁企业代码 = "+mc_dm[1]);
        qymc=mc_dm[0];
        String[] mc_dm2=qymc.split("（");
        qymc=mc_dm2[0];
        xh=mc_dm2[1];
        System.out.println("解禁企业名称 = " + mc_dm2[0]+"   解禁企业代码 = "+mc_dm2[1]);

        //Document doc = Jsoup.parse(pageXml);
        Elements tableElements  = doc.select(table_Class);//必须注意参数格式 [".tab1"]=> 获取[Table]表格
        //Element element = doc.select(".tab1").get(0);
        //element.getElementsByTag("tr").size()
        //element.getElementsByTag("tr").get(21).text()
        System.out.println("解禁历史-表格数量 = " + tableElements .size());

        if("".equals(print_Yes_No)|| null==print_Yes_No)print_Yes_No="no";//默认不打印详情
        if("yes".equals(print_Yes_No))//是否打印详细列表
        {
            for (Element el:tableElements )
            {
                System.out.println(el.text());
            }
        }


        return  tableElements ;
    }













    /**
     *  功能:查询包含"table_Class"字符串的Jsoup.Tab对象
     * @param htmlpageStr      页面对象
     * @param table_Class   class="tab1" 包含的字符
     * @param print_Yes_No  启用打印:[yes | no ],默认不打印,可以不设置值 =>getTable_JsoupTable(jjxqHtmlPage,".tab1","")
     * @return
     */
    public     Elements getTable_JsoupTable(String htmlpageStr, String table_Class,String print_Yes_No)
    {

        System.out.println("-------jsoup部分------");
        Document doc = Jsoup.parse(htmlpageStr);

        Element titleDIV=doc.getElementById("Div10").select(".tit").first();//解禁企业代号 | 解禁企业名称
        qymc=titleDIV.text();//豫能控股（001896）解禁历史一览
        String[] mc_dm=qymc.split("）");
        System.out.println("解禁企业名称 = " + mc_dm[0]+"   解禁企业代码 = "+mc_dm[1]);
        qymc=mc_dm[0];
        String[] mc_dm2=qymc.split("（");
        qymc=mc_dm2[0];
        xh=mc_dm2[1];
        System.out.println("解禁企业名称 = " + mc_dm2[0]+"   解禁企业代码 = "+mc_dm2[1]);

        //Document doc = Jsoup.parse(pageXml);
        Elements tableElements  = doc.select(table_Class);//必须注意参数格式 [".tab1"]=> 获取[Table]表格
        //Element element = doc.select(".tab1").get(0);
        //element.getElementsByTag("tr").size()
        //element.getElementsByTag("tr").get(21).text()
        System.out.println("解禁历史-表格数量 = " + tableElements .size());

        if("".equals(print_Yes_No)|| null==print_Yes_No)print_Yes_No="no";//默认不打印详情
        if("yes".equals(print_Yes_No))//是否打印详细列表
        {
            for (Element el:tableElements )
            {
                System.out.println(el.text());
            }
        }


        return  tableElements ;
    }












    /**
     *  功能:返回 包含"inURL"字符串的A标签对象
     *
     * @param htmlpage      页面对象
     * @param inURL         a.Href 包含的字符
     * @return
     * @throws IOException
     */
    public   List<HtmlAnchor> getUrlList_HtmlAnchor(HtmlPage htmlpage, String inURL) throws IOException
    {
        List<HtmlAnchor>    achList=htmlpage.getAnchors();// 获取页面所有链接
        List<HtmlAnchor>    newUrlList=new ArrayList<HtmlAnchor>();// 获取页面所有链接
        String              newUrl="";
        HtmlPage            newHtml;//打开的页面

        for(HtmlAnchor url:achList)
        {
            newUrl=url.getHrefAttribute().trim();//获取当前链接对象的 URL字符串

            if(newUrl.contains(inURL))//如果包含指定字符就添加到List
            {

                System.out.println("找到:"+inURL);//http://data.eastmoney.com/dxf/detail/603660.html#2017-12-01
                newUrlList.add(url);//
            }
        }

        return newUrlList;
    }



    /**
     *  功能:返回 包含"inURL"字符串A标签List
     *
     * @param htmlpage      页面对象
     * @param inURL         a.Href 包含的字符
     * @return
     * @throws IOException
     */
    public     List<String> getUrlList_Str(HtmlPage htmlpage, String inURL) throws IOException
    {
                /*
        * 获取页中所有的链接
        *  解禁链接:/dxf/detail/
        * */
        List<HtmlAnchor>    achList=htmlpage.getAnchors();// 获取页面所有链接
        List<String>        newUrlList=new ArrayList<String>();// 获取页面所有链接
        String              newUrl="";
        HtmlPage            newHtml;//打开的页面

        for(HtmlAnchor url:achList)
        {
            newUrl=url.getHrefAttribute().trim();//获取当前链接对象的 URL字符串

            if(newUrl.contains(inURL))//如果包含指定字符就添加到List
            {

                System.out.println("找到:"+inURL);//http://data.eastmoney.com/dxf/detail/603660.html#2017-12-01
                newUrlList.add(newUrl);//
            }
        }

        return newUrlList;
    }




    /**
     *  功能:打印 包含"inURL"字符串A标签
     *
     * @param htmlpage      页面对象
     * @param inURL         a.Href 包含的字符
     * @return
     * @throws IOException
     */
    public     void printHtmlAnchor_containsXXX_AsText(HtmlPage htmlpage, String inURL) throws IOException
    {
                /*
        * 获取页中所有的链接
        *  解禁链接:/dxf/detail/
        * */
        List<HtmlAnchor>    achList=htmlpage.getAnchors();// 获取页面所有链接
        List<String>        newUrlList=new ArrayList<String>();// 获取页面所有链接
        String              newUrl="";
        HtmlPage            newHtml;//打开的页面

        for(HtmlAnchor url:achList)
        {
            newUrl=url.getHrefAttribute().trim();//获取当前链接对象的 URL字符串

            if(newUrl.contains(inURL))//如果包含指定字符就添加到List
            {

                System.out.println("找到:"+newUrl);//http://data.eastmoney.com/dxf/detail/603660.html#2017-12-01
                //newUrlList.add(newUrl);//
            }
        }

    }



    /**
     *
     * 功能:打印 包含".class"属性字符串的Tab对象
     * @param htmlpage      页面对象
     * @param table_Class   table_Class=".tab1" 包含的字符
     * @return
     * @throws IOException
     */
    public     void printTable_containClass_AsText(HtmlPage htmlpage, String table_Class)
    {
        String html=htmlpage.asXml();
        System.out.println("-------jsoup部分------");
        Document doc = Jsoup.parse(html);
        Element titleDIV=doc.getElementById("Div10");
        System.out.println("titleDIV = " + titleDIV.text());

/*
        java.util.List<HtmlAnchor> achList = htmlpage.getAnchors();
        for (HtmlAnchor ach : achList) {
            System.out.println(ach.getHrefAttribute());
        }
*/

        //Document doc = Jsoup.parse(pageXml);
        Elements elementList = doc.select(table_Class);//必须注意参数格式 [".tab1"]
        System.out.println("解禁历史-表格数量 = " + elementList.size());

        for (Element el:elementList)
        {

            System.out.println(el.text());
        }


/*        System.out.println("tr 数量:"+element.getElementsByTag("tr").size());
        System.out.println(element.getElementsByTag("tr").get(0).text());
        System.out.println(element.getElementsByTag("tr").get(21).text());*/
/*
        System.out.println(element.getElementsByTag("tr").get(1).text());
        System.out.println(element.getElementsByTag("tr").get(2).text());
*/

    }

}
