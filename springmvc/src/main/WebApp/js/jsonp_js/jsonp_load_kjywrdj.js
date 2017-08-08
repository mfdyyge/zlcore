//扣缴税款登记
function kjywrdj()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
			 
					var url_swbg='http://98.12.100.191:10086/ws/kjywrdj_tp.action?kjywdj.slhm='+slhm;
				
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
																		//扣缴义务发生日期kjywfsrq
																		var kjywfsrq=$$("input[name='kjywfsrq']");kjywfsrq.set('value',jsonObj.kjywdj.kjywfsrq);
																		//申请人  fddbrfz
																		var sqrxm=$$("input[name='sqrxm']");sqrxm.set('value',jsonObj.kjywdj.fddbrfz);
	
																		for(var i=0;i<jsonObj.kjhblist.length;i++){	
																				var dataObj = {"tds":{
																									"dkdjdsdjskywnr":{"value":jsonObj.kjhblist[i].dkdjywnr}, //代扣代缴,代收代缴税款义务内容dkdjdsdjskywnr
																									"dkdjdsdjsz":{"value":jsonObj.kjhblist[i].dkdjszdm}    //代扣代缴,代收代缴税种dkdjdsdjsz
																								}
																							};
															
																				$w('dkdjdsdjskxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
																		}
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e);
	}



 				
}				
kjywrdj();		