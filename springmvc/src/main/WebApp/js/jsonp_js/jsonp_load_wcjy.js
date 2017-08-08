//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_wcjy='http://98.12.100.191:10086/ws/QueryWcjy_tp.action?wcjy.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_wcjy,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.wcjy.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.wcjy.nsrmc);
																		
																		//外出经营地街道乡镇jdxzDm
																		var jdxzDm=$$("input[name='jdxzDm']");jdxzDm.set('value',jsonObj.wcjy.wcjyd);
																		
																		//申请人sqr
																		var sqr=$$("input[name='sqr']");sqr.set('value',jsonObj.wcjy.sqr);
																		
																		//申请日期slrq
																		var slrq=$$("input[name='slrq']");slrq.set('value',jsonObj.wcjy.sqrq);
																		
																		//原外出经营活动税收管理证明编号ywcjyhdssglzmbh
																		var ywcjyhdssglzmbh=$$("input[name='ywcjyhdssglzmbh']");ywcjyhdssglzmbh.set('value',jsonObj.wcjy.ywcjyzmbh);
																		
																		//合同总金额htzje
																		var htzje=$$("input[name='htzje']");htzje.set('value',jsonObj.wcjy.htzje);
	
																		for(var i=0;i<jsonObj.lwlist.length;i++){	
																				var dataObj = {"tds":{
																									"wcjylwmc":{"value":jsonObj.lwlist[i].yslw}, //应税劳务wcjylwmc
																									"wcjylwdd":{"value":jsonObj.lwlist[i].lwdd},    //劳务地点wcjylwdd
																									"wcjylwyxqxq":{"value":jsonObj.lwlist[i].yxks},    //有效期限起wcjylwyxqxq
																									"wcjylwyxqxz":{"value":jsonObj.lwlist[i].yxjs},    //有效期限止wcjylwyxqxz
																									"wcjylwdhtje":{"value":jsonObj.lwlist[i].htje}    //合同金额wcjylwdhtje
																								}
																							};
															
																				$w('lwxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
																		}
																		for(var i=0;i<jsonObj.hwlist.length;i++){	
																			var dataObj = {"tds":{
																								"wcjyhwmc":{"value":jsonObj.hwlist[i].hwmc}, //货物名称wcjyhwmc
																								"wcjyhwsl":{"value":jsonObj.hwlist[i].sl},    //货物数量wcjyhwsl
																								"wcjyhwxsdd":{"value":jsonObj.hwlist[i].xsdd},    //销售地点wcjyhwxsdd
																								"wcjyhwyxqxq":{"value":jsonObj.hwlist[i].yxks},    //有效期限起wcjyhwyxqxq
																								"wcjyhwyxqxz":{"value":jsonObj.hwlist[i].yxjs},    //有效期限止wcjyhwyxqxz
																								"wcjyhwzz":{"value":jsonObj.hwlist[i].hwzz}    //货物总值wcjyhwzz
																							}
																						};
														
																			$w('hwxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
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