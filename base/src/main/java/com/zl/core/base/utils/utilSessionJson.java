package com.zl.core.base.utils;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * 
 * @author 		周路
 * @TimeApp   		2011/11/05 17:01
 * @see			
 * @category
 * @version		2012/03/06  第4次修定 = 2012/03/30  第5次修定
 */
public class utilSessionJson {

		private static Writer write;
		private static PrintWriter printWriter;
		private static JSON json;
		private static String name;
		private static Object object;
		private static List list;

		

/**
 * @type  List
 * @param list
 * @return
 */
public static String getJsonStr(List list){	return JSON.toJSONString(list);}
/**
 * @type Object
 * @param obj
 * @return
 */
public static String getJsonStr(Object obj){return JSON.toJSONString(obj);}


/**
 *
 */
public static void JsonpWrite(Object obj ,HttpServletResponse response)
{
		//HttpServletResponse response=response;
		String jsonstr=JSON.toJSONString(obj);


		PrintWriter out= null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/javascript; charset=UTF-8");
			out = response.getWriter();
			String jsonp = (new StringBuilder("try {callback_function(")).append(jsonstr).append(");} catch (e) { alert(\"fhrnsrsbh=\"+fhrnsrsbh+\"\\n\"+e);}").toString();
			System.out.println((new StringBuilder("jsonp=\n")).append(jsonp).toString());
			out.write(jsonp);
		}
		catch(IOException e) {
			System.out.print("方法异常,请定位问题,及时处理！");
		}
		catch(Exception exception){
			System.out.print("方法异常,请定位问题,及时处理！");
		}
		finally{
			out.close();
		}
}

public Writer getWrite() {return write;}
public JSON getJson() {return json;}
public  void setJson(JSON json) {
	utilSessionJson.json = json;}
}