//扣缴税款登记
function tyfybgs()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					var url_swbg='http://98.12.100.191:10086/ws/tyfybgs_tp.action?tyfy.slhm='+slhm;
				
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
																		//停业期限起tyqxq
																		//alert(jsonObj.tyfy.tyqxq);
																		var tyqxq=$$("input[name='tyqxq']");tyqxq.set('value',jsonObj.tyfy.tyqxq);
																		//停业期限止tyqxz
																		var tyqxz=$$("input[name='tyqxz']");tyqxz.set('value',jsonObj.tyfy.tyqxz);
																		//生产经营地址scjydz
																		var scjydz=$$("input[name='scjydz']");scjydz.set('value',jsonObj.tyfy.jydd);
	
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e);
	}



 				
}				
tyfybgs();		