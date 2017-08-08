//通用机打发票----普通发票
function ptfp()
{
try{
			//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
			//var slhm=o.get("value");
			 var slhm = jQuery("#winp_shenqinghao").val();
			
	if(slhm)
	{
							
							var url_ptfp='http://98.12.100.191:10086/ws/jsonp_ptfp.action?ptfp.slhm='+slhm;
							
	jQuery(function(){
						
								//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
								jQuery.ajax
								({
									url:url_ptfp,
									dataType:"jsonp",
									jsonp:"callback",
									jsonpCallback:"callback_function",
									success:function(jsonObj)
									{
													//alert("o.getvalue>>>"+jsonObj);
													//收款方经营地址 dz
													var dz=$$("input[name='dz']");
													//dz.set('code',"1");
													dz.set('value',jsonObj.jbxx.skf_jydz);
												
													//付款方名称 fkfmc
													var fkfmc=$$("input[name='fkfmc']");fkfmc.set('value',jsonObj.jbxx.fkf_mc);
													
													//付款方识别号 "fkfnsrsbh"
													var fkf_nsrsbh=$$("input[name='fkfnsrsbh']");fkf_nsrsbh.set('value',jsonObj.jbxx.fkf_nsrsbh);
													
													//付款方类型 "fkfsfzjzlDm"
													var fkf_zjmc=$$("input[name='fkfsfzjzlDm']");fkf_zjmc.set('value',jsonObj.jbxx.fkf_zjmc);
													
													//付款方证件号 "fkfsfzjhm"
													var fkf_zjh=$$("input[name='fkfsfzjhm']");fkf_zjh.set('value',jsonObj.jbxx.fkf_zjh);
													
													//联系电话 lxdh
													var lxdh=$$("input[name='lxdh']");
													//lxdh.set('code',"2345");
													lxdh.set('value',jsonObj.jbxx.skf_lxdh);
		
		
													//通用机打发票代开申请-劳务、货物信息
												for(var i=0;i<jsonObj.dkxx.length;i++){	
													
															var sqmxxxGridData = {"tds":{
																					
																						"hwlwmc":{"value":jsonObj.dkxx[i].xmmc},   //货物（劳务）名称 hwlwmc
																						//"ggxh":{"value":"CC001"},   //规格 ggxh
																						"dwslDm":{"value":jsonObj.dkxx[i].dw},   //数量单位  dwslDm
																						"dwslDm":{"code":jsonObj.dkxx[i].dwdm},
																						"hlsl":{"value":jsonObj.dkxx[i].sl},   //数量 hlsl
																						"dj":{"value":jsonObj.dkxx[i].dj},   //单价 dj
																						"je":{"value":jsonObj.dkxx[i].je}//,   //金额 je
																						
																						}
																				};
															$w('sqmxxxGrid').insertRow(sqmxxxGridData); //通用机打发票代开申请-劳务、货物信息
													}

													

													if(jsonObj.zs_se1)
													{
															//通用机打发票代开申请-应补退税信息
															var ybtsxxGridData = {"tds":{																						
																						
																						"sfl":{"value":jsonObj.sl_zsl},      //税(费)率  sfl																							
																						"bqynsfe":{"value":jsonObj.zs_se1}//,//      //应纳税(费)额 bqynsfe,
												
																						}
																				};				
															$w('ybtsxxGrid').insertRow(ybtsxxGridData); //通用机打发票代开申请-应补退税信息
													}	
												$$("input[name='sqrxm']").set('value',jsonObj.jbxx.sqr);													
									}
							})
					});	
				
	}			
	}catch(e){	alert(e);	}	
}
ptfp();

