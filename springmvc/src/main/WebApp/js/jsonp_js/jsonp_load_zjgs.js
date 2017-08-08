//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_zjgs='http://98.12.100.191:10086/ws/QueryZjgs_tp.action?zjgs.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_zjgs,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.zjgs.nsrsbh);
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.zjgs.nsrmc);
																		
																		//法定代表人fddbrhfzrhyzxm
																		var sqrmc=$$("input[name='sqrmc']");sqrmc.set('value',jsonObj.zjgs.fddbr);

																		
																		//申请人名称sqrmc
																		var sqrmc=$$("input[name='sqrmc']");sqrmc.set('value',jsonObj.zjgs.sqr);
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.zjgs.sqrq);
																		//遗失被盗情况说明ysbdqksm
																		var ysbdqksm=$$("textarea[name='ysbdqksm']");ysbdqksm.set('value',jsonObj.zjgs.ysbdsm);
																		//遗失声明yssm
																		var yssm=$$("textarea[name='yssm']");yssm.set('value',jsonObj.zjgs.yssm);
																		
																		for(var i=0;i<jsonObj.ysbd.length;i++){	
																				var dataObj = {"tds":{
																									//"sqcxffswzjzlDm":{"value":jsonObj.ysbd[i].bgxm}, //变更项目bgxmDm
																									"ysbdswzjzlDm":{"value":jsonObj.ysbd[i].zjmc_code}, //变更项目bgxmDm
																									"ysbdswzjhm":{"value":jsonObj.ysbd[i].zjhm}   //变更前内容bgqnr    //批准文件pzwj
																								}
																							};
															
																				$w('zjgsxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
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