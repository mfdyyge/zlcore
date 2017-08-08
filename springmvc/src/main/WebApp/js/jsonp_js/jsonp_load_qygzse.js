//企业购置设备税额
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_qygzse='http://98.12.100.191:10086/ws/Queryqygzse_tp.action?qygzse.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_qygzse,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.qygzse.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.qygzse.nsrmc);
																		
																		//设备购置年度sbgznd
																		var sbgznd=$$("input[name='sbgznd']");sbgznd.set('value',jsonObj.qygzse.sbgznd);
																		
																		//抵免年度dmnd
																		var dmnd=$$("input[name='dmnd']");dmnd.set('value',jsonObj.qygzse.dmnd);
																			//第一年
																			if(jsonObj.lisQygzseList[0].ndone!=null){
																				var dataObj = {"tds":{
																					"jznx":{"value":'1'},//年度
																					"qygzzysbkdmqysdsze":{"value":jsonObj.lisQygzseList[0].ndone}, //企业购置专用设备可抵免企业所得税总额qygzzysbkdmqysdsze
																					"jzyqndwdmse":{"value":jsonObj.lisQygzseList[1].ndone},    //结转的以前年度未抵免税额jzyqndwdmse
																					"qygzyyhjbhzysbtzedmdse":{"value":jsonObj.lisQygzseList[2].ndone},    //企业购置用于环境保护专用设备的投资额抵免的税额qygzyyhjbhzysbtzedmdse
																					"qygzyyjnjszysbtzedmdse":{"value":jsonObj.lisQygzseList[3].ndone},    //企业购置用于节能节水专用设备的投资抵免 的税额qygzyyjnjszysbtzedmdse
																					"qygzyyaqsczysbtzdmdese":{"value":jsonObj.lisQygzseList[4].ndone},    //企业购置用于安全生产专用设备的投资额抵免的税额qygzyyaqsczysbtzdmdese
																					"dmsdsehj":{"value":jsonObj.lisQygzseList[5].ndone},     //本年度抵免所得税额合计bmsdsehj
																					"jzyhnddmsdsdtzye":{"value":jsonObj.lisQygzseList[6].ndone},      //结转以后年度抵免所得税的投资余额jzyhnddmsdsdtzye
																					"bdjzdmdtzye":{"value":jsonObj.lisQygzseList[7].ndone},      //不得结账抵免的投资余额bdjzdmdtzye
																					"dmhynqysdse":{"value":jsonObj.lisQygzseList[8].ndone}  //本年度抵免后应纳企业所得税额dmhynqysdse
																				}
																				};
																				$w('yhsdsdmsemxGrid').insertRow(dataObj); 
																			}
																			//第二年
																			if(jsonObj.lisQygzseList[0].ndtwo!=null){
																				var dataObj = {"tds":{
																					"jznx":{"value":'2'},//年度
																					"qygzzysbkdmqysdsze":{"value":jsonObj.lisQygzseList[0].ndtwo}, 
																					"jzyqndwdmse":{"value":jsonObj.lisQygzseList[1].ndtwo},    
																					"qygzyyhjbhzysbtzedmdse":{"value":jsonObj.lisQygzseList[2].ndtwo},    
																					"qygzyyjnjszysbtzedmdse":{"value":jsonObj.lisQygzseList[3].ndtwo},    
																					"qygzyyaqsczysbtzdmdese":{"value":jsonObj.lisQygzseList[4].ndtwo},    
																					"dmsdsehj":{"value":jsonObj.lisQygzseList[5].ndtwo},     
																					"jzyhnddmsdsdtzye":{"value":jsonObj.lisQygzseList[6].ndtwo},      
																					"bdjzdmdtzye":{"value":jsonObj.lisQygzseList[7].ndtwo},      
																					"dmhynqysdse":{"value":jsonObj.lisQygzseList[8].ndtwo}  
																				}
																				};
																				$w('yhsdsdmsemxGrid').insertRow(dataObj); 																			}
																			//第三年
																			if(jsonObj.lisQygzseList[0].ndthree!=null){
																				var dataObj = {"tds":{
																					"jznx":{"value":'3'},//年度
																					"qygzzysbkdmqysdsze":{"value":jsonObj.lisQygzseList[0].ndthree}, 
																					"jzyqndwdmse":{"value":jsonObj.lisQygzseList[1].ndthree},    
																					"qygzyyhjbhzysbtzedmdse":{"value":jsonObj.lisQygzseList[2].ndthree},    
																					"qygzyyjnjszysbtzedmdse":{"value":jsonObj.lisQygzseList[3].ndthree},    
																					"qygzyyaqsczysbtzdmdese":{"value":jsonObj.lisQygzseList[4].ndthree},    
																					"dmsdsehj":{"value":jsonObj.lisQygzseList[5].ndthree},     
																					"jzyhnddmsdsdtzye":{"value":jsonObj.lisQygzseList[6].ndthree},      
																					"bdjzdmdtzye":{"value":jsonObj.lisQygzseList[7].ndthree},      
																					"dmhynqysdse":{"value":jsonObj.lisQygzseList[8].ndthree}  
																				}
																				};
																				$w('yhsdsdmsemxGrid').insertRow(dataObj); 	
																			}
																			//第四年
																			if(jsonObj.lisQygzseList[0].ndfour!=null){
																				var dataObj = {"tds":{
																					"jznx":{"value":'4'},//年度
																					"qygzzysbkdmqysdsze":{"value":jsonObj.lisQygzseList[0].ndfour}, 
																					"jzyqndwdmse":{"value":jsonObj.lisQygzseList[1].ndfour},    
																					"qygzyyhjbhzysbtzedmdse":{"value":jsonObj.lisQygzseList[2].ndfour},    
																					"qygzyyjnjszysbtzedmdse":{"value":jsonObj.lisQygzseList[3].ndfour},   
																					"qygzyyaqsczysbtzdmdese":{"value":jsonObj.lisQygzseList[4].ndfour},    
																					"dmsdsehj":{"value":jsonObj.lisQygzseList[5].ndfour},     
																					"jzyhnddmsdsdtzye":{"value":jsonObj.lisQygzseList[6].ndfour},      
																					"bdjzdmdtzye":{"value":jsonObj.lisQygzseList[7].ndfour},      
																					"dmhynqysdse":{"value":jsonObj.lisQygzseList[8].ndfour}  
																				}
																				};
																				$w('yhsdsdmsemxGrid').insertRow(dataObj); 	
																			}
																			//第五年
																			if(jsonObj.lisQygzseList[0].ndfive!=null){
																				var dataObj = {"tds":{
																					"jznx":{"value":'5'},//年度
																					"qygzzysbkdmqysdsze":{"value":jsonObj.lisQygzseList[0].ndfive}, 
																					"jzyqndwdmse":{"value":jsonObj.lisQygzseList[1].ndfive},    
																					"qygzyyhjbhzysbtzedmdse":{"value":jsonObj.lisQygzseList[2].ndfive},    
																					"qygzyyjnjszysbtzedmdse":{"value":jsonObj.lisQygzseList[3].ndfive},    
																					"qygzyyaqsczysbtzdmdese":{"value":jsonObj.lisQygzseList[4].ndfive},    
																					"dmsdsehj":{"value":jsonObj.lisQygzseList[5].ndfive},    
																					"jzyhnddmsdsdtzye":{"value":jsonObj.lisQygzseList[6].ndfive},  
																					"bdjzdmdtzye":{"value":jsonObj.lisQygzseList[7].ndfive},     
																					"dmhynqysdse":{"value":jsonObj.lisQygzseList[8].ndfive}  
																				}
																				};
																				$w('yhsdsdmsemxGrid').insertRow(dataObj); 	
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