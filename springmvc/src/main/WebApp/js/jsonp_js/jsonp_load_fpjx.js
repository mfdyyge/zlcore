//发票缴销
function fpjx()
{
	var fpjx_data;
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_fpjx='http://98.12.100.191:10086/ws/queryFpjxtoJson.action?fpjx.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_fpjx,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								fpjx_data=jsonObj;
								jQuery("input[name='nsrsbh'][type!='hidden']").val(fpjx_data.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='nsrmc'][type!='hidden']").val(fpjx_data.jbxx.nsrmc);//纳税人名称
							    jQuery("input[name='sqrxm'][type!='hidden']").val(fpjx_data.jbxx.sqr);//申请人
								jQuery("input[name='sqrq'][type!='hidden']").val(fpjx_data.jbxx.sqrq);//申请日期
								jQuery("input[name='jxyy'][type!='hidden']").val(fpjx_data.jbxx.jxyy);//申请日期
								
								
								for(var i=0;i<fpjx_data.sqxx.length;i++)
								{
									    var obj=fpjx_data.sqxx[i];
										var fpjxdataObj = {"tds":{
																"fpzlDm":{"value":obj.fpmc},//发票名称
																"fpDm":{"value":obj.fpdm},//发票代码
																"jxdxDm":{"value":obj.jxdxDm},//缴销对象代码
																"fpjxlxDm":{"value":obj.fpjxlxDm},//缴销类型
																"jldwDm":{"value":obj.dw},//计量单位代码
																"fpsl":{"value":obj.sl},//数量
																"fpqshm":{"value":obj.qshm},//起始号码
																"fpzzhm":{"value":obj.zzhm},//终止号码
																"je":{"value":obj.je}//金额
																
															}
														};
										
										$w('fpjxsqmxGrid').insertRow(fpjxdataObj);
									
								}
							}
						});
					});
		}catch(e){
		alert("extends\n"+e);
	}
}
fpjx();