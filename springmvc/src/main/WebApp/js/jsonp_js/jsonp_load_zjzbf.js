//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_swbg='http://98.12.100.191:10086/ws/zjzbf_tp.action?zj.slhm='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_swbg,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
																		//申请类型swzjsqlxDm
																		jQuery("input[name='swzjsqlxDm'][type!='hidden']").val(jsonObj.zj.sqlx);
																		jQuery("input[name='swzjsqlxDm'][type!='hidden']").attr('realvalue',jsonObj.zj.sqlxDM);
																		
																		//申请发放证件名称sqffswzjzlDm
																		//jQuery("pulltree[name='sqffswzjzlDm'][type!='hidden']").val(jsonObj.zj.sqffzjmcDM);
																		//var sqffswzjzlDm=$$("input[name='sqffswzjzlDm']");sqffswzjzlDm.set('value',jsonObj.zj.sqffzjmc);
																		jQuery("input[name='sqffswzjzlDm'][type!='hidden']").val(jsonObj.zj.sqffzjmc);
																		jQuery("input[name='sqffswzjzlDm'][type!='hidden']").attr('realvalue',jsonObj.zj.sqffzjmcDM);
																		//申请发放证件数量sqffzjsl
																		var sqffzjsl=$$("input[name='sqffzjsl']");sqffzjsl.set('value',jsonObj.zj.sqffzjsl);
																		//办税人姓名bsrxm
																		var bsrxm=$$("input[name='bsrxm']");bsrxm.set('value',jsonObj.zj.bsrxm);
																		//申请理由sqly
																		jQuery("textarea[name='sqly'][type!='hidden']").val(jsonObj.zj.sqly);
																		
																		
	
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
swbg();		