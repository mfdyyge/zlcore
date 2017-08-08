//财务会计
function cwkj()
{
	var yqsb_data;
	
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_cwkj='http://98.12.100.191:10086/ws/queryCwkjjhsrjtoJson.action?cwjbxx.slhm='+slhm;
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_cwkj,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								cwkj_data=jsonObj;
								jQuery("input[name='kjzdzzDm'][type!='hidden']").val(cwkj_data.jbxx.cwkjzdMc);//财务会计制度名称
								jQuery("input[name='kjzdzzDm'][type!='hidden']").attr('realvalue',cwkj_data.jbxx.kjzdzzDm);//财务会计制度代码
								jQuery("input[name='cwkjzdbz'][type!='hidden']").val(cwkj_data.jbxx.kjzdzzBz);//财务、会计制度备注
								
								jQuery("input[name='dzyhptxffDm'][type!='hidden']").val(cwkj_data.jbxx.dzyhptxffMc);//底值易消耗品摊销方法	
								jQuery("input[name='dzyhptxffDm'][type!='hidden']").attr('realvalue',cwkj_data.jbxx.dzyhptxffDm);	
								jQuery("input[name='dzyhptxffbz'][type!='hidden']").val(cwkj_data.jbxx.dzyhptxffBz);	
								
								jQuery("input[name='zjfsdlDm'][type!='hidden']").val(cwkj_data.jbxx.zjfsdlMc);//折旧方式(大类)	
								jQuery("input[name='zjfsdlDm'][type!='hidden']").attr('realvalue',cwkj_data.jbxx.zjfsdlDm);	
								
								jQuery("textarea[name='zjffbz'][type!='hidden']").val(cwkj_data.jbxx.zjfsBz);	
								
								jQuery("input[name='zjfsxlDm'][type!='hidden']").val(cwkj_data.jbxx.zjfsxlMc);//折旧方式(小类)	
								jQuery("input[name='zjfsxlDm'][type!='hidden']").attr('realvalue',cwkj_data.jbxx.zjfsxlDm);	
								
								jQuery("input[name='cbhsffDm'][type!='hidden']").val(cwkj_data.jbxx.cbhsffMc);//成本核算方法	
								jQuery("input[name='cbhsffDm'][type!='hidden']").attr('realvalue',cwkj_data.jbxx.cbhsffDm);	
								jQuery("input[name='cbhsffbz'][type!='hidden']").val(cwkj_data.jbxx.cbhsffBz);	
								
								jQuery("input[name='nsrsbh'][type!='hidden']").val(cwkj_data.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='nsrmc'][type!='hidden']").val(cwkj_data.jbxx.nsrmc);//纳税人名称
								
								
								jQuery("input[name='jbr'][type!='hidden']").val(cwkj_data.jbxx.nsrjbr);//经办人	
								jQuery("input[name='fzr'][type!='hidden']").val(cwkj_data.jbxx.nsrfzr);//负责人	
								jQuery("input[name='bgrq'][type!='hidden']").val(cwkj_data.jbxx.bgrq);//报告日期	
								
								//--会计核算软件信息
								jQuery("input[name='kjhsrjmc'][type!='hidden']").val(cwkj_data.jbxx.kjhsrjMc);//会计核算软件名称
								jQuery("input[name='kjhsrjbbh'][type!='hidden']").val(cwkj_data.jbxx.bbh);//版本号
								jQuery("input[name='kjhsrjqysj'][type!='hidden']").val(cwkj_data.jbxx.qysj);//启用时间
								jQuery("input[name='kjhsrjsjklxmc'][type!='hidden']").val(cwkj_data.jbxx.sjklx);//数据库类型
								jQuery("input[name='kjhsrjbz'][type!='hidden']").val(cwkj_data.jbxx.kjhsrjBz);//备注
								//会计报表情况
								for(var i=0;i<cwkj_data.sqxx.length;i++)
								{
									var cwkjdataObj = {"tds":{
																"cwbbzlDm":{"value":cwkj_data.sqxx[i].kjbbDm},//会计报表情况
																"bbbsqDm":{"value":cwkj_data.sqxx[i].bbbsqjDm},//报表报送期间 
																"kjbbbsqxDm":{"value":cwkj_data.sqxx[i].kjbbbsqxDm},//会计报表报送期限
																"kjbbbz":{"value":cwkj_data.sqxx[i].bz}//会计报表备注
															}
														};
										
										$w('kjbbxxGrid').insertRow(cwkjdataObj);
								}
								
								//其他资料
								for(var i=0;i<cwkj_data.qtzl.length;i++){
								
									var qtzldataObj = {"tds":{
										"qtzlmc":{"value":cwkj_data.qtzl[i].qtzlmc},//名称
										"qtzlbz":{"value":cwkj_data.qtzl[i].bz}//备注
									
									}
								};
									$w('qtzlxxGrid').insertRow(qtzldataObj);
								}
								
								
								
								

							}
						});
					});
		
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
cwkj();