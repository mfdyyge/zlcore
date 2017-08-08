//不认定增值税一般纳税人申请
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_zzs='http://98.12.100.191:10086/ws/QueryZzs_tp.action?zzs_brd.sldh='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_zzs,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.zzs.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.zzs.nsrmc);
																		
																		//纳税人意见nsryj
																		var nsryj=$$("input[name='nsryj']");nsryj.set('value',jsonObj.zzs.nsryj);
																		
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.zzs.nsrqzrq);
	
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
swbg();		