//增值税专用发票
function zsfp()
{

	try{
			//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
			//var slhm=o.get("value");
			 var slhm = jQuery("#winp_shenqinghao").val();
		if(slhm)
		{
										var url_zyfp='http://98.12.100.191:10086/ws/jsonp_zyfp.action?zyfp.slhm='+slhm;
			jQuery(function(){
						
										//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
										jQuery.ajax
										({
											url:url_zyfp,
											dataType:"jsonp",
											jsonp:"callback",
											jsonpCallback:"callback_function",
											success:function(obj)
											{
																//alert("jsontext"+obj.slhm);
																//alert();
															   var ybse_b=0;		//应补税额						  
															//购货方纳税人信息
														
														//税人识别号 "ghfnsrsbh"
																var ghfnsrsbh=$$("input[name='ghfnsrsbh']");
																//ghfnsrsbh.set('code',"1111");
																ghfnsrsbh.set('value',obj.ghdw_swdjh);
																//jQuery("#ghfnsrsbh").focus();
																
																
																// 税人名称
																var ghfnsrmc=$$("input[name='ghfnsrmc']");
																// ghfnsrmc.set('code',"003");
																ghfnsrmc.set('value',obj.ghdw_mc);
																
																
																
																//开户银行信息
																var ghfkhyhDm=$$("input[name='ghfkhyhDm']");
																ghfkhyhDm.set('value',obj.ghdw_kfyh);
																ghfkhyhDm.set('realvalue',obj.ghdw_kfyh_code);
																
																
																//银行账号(增值税专用发票代开申请-购货方纳税人信息)
																var ghfyhzh=$$("input[name='ghfyhzh']");
																//ghfyhzh.set('code',"777");
																ghfyhzh.set('value',obj.ghdw_zh);
																//购货方地址
																var ghfdz=$$("input[name='ghfdz']");
																//alert("obj.ghdw_dz:"+obj.ghdw_dz);
																ghfdz.set('value',obj.ghdw_dz);
																
																//购货方联系电话
																var ghflxdh=$$("input[name='ghflxdh']");
																ghflxdh.set('value',obj.ghdw_dh);
																//购货方网点名称
																var ghfyhyywdmc=$$("input[name='ghfyhyywdmc']");
																ghfyhyywdmc.set('value',obj.sqfyhyywdmc);

															//销货方纳税人信息																							
															
															//销货方-sqrxm
																var sqrxm=$$("input[name='sqrxm']");
																//sqfdz.set('code',"003");
																//alert("obj.sbr_jbr:"+obj.sbr_jbr);
																sqrxm.set('value',obj.sbr_jbr);
																
															//地址(增值税专用发票代开申请-销货方纳税人信息)
																var sqfdz=$$("input[name='sqfdz']");
																//sqfdz.set('code',"003");
																sqfdz.set('value',obj.xhf_dz);
																//联系电话(增值税专用发票代开申请-销货方纳税人信息)
																var sqflxdh=$$("input[name='sqflxdh']");
																//sqflxdh.set('code',"003");
																sqflxdh.set('value',obj.xhf_dh);
																
																
																//销货方银行账号
																var sqfyhzh=$$("input[name='sqfyhzh']");
																//sqflxdh.set('code',"003");
																sqfyhzh.set('value',obj.xhf_zh);
																
																//销货方开户银行
																var sqfkhyhDm=$$("input[name='sqfkhyhDm']");
																sqflxdh.set('realvalue',obj.xhf_yh_code);
																sqfkhyhDm.set('value',obj.xhf_yh);
																//alert(obj.jldwDm2);
																//销货方网点名称
																var sqfyhyywdmc=$$("input[name='sqfyhyywdmc']");
																	sqfyhyywdmc.set('value',obj.ghfyhyywdmc);
																
																var hxzg_zyfp_bz=$$("textarea[name='bz']");
																	hxzg_zyfp_bz.set('text',obj.bz);
																
															if(obj.hwmc_1!=null)
															{
																	var dataObj = {"tds":{
																							"hwlwmc":{"value":obj.hwmc_1},
																							"ggxh":{"value":obj.ggxh_1},
																							"dwslDm":{"value":obj.jldw_1},
																							"dwslDm":{"realvalue":obj.jldwDm1},
																							"hlsl":{"value":obj.sliang_1},
																							"dj":{"value":obj.dj_1},
																							"je":{"value":obj.je_1},
																							"slzsl":{"value":obj.zsl_1},
																							"se":{"value":obj.sl_1}
																						}
																					};
																	ybse_b+=obj.sl_1;
																	$w('hlmxGrid').insertRow(dataObj); 
																
															}
															
															if(obj.hwmc_2!=null){
																	var dataObj = {"tds":{
																							"hwlwmc":{"value":obj.hwmc_2},
																							"ggxh":{"value":obj.ggxh_2},
																							"dwslDm":{"value":obj.jldw_2},
																							"dwslDm":{"realvalue":obj.jldwDm2},
																							"hlsl":{"value":obj.sliang_2},
																							"dj":{"value":obj.dj_2},
																							"je":{"value":obj.je_2},
																							"slzsl":{"value":obj.zsl_2},
																							"se":{"value":obj.sl_2}
																						}
																					};
																	
																	ybse_b+=obj.sl_2;
																	$w('hlmxGrid').insertRow(dataObj); 
																
															}
															
															if(obj.hwmc_3!=null)
															{
																	var dataObj = {"tds":{
																							"hwlwmc":{"value":obj.hwmc_3},
																							"ggxh":{"value":obj.ggxh_3},
																							"dwslDm":{"value":obj.jldw_3},
																							"dwslDm":{"realvalue":obj.jldwDm3},
																							"hlsl":{"value":obj.sliang_3},
																							"dj":{"value":obj.dj_3},
																							"je":{"value":obj.je_3},
																							"slzsl":{"value":obj.zsl_3},
																							"se":{"value":obj.sl_3}
																						}
																					};
																	ybse_b+=obj.sl_3;
																	$w('hlmxGrid').insertRow(dataObj); 
																
															}
															
															if(obj.hwmc_4!=null)
															{
																	var dataObj = {"tds":{
																							"hwlwmc":{"value":obj.hwmc_4},
																							"ggxh":{"value":obj.ggxh_4},
																							"dwslDm":{"value":obj.jldw_4},
																							"dwslDm":{"realvalue":obj.jldwDm4},
																							"hlsl":{"value":obj.sliang_4},
																							"dj":{"value":obj.dj_4},
																							"je":{"value":obj.je_4},
																							"slzsl":{"value":obj.zsl_4},
																							"se":{"value":obj.sl_4}
																						}
																		
																					};
																	ybse_b+=obj.sl_4;
																	$w('hlmxGrid').insertRow(dataObj); 
																
															}
																//价税合计
															var jshj=$$("input[name='jshj']");
																//ghfkhyhDm.set('code',"2222");
															jshj.set('value',obj.jshj_b);
															//应补税额
															var ybse=$$("input[name='ybse']");
															//ghfkhyhDm.set('code',"2222");
															ybse.set('value',ybse_b);
															
					
											}
									
										});
										
										
						});
		}
		
	}catch(e)
	{
		alert(e);
	}

}
zsfp();