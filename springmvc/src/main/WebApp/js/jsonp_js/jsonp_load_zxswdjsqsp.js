//扣缴税款登记
alert("aaaa");
function zxswdjsqsp()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
			 
					var url_swbg='http://98.12.100.191:10086/ws/zxswdjsqsp_tp.action?zxswdj.slhm='+slhm;
				
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
																		//申请理由sqly
																		var sqly=$$("input[name='sqly']");sqly.set('value',jsonObj.zxswdj.zxyy);
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.zxswdj.nsqzrq);
	
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e);
	}



 				
}				
zxswdjsqsp();		