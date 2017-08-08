//纳税人合并分立情况报告
function nsrhbflqk()
{
	var nsrhbflqk_data;
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_nsrhbflqk='http://98.12.100.191:10086/ws/queryNsrhbflqkJson.action?nsrhbflqk.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_nsrhbflqk,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								nsrhbflqk_data=jsonObj;
								jQuery("input[name='hbflsj'][type!='hidden']").val(nsrhbflqk_data.jbxx.hbflsj);//合并分立时间
								jQuery("input[name='bglx'][type!='hidden']").val(nsrhbflqk_data.jbxx.bglx);
								jQuery("input[name='bglx'][type!='hidden']").attr("realvalue","0");//报告类型
								jQuery("input[name='hbflyy'][type!='hidden']").val(nsrhbflqk_data.jbxx.hbflyy);//合并(分立)原因
								jQuery("input[name='pzhbflwjhjy'][type!='hidden']").val(nsrhbflqk_data.jbxx.pzhbwjhjy);//批准合并(分立)文件和决议
								jQuery("input[name='sqr'][type!='hidden']").val(nsrhbflqk_data.jbxx.sqr);//申请人
								jQuery("input[name='bgsj'][type!='hidden']").val(nsrhbflqk_data.jbxx.bgsj);//报告时间
								//合并(分立)前基本情况
								for(var i=0;i<nsrhbflqk_data.lbxxone.length;i++)
								{
									    var obj=nsrhbflqk_data.lbxxone[i];
										var lbxxonedataObj = {"tds":{
																"nsrsbh":{"value":obj.nsrsbh},//纳税人识别号
																"nsrmc":{"value":obj.nsrmc},//纳税人名称
																"fzr":{"value":obj.fzr},//负责人
																"scjydz":{"value":obj.scjydz},//生产经营地址
																//"sfqs":{"value":obj.sfqs}//是否欠税
																"sfqs":{"value":"0"}
															}
														};
										
										$w('hbflqjbxxGrid').insertRow(lbxxonedataObj);
									
								}
								//合并(分立)后基本情况
								for(var i=0;i<nsrhbflqk_data.lbxxtwo.length;i++)
								{
									    var obj=nsrhbflqk_data.lbxxtwo[i];
										var lbxxtwodataObj = {"tds":{
																"nsrsbh":{"value":obj.nsrsbh},//纳税人识别号
																"nsrmc":{"value":obj.nsrmc},//纳税人名称
																"fzr":{"value":obj.fzr},//负责人
																"scjydz":{"value":obj.scjydz},//生产经营地址
																"bz":{"value":obj.bz}//备注
															}
														};
										
										$w('hbflhjbxxGrid').insertRow(lbxxtwodataObj);
									
								}
							}
						});
					});
		}catch(e){
		alert("extends\n"+e);
	}
}
nsrhbflqk();