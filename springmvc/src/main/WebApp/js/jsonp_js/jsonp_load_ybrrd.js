//增值税一般纳税人申请认定表   
function ybrrd()
{
	var ybrrd_data;
	
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_ybrrd='http://98.12.100.191:10086/ws/queryYbrrdtoJson.action?ybrrd.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_ybrrd,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								ybrrd_data=jsonObj;
								
								
								jQuery("input[name='nsrsbh'][type!='hidden']").val(ybrrd_data.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='nsrmc'][type!='hidden']").val(ybrrd_data.jbxx.nsrmc);//纳税人名称
								
								//法人代表基本信息
								jQuery("input[name='fddbrhfzrhyzxm'][type!='hidden']").val(ybrrd_data.jbxx.fddbrhfzrhyzMc);//法定代表人
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").val(ybrrd_data.jbxx.fddbrsfzjmc);//证件名称
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").attr('realvalue',ybrrd_data.jbxx.fddbrsfzjlx);//证件类型
								jQuery("input[name='fddbrhfzrhyzsfzjhm'][type!='hidden']").val(ybrrd_data.jbxx.fddbrsfzjhm);//证件号码
								jQuery("input[name='fddbrhfzrhyzyddh'][type!='hidden']").val(ybrrd_data.jbxx.fddbrlxdh);//联系电话
								//财务负责人基本信息
								jQuery("input[name='cwfzrxm'][type!='hidden']").val(ybrrd_data.jbxx.cwfzrMc);//财务负责人
								jQuery("input[name='cwfzrsfzjzlDm'][type!='hidden']").val(ybrrd_data.jbxx.cwfzrsfzjmc);//证件名称
								jQuery("input[name='cwfzrsfzjzlDm'][type!='hidden']").attr('realvalue',ybrrd_data.jbxx.cwfzrsfzjlx);//证件类型
								jQuery("input[name='cwfzrsfzjhm'][type!='hidden']").val(ybrrd_data.jbxx.cwfzrsfzjhm);//证件号码
								jQuery("input[name='cwfzryddh'][type!='hidden']").val(ybrrd_data.jbxx.cwfzrlxdh);//联系电话
								//办税人员基本信息
								jQuery("input[name='bsrxm'][type!='hidden']").val(ybrrd_data.jbxx.bsrymc);//办税人
								jQuery("input[name='bsrsfzjzlDm'][type!='hidden']").val(ybrrd_data.jbxx.bsrysfzjmc);//证件类型
								jQuery("input[name='bsrsfzjzlDm'][type!='hidden']").attr('realvalue',ybrrd_data.jbxx.bsrysfzjlx);//证件类型
								jQuery("input[name='bsrsfzjhm'][type!='hidden']").val(ybrrd_data.jbxx.bsrysfzjhm);//证件号码
								jQuery("input[name='bsryddh'][type!='hidden']").val(ybrrd_data.jbxx.bsrylxdh);//联系电话
								//企业基本信息
								jQuery("input[name='scjydz'][type!='hidden']").val(ybrrd_data.jbxx.scjydz);//生产经营地址
								jQuery("input[name='hsdz'][type!='hidden']").val(ybrrd_data.jbxx.hsdz);//核算地址
								jQuery("input[name='nsrlb'][type!='hidden']").val(ybrrd_data.jbxx.nsrlbmc);//纳税人类别名称
								jQuery("input[name='nsrlb'][type!='hidden']").attr('realvalue',ybrrd_data.jbxx.nsrlb);//纳税人类别
								jQuery("input[name='nsrzy'][type!='hidden']").val(ybrrd_data.jbxx.nsrzymc);//纳税人主业名称
								jQuery("input[name='nsrzy'][type!='hidden']").attr('realvalue',ybrrd_data.jbxx.nsrzylb);//纳税人主业
								//jQuery("input[name='xkyhbz'][type!='hidden']").val(ybrrd_data.jbxx.sfwxkyhlx);//是否为新开用户   
                                 if(ybrrd_data.jbxx.sfwxkyhlx==1){								
                                jQuery("input:radio:first").attr("checked",'true');//是否为新开用户
								}else{
								jQuery("input:radio:last").attr("checked",'true');
								}
								jQuery("input[name='jsrqq'][type!='hidden']").val(ybrrd_data.jbxx.rdqxsejsrqq);//认定前销售额计算日期起                                                                       //是否为新开用户
								jQuery("input[name='jsrqz'][type!='hidden']").val(ybrrd_data.jbxx.rdqxsejsrqz);//认定前销售额计算日期止                                                                       //是否为新开用户
								jQuery("input[name='zzsysxse'][type!='hidden']").val(ybrrd_data.jbxx.rdqljysxse);//认定前累积应税销售额                                                                //是否为新开用户
								jQuery("input[name='sqrq'][type!='hidden']").val(ybrrd_data.jbxx.sqrq);//申请日期                                                              //是否为新开用户

								
								
								

							}
						});
					});
		
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
ybrrd();