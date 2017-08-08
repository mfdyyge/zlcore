//货运发票
function hyfp()
{
//alert("进入货运发票代开-hyfp()");

	try{
			//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
			//var slhm=o.get("value");
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_hyfp='http://98.12.100.191:10086/ws/jsonp_hyfp.action?hyfp.slhm='+slhm;
				
				jQuery(function(){
					//jQuery("#msg_id").html("加载插件完毕");
					//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
					jQuery.ajax(
					{
						url:url_hyfp,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//受票方纳税人识别号 spfnsrsbh
																		var spfnsrsbh=$$("input[name='spfnsrsbh']");spfnsrsbh.set('value',jsonObj.jbxx.spf_sbh);
																		
																		//受票方纳税人名称 spf_mc
																		var spfnsr_mc=$$("input[name='spfnsrmc']");spfnsr_mc.set('value',jsonObj.jbxx.spf_mc);
																		
																		//收货人纳税人识别号 shrnsrsbh
																		var shrnsrsbh=$$("input[name='shrnsrsbh']");shrnsrsbh.set('value',jsonObj.jbxx.shr_sbh);
																		
																		//收货人纳税人名称 shr_mc
																		var shrnsr_mc=$$("input[name='shrmc']");shrnsr_mc.set('value',jsonObj.jbxx.shr_mc);
																		
																		//发货人纳税人识别号 fhrnsrsbh
																		var fhrnsrsbh=$$("input[name='fhrnsrsbh']");fhrnsrsbh.set('value',jsonObj.jbxx.fhr_sbh);	
																		
																		//发货人纳税人名称 
																		var fhrnsr_mc=$$("input[name='fhrmc']");fhrnsr_mc.set('value',jsonObj.jbxx.fhr_mc);

																		//起运地  	qyd==qyd_jy_ddd
																		var qyd=$$("input[name='qyd']");
																			qyd.set('value',jsonObj.jbxx.qyd_jy_ddd);
																		
																		//经由地  jyd==jyd_d
																		var jyd=$$("input[name='jyd']");
																			jyd.set('value',jsonObj.jbxx.jyd_d);	
																			
																		//到达地  ddd==dad_d
																		var ddd=$$("input[name='ddd']");
																			ddd.set('value',jsonObj.jbxx.dad_d);
																			
																		if(jsonObj.jbxx.ccdw!=null)
																		{																	
																			var hwysxx = {"tds":{
																										//车辆牌照号码 clpzhm==ch
																										
																										"cllxDm":{"value":jsonObj.jbxx.cllxDm},
																										//"cllxDm":{"code":jsonObj.jbxx.cllxDm},
																										"clpzhm":{"value":jsonObj.jbxx.ch},   //车辆牌照号码
																										"cldw":{"value":jsonObj.jbxx.ccdw}   ////车辆吨位
																
																									}
																							 };  
																			//$w('hwysxxForm').insertRow(hwysxx); //货物运输信息
																			$w('clxxGrid').insertRow(hwysxx); //车俩信息表格
																			
																		} 
			
											for(var i=0;i<jsonObj.dkxx.length;i++){	
																				var dataObj = {"tds":{
																									"hwmc":{"value":jsonObj.dkxx[i].xmmc}, //货物名称hwmc
																									"sl":{"value":jsonObj.dkxx[i].zsl},    //货物数量 sl
																									//"yj":{"value":jsonObj.},   //运价yj
																									//"lc":{"value":"55"},    //里程 lc
																									"yfje":{"value":jsonObj.dkxx[i].fyxmje}//,       //运费金额 yfje
																									//"xmmc":{"value":jsonObj.xmmc1},      //其他项目  xmmc
																									//"qtxmje":{"value":"100"}    //其他项目金额 qtxmje
																								}
																							};
																		
																				$w('xmxxGrid').insertRow(dataObj); //代开货物运输发票项目明细	
																		}
																		//合计金额
																		var hjse=$$("input[name='jehj']");
																		//ghfkhyhDm.set('code',"2222");
																		hjse.set('value',jsonObj.jbxx.hjje);
                                                                                            
																		//价税合计
																		var jshj=$$("input[name='jshj']");
																		//ghfkhyhDm.set('code',"2222");
																		jshj.set('value',jsonObj.jbxx.jshj);
																		//申请人姓名
																		$$("input[name='sqrxm']").set('value',jsonObj.jbxx.sqr);
																			
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
hyfp();		