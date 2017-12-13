package zl.htmlunit;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class EmailLogin {

	public static void main(String[] args) {
		
		try {  
            //创建一个webclient  
            WebClient webClient = new WebClient(BrowserVersion.CHROME);

            //参数设置  
            // 1 启动JS  
            webClient.getOptions().setJavaScriptEnabled(true);  
            // 2 禁用Css，可避免自动二次请求CSS进行渲染  
            webClient.getOptions().setCssEnabled(false);  
            //3 启动客户端重定向  
            webClient.getOptions().setRedirectEnabled(true);  
            // 4 运行错误时，是否抛出异常  
            webClient.getOptions().setThrowExceptionOnScriptError(false);  
            // 5 设置超时  
            webClient.getOptions().setTimeout(50000);  
            //6 设置忽略证书  
            //webClient.getOptions().setUseInsecureSSL(true);  
            //7 设置Ajax  
            //webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
            //8设置cookie  
            webClient.getCookieManager().setCookiesEnabled(true);  
              
            //获取页面  
            HtmlPage page = webClient.getPage("http://3g.ganji.com/bj_user/login/?username_login=0&ifid=new_shouye_cpdenglu");    
            // 根据form的名字获取页面表单，也可以通过索引来获取：page.getForms().get(0)     
            //根据form的action获取页面表单
            HtmlForm form = page.getFirstByXPath("//form[@action='/bj_user/login/?ifid=new_shouye_cpdenglu']");      
            HtmlTextInput username = (HtmlTextInput) form.getInputByName("username");  
            HtmlTextInput password = (HtmlTextInput) form.getInputByName("password");  
            username.setValueAttribute("waswas001");  
            password.setValueAttribute("741963a");
            
            HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("登录");
            
            //HtmlButton button =(HtmlButton)page.getHtmlElementById("loginBtn");
            //page.getElementsByTagName("");
            HtmlPage retPage = (HtmlPage) button.click();  
            // 等待JS驱动dom完成获得还原后的网页
            webClient.waitForBackgroundJavaScript(10000);  
            //输出网页内容  
            System.out.println(retPage.asXml());
            //获取cookie  
            Set<Cookie> cookies = webClient.getCookieManager().getCookies();;
            Map<String, String> responseCookies = new HashMap<String, String>();
            for (Cookie c : cookies) {  
                responseCookies.put(c.getName(), c.getValue());  
                System.out.print(c.getName()+":"+c.getValue());
            }
            
            
            //关闭webclient  
            webClient.close();    
            }catch (Exception e) {
            System.err.println( "Exception: " + e ); }

	}

}
