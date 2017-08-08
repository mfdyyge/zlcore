
//纳税人账户账号
function nsrck()
{
	var nsrck_data;
	
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_nsrck='http://98.12.100.191:10086/ws/queryNsrcktoJson.action?nsrck.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_nsrck,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								nsrck_data=jsonObj;
							jQuery("input[name='sqrxm'][type!='hidden']").val(nsrck_data.jbxx.sqr);//申请人
								jQuery("input[name='bgrq'][type!='hidden']").val(nsrck_data.jbxx.bgdwrq);//报告日期
//								for(var i=0;i<nsrck_data.sqxx.length;i++)
//								{
//									    var obj=nsrck_data.sqxx[i];
//										var nsrckdataObj = {"tds":{
//																//"yhzhxzDm":{"value":obj.zhxz},//账户性质
//																"yhzhxzDm":{"value":obj.yhzhxzDm},
//																
//																//"yhhbDm":{"value":obj.khyh},//开户银行
//																"yhhbDm":{"value":obj.yhhbDm},
//																
//																"yhzh":{"value":obj.zh},//银行账号
//																
//																"khrq":{"value":obj.khsj},//开户日期
//																"bgrq":{"value":obj.bgsj},//变更日期
//																"zxrq":{"value":obj.zxsj},//变更日期
//																"bz":{"value":obj.bz},//备注
//																
//															
//															}
//														};
//										
//										$w('yhzhxxGrid').insertRow(nsrckdataObj);
//									
//								}
//								
								
								
								

							}
						});
					});
		
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
nsrck();