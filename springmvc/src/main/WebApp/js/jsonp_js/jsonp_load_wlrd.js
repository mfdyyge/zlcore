//微利企业认定
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_wlrd='http://98.12.100.191:10086/ws/QueryWlrd_tp.action?wlrd.sldh='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_wlrd,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.wlrd.nsrsbh);																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.wlrd.nsrmc);																		
																		//认定年度rdnd
																		var rdnd=$$("input[name='rdnd']");rdnd.set('value',jsonObj.wlrd.ssnd);							
																		//年应纳税所得额申报数nynssdesbs
																		var nynssdesbs=$$("input[name='nynssdesbs']");nynssdesbs.set('value',jsonObj.wlrd.nynssde);
																		//所属行业sshyDm
																		var sshyDm=$$("input[name='sshyDm']");sshyDm.set('value',jsonObj.wlrd.sshyDm);
																		//从业人数申报数cyrssbs
																		var cyrssbs=$$("input[name='cyrssbs']");cyrssbs.set('value',jsonObj.wlrd.cyrsAvg);
																		//资产总额申报数zczesbs
																		var zczesbs=$$("input[name='zczesbs']");zczesbs.set('value',jsonObj.wlrd.zczeAvg);
																		//纳税人经办人nsrjbrxm
																		var nsrjbrxm=$$("input[name='nsrjbrxm']");nsrjbrxm.set('value',jsonObj.wlrd.jbr);
																		//是否从事国家限制和禁止的行业csxzjzhybz
																		var csxzjzhybz=$$("input[name='csxzjzhybz']");csxzjzhybz.set('value',jsonObj.wlrd.sfcsjzhyDm);
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.wlrd.sqrq);
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e);
	}



 				
}				
swbg();		