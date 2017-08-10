package com.zl.spring.springmvc;


public class jsonpAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*
	public  void Jsonp()
	{
		User user=new User();
		HttpResponse httprp =null;
		SessionJson.JsonpWrite(user, (HttpServletResponse) httprp);//这里只是测试用,正式环境要给httpRespones 赋值才能用
	}
*/

	/*
	private Hyfp hyfp;//基本信息
	private List<fyxmje> hyfpdkxx;//代开信息
	
	

	//增值税专用发票
	private Zyfp zyfp;//基本信息
	private List<Hwyslw> zyfpdkxx;//代开信息
	//普通发票
	private Ptfp ptfp;//基本信息
	private List<ptfp_Xxxx> ptfxdkxx;//代开信息
	private YqsbJbxx yqsbjbxx;
	private List<YqsbSqxx> list;

	*//**
	 * 查询货运发票的方法
	 *//*
	public void QueryHyfp() {
		System.out.println("进入货运发票查询");
		String slhm =null;
		slhm =hyfp.getSlhm();// 得到货运发票编号
		hyfp = hyfpservice.fp_hyfp_query(slhm);
		hyfpdkxx = (List<fyxmje>)hyfpservice.getfyxx(slhm);
		//如果查询到了该用户，则改变受理状态为已受理，并更新表
		if(hyfp!=null)
		{
		hyfp.setSlzt("已受理");
		fpdkglservice.update(hyfp);
		}
		String hyfpStr=SessionJson.getJsonStr(hyfp);
		String DkxxStr=SessionJson.getJsonStr(hyfpdkxx);
		String JsonStr="{jbxx:"+hyfpStr+",dkxx:"+DkxxStr+"}";
		SessionJson.JsonpWrite(JsonStr);
	}

	*//**
	 * 查询专业发票的方法
	 *//*
	public void QueryZyfp() {
		System.out.println("进入方法");
		// 得到受理号码
		String slhm =null;
		slhm =zyfp.getSlhm();
		// 通过受理号码查询出专用发票对象
		System.out.println("开始查询");
		List<Zyfp> list=zyfpservice.querybyslhm(slhm);
		zyfp =list.get(0);
		//如果查出的对象不为空，则改变受理状态为已受理，并更新表
		if(zyfp!=null)
		{
		zyfp.setSlzt("已受理");
		zyfpservice.update(zyfp);
		}
		// 得到JSON对象
		String JsonStr =null;
		JsonStr =JSON.toJSONString(zyfp);
		System.out.println(JsonStr);
		SessionJson.JsonpWrite(JsonStr);
	}

	*//**
	 * 查询普通发票的方法 填屏接口方法
	 *//*
	public void QueryPtfp() {
		//得到受理号码
		String slhm =null;
		slhm =ptfp.getSlhm();
		//通过受理号码查询发票对象
		ptfp = ptfpservice.fp_ptfp_query(slhm);
		ptfxdkxx = (List<ptfp_Xxxx>)ptfpservice.getptxx(slhm);
		//如果对象不为空，则改变受理状态为已受理，并更新表
		if(ptfp!=null)
		{
		ptfp.setSlzt("已受理");
		fpdkglservice.update(ptfp);
		}
		//得到json对象
		String ptfpStr=SessionJson.getJsonStr(ptfp);
		String DkxxStr=SessionJson.getJsonStr(ptfxdkxx);
		String JsonStr="{jbxx:"+ptfpStr+",dkxx:"+DkxxStr+"}";
		SessionJson.JsonpWrite(JsonStr);
	}
*/

	
}