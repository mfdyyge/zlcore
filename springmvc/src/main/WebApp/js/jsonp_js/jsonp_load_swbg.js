//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_swbg='http://98.12.100.191:10086/ws/Querybgdj_tp.action?swbg.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_swbg,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.swbg.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.swbg.nsrmc);
																		
																		//办税人姓名sqr
																		var sqr=$$("input[name='sqr']");sqr.set('value',jsonObj.swbg.fddbr);
																		
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.swbg.nsrq);
	
																		for(var i=0;i<jsonObj.bgdj.length;i++){	
																				var dataObj = {"tds":{
																									"bgxmDm":{"value":jsonObj.bgdj[i].bgxm_code}, //变更项目bgxmDm
																									"bgqnr":{"value":jsonObj.bgdj[i].bgqnr},    //变更前内容bgqnr
																									"bghnr":{"value":jsonObj.bgdj[i].bghnr},    //变更后内容bghnr
																									"pzjgmc":{"value":jsonObj.bgdj[i].pzjgmc},    //批准机关名称pzjgmc
																									"pzwj":{"value":jsonObj.bgdj[i].pzwj}    //批准文件pzwj
																								}
																							};
															
																				$w('bgjbxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
																		}
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
swbg();		