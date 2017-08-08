//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_qygzs='http://98.12.100.191:10086/ws/Queryqygzs_tp.action?qygzs.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_qygzs,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.qygzs.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.qygzs.nsrmc);
																		
																		//自筹资金和银行贷款购买专用设备投资额zczjhyhdkgmzysbtze
																		var zczjhyhdkgmzysbtze=$$("input[name='zczjhyhdkgmzysbtze']");zczjhyhdkgmzysbtze.set('value',jsonObj.qygzs.zczjyhdk);
																		
																		//专用设备投资额zysbtze
																		var zysbtze=$$("input[name='zysbtze']");zysbtze.set('value',jsonObj.qygzs.zysbtz);
																		
																		//财政拨款购买专用设备投资额czbkgmzysbtze
																		var czbkgmzysbtze=$$("input[name='czbkgmzysbtze']");czbkgmzysbtze.set('value',jsonObj.qygzs.czbktz);
																		
																		//设备购买年度sbgznd
																		var sbgznd=$$("input[name='sbgznd']");sbgznd.set('value',jsonObj.qygzs.sbgznd);
																		
																		//购置专用设备可抵免企业所得税总额gzzysbkdmqysdsze
																		var gzzysbkdmqysdsze=$$("input[name='gzzysbkdmqysdsze']");gzzysbkdmqysdsze.set('value',jsonObj.qygzs.sdze);
																		
																		//申请人sqr
																		var sqr=$$("input[name='sqr']");sqr.set('value',jsonObj.qygzs.fddbr);
																		
																		for(var i=0;i<jsonObj.gzzlist.length;i++){	//购买专用设备情况
																				var dataObj = {"tds":{
																									"zysblbDm":{"value":jsonObj.gzzlist[i].lbDm}, //专用设备类别zysblbDm
																									"zysbmc":{"value":jsonObj.gzzlist[i].mc},    //专用设备名称zysbmc
																									"zysbcd":{"value":jsonObj.gzzlist[i].cd},    //专用设备产地zysbcd
																									"zysbgg":{"value":jsonObj.gzzlist[i].gg},    //专业设备规格zysbgg
																									"zysbxh":{"value":jsonObj.gzzlist[i].xh},    //专业设备型号zysbxh
																									"zysbsl":{"value":jsonObj.gzzlist[i].sl},    //专业设备数量zysbsl
																									"zysbdj":{"value":jsonObj.gzzlist[i].dj},    //专业设备单价zysbdj
																									"gmzysbfpjshjjg":{"value":jsonObj.gzzlist[i].hjje}    //购买专用设备发票价税合计价格gmzysbfpjshjjg
																								}
																							};															
																				$w('gmzysbqkGrid').insertRow(dataObj); //代开货物运输发票项目明细	
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