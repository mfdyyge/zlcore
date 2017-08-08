//逾期增值税凭证抵扣申请单
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_pzdk='http://98.12.100.191:10086/ws/QueryPzdk_tp.action?pzdk.sldh='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_pzdk,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success--------------\-");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.pzdk.nsrsbh);																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.pzdk.nsrmc);																		
																		//经营地址scjydz
																		var scjydz=$$("input[name='scjydz']");scjydz.set('value',jsonObj.pzdk.jydz);
																		//财务人员cwry
																		var cwry=$$("input[name='cwry']");cwry.set('value',jsonObj.pzdk.cwrymc);
																		//联系方式lxfs
																		var lxfs=$$("input[name='lxfs']");lxfs.set('value',jsonObj.pzdk.cwrylxfs);
																		//逾期增值税扣税凭证之增值税专用发票份数yqzzsdkpzzzzszyfpfs
																		var yqzzsdkpzzzzszyfpfs=$$("input[name='yqzzsdkpzzzzszyfpfs']");yqzzsdkpzzzzszyfpfs.set('value',jsonObj.pzdk.zzsfpfs);
																		var yqzzsdkpzzzzszyfpfs=$$("input[name='yqzzsdkpzzzzszyfpfs']");yqzzsdkpzzzzszyfpfs.set('realvalue',jsonObj.pzdk.zzsfpfs);
																		//逾期增值税扣税凭证之增值税专用发票税额yqzzsdkpzzzzszyfpse
																		var yqzzsdkpzzzzszyfpse=$$("input[name='yqzzsdkpzzzzszyfpse']");yqzzsdkpzzzzszyfpse.set('value',jsonObj.pzdk.zzsfpse);
																		var yqzzsdkpzzzzszyfpse=$$("input[name='yqzzsdkpzzzzszyfpse']");yqzzsdkpzzzzszyfpse.set('realvalue',jsonObj.pzdk.zzsfpse);
																		//逾期增值税扣税凭证之海关进口增值税专用缴款书份数yqzzsdkpzzhgjkzzszyjksfs
																		var yqzzsdkpzzhgjkzzszyjksfs=$$("input[name='yqzzsdkpzzhgjkzzszyjksfs']");yqzzsdkpzzhgjkzzszyjksfs.set('value',jsonObj.pzdk.hgjksfs);
																		var yqzzsdkpzzhgjkzzszyjksfs=$$("input[name='yqzzsdkpzzhgjkzzszyjksfs']");yqzzsdkpzzhgjkzzszyjksfs.set('realvalue',jsonObj.pzdk.hgjksfs);
																		//逾期增值税扣税凭证之海关进口增值税专用缴款书税额yqzzsdkpzzhgjkzzszyjksse
																		var yqzzsdkpzzhgjkzzszyjksse=$$("input[name='yqzzsdkpzzhgjkzzszyjksse']");yqzzsdkpzzhgjkzzszyjksse.set('value',jsonObj.pzdk.hgjksse);
																		var yqzzsdkpzzhgjkzzszyjksse=$$("input[name='yqzzsdkpzzhgjkzzszyjksse']");yqzzsdkpzzhgjkzzszyjksse.set('realvalue',jsonObj.pzdk.hgjksse);
																		//逾期增值税扣税凭证之公路内河货物运输业统一发票份数yqzzskspzzglnhhwysytyfpfs
																		var yqzzskspzzglnhhwysytyfpfs=$$("input[name='yqzzskspzzglnhhwysytyfpfs']");yqzzskspzzglnhhwysytyfpfs.set('value',jsonObj.pzdk.hyfpfs);
																		var yqzzskspzzglnhhwysytyfpfs=$$("input[name='yqzzskspzzglnhhwysytyfpfs']");yqzzskspzzglnhhwysytyfpfs.set('realvalue',jsonObj.pzdk.hyfpfs);
																		//逾期增值税扣税凭证之公路内河货物运输业统一发票税额yqzzskspzzglnhhwysytyfpse
																		var yqzzskspzzglnhhwysytyfpse=$$("input[name='yqzzskspzzglnhhwysytyfpse']");yqzzskspzzglnhhwysytyfpse.set('value',jsonObj.pzdk.hyfpse);
																		var yqzzskspzzglnhhwysytyfpse=$$("input[name='yqzzskspzzglnhhwysytyfpse']");yqzzskspzzglnhhwysytyfpse.set('realvalue',jsonObj.pzdk.hyfpse);
																		//逾期增值税扣税凭证合计份数yqzzskspzhjfs
																		var yqzzskspzhjfs=$$("input[name='yqzzskspzhjfs']");yqzzskspzhjfs.set('value',jsonObj.pzdk.hjfs);
																		var yqzzskspzhjfs=$$("input[name='yqzzskspzhjfs']");yqzzskspzhjfs.set('realvalue',jsonObj.pzdk.hjfs);
																		//逾期增值税扣税凭证合计税额yqzzskspzhjse
																		var yqzzskspzhjse=$$("input[name='yqzzskspzhjse']");yqzzskspzhjse.set('value',jsonObj.pzdk.hjse);
																		var yqzzskspzhjse=$$("input[name='yqzzskspzhjse']");yqzzskspzhjse.set('realvalue',jsonObj.pzdk.hjse);
																		//纳税人声明nsrsm
																		var nsrsm=$$("input[name='nsrsm']");nsrsm.set('value','此表增值税扣税凭证由于客观原因造成的逾期增值税扣税凭证，与本表提供说明、证明或说明等资料内容是真实的。');
																		//企业声明人qysmr
																		var qysmr=$$("input[name='qysmr']");qysmr.set('value',jsonObj.pzdk.smr);
																		//企业经办人qyjbr
																		var qyjbr=$$("input[name='qyjbr']");qyjbr.set('value',jsonObj.pzdk.qyjbr);
																		//申请日期sqrq
																		var sqrq=$$("input[name='sqrq']");sqrq.set('value',jsonObj.pzdk.sqrq);
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e);
	}



 				
}				
swbg();		