package com.zl.core.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;


public class utilTime extends Times{
	private static String time;
	private static String name;

/**
	 * @author yyyyMMddHHmmss
	 * @return yyyyMMddHHmmss
	 */
public static String gettime()
{
	try{
		SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyyMMddHHmmss");
		
		Date d = new Date();
		
		time=formattedFileName.format(d).toString();//格式化时间-（String）
	
	}catch(Exception o){
		
		o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
	}
	return time;
}

/*
*//**
 * simpDateFormat_Ymd="mm/dd/yyyy"
 * Ymd="08/30/2013"
 * @return yyyyMMddHHmmss
 *//*
public static long get_mdy_int(String simpDateFormat_Ymd,String Ymd)
{
	*//**
Timestamp t ;
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  try ...{
   t = new Timestamp(format.parse("2007-07-19 00:00:00").getTime());
  } catch (ParseException e) ...{
   e.printStackTrace();
  }
Timestamp t ;
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  t = new Timestamp(new Date().getTime()); 
	 *//*
	  SimpleDateFormat smp_format = new SimpleDateFormat("yyyy-MM-dd");
	     
	     long time_long=util.utilTime.get_mdy_int("MM/dd/yyyy", "12/01/1900");
	     
	     //new Date("12/01/1900").getTime(); 用下面这句代替

	     Date smp_format_ymd=smp_format.parse(Ymd);
	     
	     java.getSql.Timestamp tsp=new java.getSql.Timestamp(smp_format_ymd);
	     
	     System.out.println("tsp:"+smp_format.format(tsp));
return date_long;
}*/

/**
 * 
 * @return 20120401
 */
public static String getyyyyMMdd()
{
	try{
		SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyyMMdd");
		
		Date d = new Date();
		
		time=formattedFileName.format(d).toString();//格式化时间-（String）
	
	}catch(Exception o){
		
		o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
	}
	return time;
}
/**
 * @author yyyyMMddHHmmss
 * @return Long 20120401 05 01 13:01
 */
public static Long getTimeLong()
{
try{
	SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyyMMddHHmmss");
	
	Date d = new Date();
	
	time=formattedFileName.format(d).toString();//格式化时间-（String）
//System.out.println(utilTime);
}
catch(Exception o){
	
	o.printStackTrace();
	//System.out.println("X  获取当前时间字符串出错！");
}
return Long.valueOf(time);
}
/**
 * @author yyyyMMddHHmmss
 * @return Long yyyyMMddHHmmss
 */
public static Long getTimeLongHm()
{
try{
	SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyyMMddHHmmss sss");
	
	Date d = new Date();
	
	time=formattedFileName.format(d).toString();//格式化时间-（String）
	time=time.replaceAll(" ", "");
//System.out.println(utilTime);
}catch(Exception o){
	
	o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
}
return Long.valueOf(time);
}
	/**
	 *@yyyy-MM-dd HH:mm:ss
	 */
	public static String getDefaultTime(){

		try{
			
			SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d = new Date();
			
			time=formattedFileName.format(d).toString();//格式化时间-（String）
		
		}catch(Exception o){
			
			o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
		}
		return time;
}

	/**
	 *@yyyy-MM-dd HH:mm:ss
	 */
	public static String getYyyy_MM_dd_HH_mm_ss(){

		try{
			
			SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d = new Date();
			
			time=formattedFileName.format(d).toString();//格式化时间-（String）
		
		}catch(Exception o){
			
			o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
		}
		return time;
}
	/**
	 * 2012-04-01 18:00
	 * @return
	 */
	public static String getYyyy_MM_dd_HH_mm(String formatDateStr){

		try{
			
			SimpleDateFormat formattedFileName = new SimpleDateFormat(formatDateStr);
			
			Date d = new Date();
			
			time=formattedFileName.format(d).toString();//格式化时间-（String）
		
		}catch(Exception o){
			
			o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
		}
		return time;
}
	/*
	 *@yyyy-MM-dd
	 */
	public static String getYyyy_MM_dd(){

		try{
			
			SimpleDateFormat formattedFileName = new SimpleDateFormat("yyyy-MM-dd");
			
			Date d = new Date();
			
			time=formattedFileName.format(d).toString();//格式化时间-（String）
		
		}catch(Exception o){
			
			o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
		}
		return time;
}
	
