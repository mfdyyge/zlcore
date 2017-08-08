function pzhd()
{
	var pzhd_data;
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
				var url_pzhd='http://98.12.100.191:10086/ws/queryPzhdtoJson.action?pzhd.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");				
						jQuery.ajax(
						{
							url:url_pzhd,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								pzhd_data=jsonObj;
								
								//基本信息
								jQuery("input[name='sqrxm']").val(pzhd_data.jbxx.sqr);//*申请人
								jQuery("input[name='nsrsbh']").val(pzhd_data.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='nsrmc']").val(pzhd_data.jbxx.nsrmc);//纳税人名称
								jQuery("input[name='sqrq']").val(pzhd_data.jbxx.sqrq);//申请日期
								//票种申请信息
								for(var i=0;i<pzhd_data.sqxx.length;i++)
									{
										var PzhddataObj = {"tds":{
																"fppzhdczlxDm":{"value":pzhd_data.sqxx[i].xzDm},
																"fpzlDm":{"value":pzhd_data.sqxx[i].fplb/*obj.hwmc_1*/},
																"fpzlDm":{"value":pzhd_data.sqxx[i].fplbDm/*obj.hwmc_1*/},
																"dffpzgkpxe":{"value":pzhd_data.sqxx[i].dffpzgkpxe},
																"jldwDm":{"value":"份"},
																"myzggpsl":{"value":pzhd_data.sqxx[i].myzggpsl},
																"mczggpsl":{"value":pzhd_data.sqxx[i].sgps},
																"cpzgsl":{"value":pzhd_data.sqxx[i].yyps},
																"fpgpfsDm":{"value":pzhd_data.sqxx[i].fpgpfsDm},
																"fpkjfsDm":{"value":pzhd_data.sqxx[i].fpkjfsDm}
															}
														};
										$w('pzhdsqmxGrid').insertRow(PzhddataObj);
									}
								//购票员信息	
								for(var i=0;i<pzhd_data.gpy.length;i++)
									{
										var GpydataObj = {"tds":{
																"fppzhdczlxDm":{"value":pzhd_data.gpy[i].czlxdm},//操作代码
																"gprxm":{"value":pzhd_data.gpy[i].gpymc/*obj.hwmc_1*/},//购票员姓名
																"lxdh":{"value":pzhd_data.gpy[i].gpylxdh},//联系电话 
																"sfzjzlDm":{"value":pzhd_data.gpy[i].gpysfzjzlDm},//身份证件代码
																"sfzjhm":{"value":pzhd_data.gpy[i].gpysfzjhm}//身份证件号码
															}
														};
										$w('gprwhsqmxGrid').insertRow(GpydataObj);
									}
						//jQuery("textarea[name='sqyqsbdly']").val(yqsb_data.jbxx.yqsbly);
						//jQuery("input[name='sqr']").val(yqsb_data.jbxx.jbr);
							}
						});
					});
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
pzhd();