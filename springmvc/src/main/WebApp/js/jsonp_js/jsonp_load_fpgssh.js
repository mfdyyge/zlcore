//发票挂失损毁
function fpgssh()
{
	var fpgssh_data;
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_fpgssh='http://98.12.100.191:10086/ws/queryFpgsshtoJson.action?fpgssh.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_fpgssh,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								fpgssh_data=jsonObj;
								
								
								jQuery("input[name='nsrsbh'][type!='hidden']").val(fpgssh_data.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='nsrmc'][type!='hidden']").val(fpgssh_data.jbxx.nsrmc);//纳税人名称
							    jQuery("textarea[name='gsshqksm'][type!='hidden']").val(fpgssh_data.jbxx.gsshqksm);//挂失损毁情况说明
								jQuery("textarea[name='gssm'][type!='hidden']").val(fpgssh_data.jbxx.gssm);//挂失声明
								jQuery("input[name='sqrq'][type!='hidden']").val(fpgssh_data.jbxx.sqrq);//申请日期
								jQuery("input[name='sqrxm'][type!='hidden']").val(fpgssh_data.jbxx.sqr);//申请人
								for(var i=0;i<fpgssh_data.sqxx.length;i++)
								{
									    var obj=fpgssh_data.sqxx[i];
										var fpgsshdataObj = {"tds":{
																"fpzlDm":{"value":obj.fpmc},//发票名称
																"fpDm":{"value":obj.fpdm},//发票代码
																"bglxDm1":{"value":obj.bglxDm},//报告类型代码
																"dsbdrq":{"value":obj.dsbdshrq},//丢失被盗损毁日期
																"fs":{"value":obj.fs},//份数
																"fpqshm":{"value":obj.qshm},//发票起始号码
																"fpzzhm":{"value":obj.zzhm},//发票终止号码
																"kbfpfs":{"value":obj.kbfs},//空白发票份数
																"kbfpqshm":{"value":obj.kbqshm},//空白发票起始号码
																"kbfpzzhm":{"value":obj.kbzzhm},//空白发票终止号码
																"sfxjx":{"value":obj.sfxzx}//是否需缴销
															}
														};
										
										$w('gsshmxGrid').insertRow(fpgsshdataObj);
									
								}
							}
						});
					});
		}catch(e){
		alert("extends\n"+e);
	}
}
fpgssh();