	/**
	 * @author 获取当前时间
	 * yyyy-MM
	 * @return utilTime(String) / null
	 */
	public static String gettime(String datestr){
	
	try{
		
		SimpleDateFormat formattedFileName = new SimpleDateFormat(datestr);
		
		Date d = new Date();
		
		time=formattedFileName.format(d).toString();//格式化时间-（String）
	
	}catch(Exception o){
		
		o.printStackTrace();//System.out.println("X  获取当前时间字符串出错！");
	}
	
	return time;
	}
	
	
	/**
	 * @author 加N秒时间
	 * @return
	 */
	public static String add_time_second(Integer SECOND)
	{
		Calendar cal  = Calendar.getInstance(); 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    Date date1=null;
		try {
			date1 = format.parse(new utilTime().gettime("yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     long Time=(date1.getTime()/1000)+SECOND; 
	     date1.setTime(Time*1000); 
	     String mydate1=formatter.format(date1); 
	     //System.out.println(mydate1);
	
		return mydate1;
	}
	
	/**
	 * @author 加N分钟时间
	 * @setdate_ds  指定时间-yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String add_time_minute(Integer MINUTE,String setdate_ds)
	{
		Calendar cal  = Calendar.getInstance(); 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    SimpleDateFormat format     = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    Date date1=null;
		try {
			//date1 = format.parse(util.gettime("yyyy-MM-dd HH:mm:ss"));
			date1 = format.parse(setdate_ds);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Integer min=MINUTE*60;
	     long Time=(date1.getTime()/1000)+min; 
	     date1.setTime(Time*1000); 
	     String mydate1=formatter.format(date1); 
	     ////System.out.println(mydate1);
	
		return mydate1;
	}
	
	/**
	 * @author 加N小时
	 * @return
	 */
	public static String add_time_hour(Integer HOUR)
	{
		Calendar cal  = Calendar.getInstance(); 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    Date date1=null;
		try {
			date1 = format.parse(new utilTime().gettime("yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Integer hour=HOUR*60*60;
	     long Time=(date1.getTime()/1000)+hour; 
	     date1.setTime(Time*1000); 
	     String mydate1=formatter.format(date1); 
	    ////System.out.println(mydate1);
	
		return mydate1;
	}
	
	/**
	 * @author 加N天
	 * @return
	 */
	public static String add_time_day(Integer DAY)
	{
		Calendar cal  = Calendar.getInstance(); 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    Date date1=null;
		try {
			date1 = format.parse(new utilTime().gettime("yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Integer day=DAY*60*60*24;
	     long Time=(date1.getTime()/1000)+day; 
	     date1.setTime(Time*1000); 
	     String mydate1=formatter.format(date1); 
	     ////System.out.println(mydate1);
	
		return mydate1;
	}
	
	public static void calendar(){
		Calendar calendar = new GregorianCalendar(); 
		Date trialTime = new Date(); 
		calendar.setTime(trialTime); 


		// print out a bunch of interesting things 
		////System.out.println("ERA: " + calendar.get(Calendar.ERA)); 
		////System.out.println("年份: " + calendar.get(Calendar.YEAR)); 
		////System.out.println("月份: " + calendar.get(Calendar.MONTH)); 

		////System.out.println("当前年星期数: " + calendar.get(Calendar.WEEK_OF_YEAR)); 
		////System.out.println("当前月星期数: " + calendar.get(Calendar.WEEK_OF_MONTH)); 
		////System.out.println("月中的某天: " + calendar.get(Calendar.DATE)); 
		////System.out.println("月中的某天: " + calendar.get(Calendar.DAY_OF_MONTH)); 
		////System.out.println("当前年中的天数: " + calendar.get(Calendar.DAY_OF_YEAR)); 
		////System.out.println("星期中的某天: " + calendar.get(Calendar.DAY_OF_WEEK)); 
		//System.out.println("当前月第几个星期: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); 
		//System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM)); 
		//System.out.println("上午或下午的小时: " + calendar.get(Calendar.HOUR)); 
		//System.out.println("小时: " + calendar.get(Calendar.HOUR_OF_DAY)); 
		//System.out.println("分钟: " + calendar.get(Calendar.MINUTE)); 
		//System.out.println("秒: " + calendar.get(Calendar.SECOND)); 
		//System.out.println("毫秒: " + calendar.get(Calendar.MILLISECOND)); 
		//System.out.println("ZONE_OFFSET: " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); 
		//System.out.println("DST_OFFSET: " + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); 

		//System.out.println("Current Time, with hour reset to 3"); 
		calendar.clear(Calendar.HOUR_OF_DAY); // so doesn@#t override 
		calendar.set(Calendar.HOUR, 3); 
		//System.out.println("ERA: " + calendar.get(Calendar.ERA)); 
		//System.out.println("YEAR: " + calendar.get(Calendar.YEAR)); 
		//System.out.println("MONTH: " + calendar.get(Calendar.MONTH)); 
		//System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR)); 
		//System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH)); 
		//System.out.println("DATE: " + calendar.get(Calendar.DATE)); 
		//System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH)); 
		//System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR)); 
		//System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK)); 
		//System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); 
		//System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM)); 
		//System.out.println("HOUR: " + calendar.get(Calendar.HOUR)); 
		//System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY)); 
		//System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE)); 
		//System.out.println("SECOND: " + calendar.get(Calendar.SECOND)); 
		//System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND)); 
		//System.out.println("ZONE_OFFSET: " + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours 
		//System.out.println("DST_OFFSET: " + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours  
		

	}
	
	/**
	 * @throws ParseException 
	 * 
	 */
	public static void main(String[] a) throws ParseException
	{
		Long tm=new utilTime().getTimeLong();
		Long t=(long) 20120418103239L;
		
		
		//System.out.println(util.utilTime.get_mdy_int("MM/dd/yyyy", "12/01/1900"));
		
	/*	Calendar cal  = Calendar.getInstance();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    Date date1=null;
		try {
			date1 = format.parse(util.utilTime.utilTime.gettime("yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 Integer day=1*60*60*24;
	     long Time=(date1.getTime()/1000)+day; 
	     date1.setTime(Time*1000); 
	     
	     String mydate1=formatter.format(date1); 
	     String da_str=formatter.format(date1.getTime()/1000 ); 
	     
	     
	     SimpleDateFormat smp_format = new SimpleDateFormat("yyyy-MM-dd");
	     
	   //new Date("12/01/1900").getTime(); 用下面这句代替

	     Date smp_format_ymd_date=smp_format.parse("12/01/1900");
	     
	    // long time_long=util.utilTime.get_mdy_int("MM/dd/yyyy", "12/01/1900");
	     java.getSql.Timestamp tsp=new java.getSql.Timestamp(smp_format_ymd_date.getTime());
	    
	     
	     

	     System.out.println("tsp:"+smp_format.format(tsp));

	       */


		;
/*		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));

		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));

		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));
		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));
		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));
		System.out.println("毫秒: " +util.utilTime.utilTime.gettime("yyMMddHHmm sss"));*/
	    // System.out.println(da_str);
	
		//System.out.println(t);
		//System.out.println(tm<t);
		
		Calendar calendar = new GregorianCalendar();
		Date trialTime = new Date(); 
		calendar.setTime(trialTime);
		/*


		YEAR			指示年的 get 和 set 的字段数字。
		MONTH           指示月份的 get 和 set 的字段数字
		DATE          get 和 set 的字段数字，指示一个月中的某天

		HOUR_OF_DAY     get 和 set 的字段数字，指示一天中的小时
		MINUTE			get 和 set 的字段数字，指示一小时中的分钟。
		SECOND			get 和 set 的字段数字，指示一分钟中的秒
		MILLISECOND		get 和 set 的字段数字，指示一秒中的毫秒
		*/
		int month=calendar.get(Calendar.MONDAY)+1;
		System.out.println("时间: " + new utilTime().gettime("yy")+month + calendar.get(Calendar.DATE)+ calendar.get(Calendar.HOUR_OF_DAY)+ calendar.get(Calendar.MINUTE)+ calendar.get(Calendar.MILLISECOND));
		System.out.println("时间: " + calendar.get(Calendar.YEAR)+month + calendar.get(Calendar.DATE)+ calendar.get(Calendar.HOUR_OF_DAY)+ calendar.get(Calendar.MINUTE)+ calendar.get(Calendar.MILLISECOND));
		System.out.println("时间: " + calendar.get(Calendar.YEAR)+month + calendar.get(Calendar.DATE)+ calendar.get(Calendar.HOUR_OF_DAY)+ calendar.get(Calendar.MINUTE)+ calendar.get(Calendar.MILLISECOND));
		System.out.println("时间: " + calendar.get(Calendar.YEAR)+month + calendar.get(Calendar.DATE)+ calendar.get(Calendar.HOUR_OF_DAY)+ calendar.get(Calendar.MINUTE)+ calendar.get(Calendar.MILLISECOND));

		long r1 = System.currentTimeMillis();
		//返回带正号的 double 值，大于或等于 0.0，小于 1.0。
		double r2 = Math.random();
		//通过Random类来获取下一个随机的整数
		int r3 = new Random().nextInt();
		System.out.println("r1 = " + r1);
		System.out.println("r3 = " + r2);
		System.out.println("r2 = " + r3);
		/*util.utilTime.utilTime.testNoSeed();
		util.utilTime.utilTime.testSeed1();
		util.utilTime.utilTime.testSeed1();*/

		}


	public static void testNoSeed() {
		System.out.println("--------------testNoSeed()--------------");
		//创建不带种子的测试Random对象
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.println(random.nextInt());
		}
	}
	public static void testSeed1() {
		System.out.println("--------------testSeed1()--------------");
		//创建带种子的测试Random对象
		Random random = new Random(555L);
		for (int i = 0; i < 3; i++) {
			System.out.println(random.nextInt());
		}
	}
	public static void testSeed2()
	{
		System.out.println("--------------testSeed2()--------------");
		//创建带种子的测试Random对象
		Random random = new Random();
		random.setSeed(555L);
		for (int i = 0; i < 3; i++) {
			System.out.println(random.nextInt());
		}
	}


	}
