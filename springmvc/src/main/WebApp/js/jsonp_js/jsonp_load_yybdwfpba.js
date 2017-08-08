//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_wcjy='http://98.12.100.191:10086/ws/yybdwfpba_tp.action?fpba.slhm='+slhm;
				
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
																		//备案有效期起yxqq
																		var yxqq=$$("input[name='yxqq']");yxqq.set('value',jsonObj.fpba.bayxqq);
																		//备案有效期止yxqz
																		var yxqz=$$("input[name='yxqz']");yxqz.set('value',jsonObj.fpba.bayxqz);
																		//经办人jbr
																		var jbr=$$("input[name='jbr']");jbr.set('value',jsonObj.fpba.jbr);
																		
																		
																		
																		
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
swbg();		