//汇总认定
function hzns()
{
	var hzns_data;
	
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_hzns='http://98.12.100.191:10086/ws/queryHznstoJson.action?hzns.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_hzns,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								hzns_data=jsonObj;
							jQuery("input[name='nsrsbh'][type!='hidden']").val(hzns_data.jbxx.nsrsbh);//纳税人识别号
							jQuery("input[name='nsrmc'][type!='hidden']").val(hzns_data.jbxx.nsrmc);//纳税人名称
							jQuery("input[name='spwh'][type!='hidden']").val(hzns_data.jbxx.spwh);//审批文号
							jQuery("input[name='fwjgmc'][type!='hidden']").val(hzns_data.jbxx.fwjg);//发文机关
							jQuery("input[name='fwjgmc'][type!='hidden']").val(hzns_data.jbxx.ssswjg);//所属税务机关
							jQuery("input[name='ssswjgDm'][type!='hidden']").attr('realvalue',hzns_data.jbxx.ssswjgdm);//所属税务机关
							jQuery("input[name='sqrq'][type!='hidden']").val(hzns_data.jbxx.sqrq);//申请日期
							jQuery("input[name='hznsfwDm'][type!='hidden']").val(hzns_data.jbxx.hznsfw);//汇总纳税范围名字
							jQuery("input[name='hznsfwDm'][type!='hidden']").attr('realvalue',hzns_data.jbxx.hznsfwdm);//汇总纳税范围
								for(var i=0;i<hzns_data.sqxx.length;i++)
								{
									    var obj=hzns_data.sqxx[i];
										var hznsdataObj = {"tds":{
																"bhznsrsfsqbz":{"value":obj.sfsq},//是否申请
																"ynsms":{"value":obj.ynsms},//原纳税模式
																"nsrsbh":{"value":obj.lnsrsbh},//纳税人识别号
																"nsrmc":{"value":obj.lnrsmc},//纳税人名称
																"zcdz":{"value":obj.addr},//地址
																"djzclxDm":{"value":obj.djzclx},//登记注册类型
																"sl":{"value":obj.sl},//税率
																"sfwfzjg":{"value":obj.sffzjg}//是否分支机构
															}
														};
										
										$w('bhznsrqdGrid').insertRow(hznsdataObj);
									
								}
							}
						});
					});
		
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
hzns();