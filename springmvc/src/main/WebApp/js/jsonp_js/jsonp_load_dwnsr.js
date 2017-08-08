//税务登记-单位纳税人
function swdj_dwnsr() {
			try{	
					var slhm = jQuery("#winp_shenqinghao").val();
					var url_dwnsr='http://98.12.100.191:10086/ws/querySwdjSwnsrtoJson.action?dwJbxx.slhm='+slhm;
					var dwnsr;
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_dwnsr,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								dwnsr=jsonObj;
								//////////////////////////基本信息///////////////////////////////////////////////////////////////////
								//验证信息
								jQuery("input[name='nsrmc'][type!='hidden']").val(dwnsr.jbxx.nsrmc);//纳税人名称
								jQuery("input[name='zzjgDm'][type!='hidden']").val(dwnsr.jbxx.zzjgDm);//组织机构代码
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzsfzjzl);//法定代表人身份证件种类代码
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.fddbrhfzrhyzsfzjzlDm);
								jQuery("input[name='fddbrhfzrhyzsfzjhm'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzsfzjhm);//法定代表人身份证件号码
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").val(dwnsr.jbxx.scjydzxzqhsz);//经营地址所在行政区划
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.scjydzxzqhszDm);	
								//基本信息
								jQuery("input[name='nsrsbh'][type!='hidden']").val(dwnsr.jbxx.nsrsbh);//纳税人识别号
	
								jQuery("input[name='pzsljglxDm'][type!='hidden']").val(dwnsr.jbxx.pzsljglx);//批准设立机关类别（代码）
								jQuery("input[name='pzsljglxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.pzsljglxDm);	
								jQuery("input[name='pzsljgDm'][type!='hidden']").val(dwnsr.jbxx.pzsljg);//批准设立机关（代码）
								jQuery("input[name='pzsljgDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.pzsljgDm);	
								jQuery("input[name='pzzmhwjh'][type!='hidden']").val(dwnsr.jbxx.pzzmhwjh);//批准设立证明或文件	
								
								jQuery("input[name='zzlxDm'][type!='hidden']").val(dwnsr.jbxx.zzlx);//证照名称（代码）
								jQuery("input[name='zzlxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.zzlxDm);	
								jQuery("input[name='zzlxmc'][type!='hidden']").val(dwnsr.jbxx.zzlx);//证照名称（代码）
								
								jQuery("input[name='zzhm'][type!='hidden']").val(dwnsr.jbxx.zzhm);//证照号码	
								
								jQuery("input[name='djzclxDm'][type!='hidden']").val(dwnsr.jbxx.djzclx);//登记注册类型（代码）
								jQuery("input[name='djzclxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.djzclxDm);	
								jQuery("input[name='kyslrq'][type!='hidden']").val(dwnsr.jbxx.kyslrq);//开业设立日期

								jQuery("input[name='fddbrhfzrhyzxm'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzxm);//法定代表人（负责人）名称
								
								jQuery("input[name='zfjglxDm'][type!='hidden']").val(dwnsr.jbxx.zfjglx);//总分机构类型（代码）
								jQuery("input[name='zfjglxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.zfjglxDm);
								//jQuery("input[name='scjydzxzqhszcaption']").val(dwnsr.jbxx.scjydzxzqhszDm);//经营地址所在行政区划
								jQuery("input[name='scjydz'][type!='hidden']").val(dwnsr.jbxx.scjydz);//生产经营地址
								jQuery("input[name='gdghlxDm'][type!='hidden']").val(dwnsr.jbxx.gdghlx);//国地管户类型（代码）
								jQuery("input[name='gdghlxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.gdghlxDm);
								jQuery("input[name='bzfsDm'][type!='hidden']").val(dwnsr.jbxx.bzfs);//办证方式
								jQuery("input[name='bzfsDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.bzfsDm);
								jQuery("textarea[name='jyfw'][type!='hidden']").val(dwnsr.jbxx.jyfw);//经营范围
								//jQuery("input[name='slrq'][type!='hidden']").val("2012");//受理日期
								//jQuery("input[name='pzsljgDm'][type!='hidden']").val("2012");//修改受理日期理由
								//jQuery("input[name='slswjgmc']").val("2012");//受理税务机关
								
								jQuery("input[name='zjgnsrsbh'][type!='hidden']").val(dwnsr.jbxx.zjgnsrsbh);//总机构纳税人识别号
								jQuery("input[name='zjgfddbrxm'][type!='hidden']").val(dwnsr.jbxx.zjgfddbrxm);//总机构法定代表人姓名
								jQuery("input[name='zjgzcdzyzbm'][type!='hidden']").val(dwnsr.jbxx.zjgzcdzyzbm);//总机构注册地址邮编
								jQuery("input[name='zjgmc'][type!='hidden']").val(dwnsr.jbxx.zjgmc);//总机构名称
								jQuery("input[name='zjgzcdz'][type!='hidden']").val(dwnsr.jbxx.zjgZcdz);//总机构注册地址
								jQuery("textarea[name='zjgjyfw'][type!='hidden']").val(dwnsr.jbxx.zjgJyfw);//总机构经营范围
								jQuery("input[name='zjglxdh'][type!='hidden']").val(dwnsr.jbxx.zjgLxdh);//总机构联系电话
															
								//////////////////////////总分机构///////////////////////////////////////////////////////////////////	
								for(var i=0;i<dwnsr.fzjg.length;i++){	
										
									var zfjgObj = {"tds":{
															//分支机构fzjgxxGrid
																"fzjghfdnsrsbh":{"value":dwnsr.fzjg[i].fzjghfdnsrsbh},//分支机构纳税人识别号
																"fzjghfdmc":{"value":dwnsr.fzjg[i].fzjghfdmc},//分支机构名称
																"fzjghfddz":{"value":dwnsr.fzjg[i].fzjghfddz}//分支机构注册地址
																
																
															}
														};
									$w('fzjgxxGrid').insertRow(zfjgObj);
								}
								
								//////////////////////////基本信息一///////////////////////////////////////////////////////////////////	
								jQuery("input[name='scjyqxq'][type!='hidden']").val(dwnsr.jbxx.scjyqxq);//生产经营期限起
								jQuery("input[name='scjyqxz'][type!='hidden']").val(dwnsr.jbxx.scjyqxz);//生产经营期限止
								jQuery("input[name='zcdzxzqhszDm'][type!='hidden']").val(dwnsr.jbxx.zcdzxzqhsz);//注册地址所在行政区划
								jQuery("input[name='zcdzxzqhszDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.zcdzxzqhszDm);	
								jQuery("input[name='zcdz'][type!='hidden']").val(dwnsr.jbxx.zcdz);//注册地址
								jQuery("input[name='zcdyzbm'][type!='hidden']").val(dwnsr.jbxx.zcdyzbm);//注册地邮编
								jQuery("input[name='zcdlxdh'][type!='hidden']").val(dwnsr.jbxx.zcdlxdh);//注册地联系电话
								jQuery("input[name='scjydyzbm'][type!='hidden']").val(dwnsr.jbxx.scjydyzbm);//生产经营地邮编
								jQuery("input[name='scjydlxdh'][type!='hidden']").val(dwnsr.jbxx.scjydlxdh);//生产经营地联系电话
								jQuery("input[name='hsfsDm'][type!='hidden']").val(dwnsr.jbxx.hsfs);//核算方式
								jQuery("input[name='hsfsDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.hsfsDm);	
								jQuery("input[name='cyrs'][type!='hidden']").val(dwnsr.jbxx.cyrs);//从业人数
								jQuery("input[name='wjcyrs'][type!='hidden']").val(dwnsr.jbxx.wjcyrs);//其中外籍人数
								jQuery("input[name='zzjglxDm'][type!='hidden']").val(dwnsr.jbxx.zzjglx);//单位性质
								jQuery("input[name='zzjglxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.zzjglxDm);
								jQuery("input[name='wz'][type!='hidden']").val(dwnsr.jbxx.wz);//网站网址
								jQuery("input[name='kjzdzzDm'][type!='hidden']").val(dwnsr.jbxx.kjzdzz);//适用会计制度
								jQuery("input[name='kjzdzzDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.kjzdzzDm);	
								jQuery("input[name='hyDm'][type!='hidden']").val(dwnsr.jbxx.hy);//国标行业（主）
								jQuery("input[name='hyDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.hyDm);	
								
								jQuery("input[name='hyf1Dm'][type!='hidden']").val(dwnsr.jbxx.hyf1);//国标行业（附一）
								jQuery("input[name='hyf1Dm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.hyf1Dm);	
								
								jQuery("input[name='hyf2Dm'][type!='hidden']").val(dwnsr.jbxx.hyf2);//国标行业（附二）
								jQuery("input[name='hyf2Dm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.hyf2Dm);	
								jQuery("input[name='hyf3Dm'][type!='hidden']").val(dwnsr.jbxx.hyf3);//国标行业（附三）
								jQuery("input[name='hyf3Dm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.hyf3Dm);	

								
								
								
								
								
								//////////////////////////基本信息二///////////////////////////////////////////////////////////////////	
								jQuery("input[name='fddbrhfzrhyzgddh'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzgddh);//法定代表人固定电话
								jQuery("input[name='fddbrhfzrhyzyddh'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzyddh);//法定代表人移动电话
								jQuery("input[name='fddbrhfzrhyzdzyx'][type!='hidden']").val(dwnsr.jbxx.fddbrhfzrhyzdzyx);//法定代表人电子邮箱
								
								jQuery("input[name='cwfzrxm'][type!='hidden']").val(dwnsr.jbxx.cwfzrxm);//财务负责人姓名
								jQuery("input[name='cwfzrsfzjzlDm'][type!='hidden']").val(dwnsr.jbxx.cwfzrsfzjzl);//身份证件种类
								jQuery("input[name='cwfzrsfzjzlDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.cwfzrsfzjzlDm);
								jQuery("input[name='cwfzrsfzjhm'][type!='hidden']").val(dwnsr.jbxx.cwfzrsfzjhm);//身份证件号码
								jQuery("input[name='cwfzrgddh'][type!='hidden']").val(dwnsr.jbxx.cwfzrgddh);//固定电话
								jQuery("input[name='cwfzryddh'][type!='hidden']").val(dwnsr.jbxx.cwfzryddh);//移动电话
								jQuery("input[name='cwfzrdzyx'][type!='hidden']").val(dwnsr.jbxx.cwfzrdzyx);//电子邮箱
								
								jQuery("input[name='swdlrmc'][type!='hidden']").val(dwnsr.jbxx.swdlrmc);//税务代理人姓名
								jQuery("input[name='swdlrnsrsbh'][type!='hidden']").val(dwnsr.jbxx.swdlrnsrsbh);//纳税人识别号
								jQuery("input[name='swdlrlxdh'][type!='hidden']").val(dwnsr.jbxx.swdlrlxdh);//联系电话
								jQuery("input[name='swdlrdzyx'][type!='hidden']").val(dwnsr.jbxx.swdlrdzyx);//电子邮箱
								
								jQuery("input[name='bsrxm'][type!='hidden']").val(dwnsr.jbxx.bsrxm);//办税人姓名
								jQuery("input[name='bsrsfzjzlDm'][type!='hidden']").val(dwnsr.jbxx.bsrsfzjzl);//身份证件种类
								jQuery("input[name='bsrsfzjzlDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.bsrsfzjzlDm);
								jQuery("input[name='bsrsfzjhm'][type!='hidden']").val(dwnsr.jbxx.bsrsfzjhm);//身份证件号码
								jQuery("input[name='bsrgddh'][type!='hidden']").val(dwnsr.jbxx.bsrgddh);//固定电话
								jQuery("input[name='bsryddh'][type!='hidden']").val(dwnsr.jbxx.bsryddh);//移动电话
								jQuery("input[name='bsrdzyx'][type!='hidden']").val(dwnsr.jbxx.bsrdzyx);//电子邮箱
								
								
								//////////////////////////基本信息三///////////////////////////////////////////////////////////////////
								jQuery("input[name='zczb'][type!='hidden']").val(dwnsr.jbxx.zczb);//注册资本
								if(dwnsr.zczb.length>0){
								jQuery("input[name='zczbbzyDm'][type!='hidden']").val(dwnsr.zczb[0].bz);//币种一
								jQuery("input[name='zczbbzyDm'][type!='hidden']").attr('realvalue',dwnsr.zczb[0].zczbbzyDm);
								jQuery("input[name='zczbbzyje'][type!='hidden']").val(dwnsr.zczb[0].je);//金额一
								}
								if(dwnsr.zczb.length>1){
								jQuery("input[name='zczbbzeDm'][type!='hidden']").val(dwnsr.zczb[1].bz);//币种二
								jQuery("input[name='zczbbzeDm'][type!='hidden']").attr('realvalue',dwnsr.zczb[1].zczbbzeDm);
								jQuery("input[name='zczbbzeje'][type!='hidden']").val(dwnsr.zczb[1].je);//金额二
								}
								if(dwnsr.zczb.length>2){
								jQuery("input[name='zczbbzsDm'][type!='hidden']").val(dwnsr.zczb[2].bz);//币种三
								jQuery("input[name='zczbbzsDm'][type!='hidden']").attr('realvalue',dwnsr.zczb[2].zczbbzsDm);
								jQuery("input[name='zczbbzsje'][type!='hidden']").val(dwnsr.zczb[2].je);//金额三
								}
								jQuery("input[name='tzze']").val(dwnsr.jbxx.tzze);//投资总额
								
								if(dwnsr.tzze.length>0){
								jQuery("input[name='tzzebzyDm'][type!='hidden']").val(dwnsr.tzze[0].bz);//币种一
								jQuery("input[name='tzzebzyDm'][type!='hidden']").attr('realvalue',dwnsr.tzze[0].tzzebzyDm);
								jQuery("input[name='tzzebzyje'][type!='hidden']").val(dwnsr.tzze[0].je);//金额一
								}
								if(dwnsr.tzze.length>1){
								jQuery("input[name='tzzebzeDm'][type!='hidden']").val(dwnsr.tzze[1].bz);//币种二
								jQuery("input[name='tzzebzeDm'][type!='hidden']").attr('realvalue',dwnsr.tzze[1].tzzebzeDm);
								jQuery("input[name='tzzebzeje'][type!='hidden']").val(dwnsr.tzze[1].je);//金额二
								}
								if(dwnsr.tzze.length>2){
								jQuery("input[name='tzzebzsDm'][type!='hidden']").val(dwnsr.tzze[2].bz);//币种三
								jQuery("input[name='tzzebzsDm'][type!='hidden']").attr('realvalue',dwnsr.tzze[2].tzzebzsDm);
								jQuery("input[name='tzzebzsje'][type!='hidden']").val(dwnsr.tzze[2].je);//金额三
								}
								jQuery("input[name='gykglxDm'][type!='hidden']").val(dwnsr.jbxx.gykglx);//国有控股类型
								jQuery("input[name='gykglxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.gykglxDm);
								jQuery("input[name='zrrtzbl'][type!='hidden']").val(dwnsr.jbxx.zrrtzbl);//自然人投资比例（%）
								jQuery("input[name='wztzbl'][type!='hidden']").val(dwnsr.jbxx.wztzbl);//外资投资比例（%）
								jQuery("input[name='gytzbl'][type!='hidden']").val(dwnsr.jbxx.gytzbl);//国有投资比例（%）
								
								//////////////////////////投资方信息///////////////////////////////////////////////////////////////////
								for(var i=0;i<dwnsr.tzfxx.length;i++){	
									var tzfxxObj = {"tds":{
																/*
																"gjhdqszmc":{"value":dwnsr.tzfxx[i].gjhdqszmc},//国籍名称
																"tzfhhhrzjzlmc":{"value":dwnsr.tzfxx[i].tzfhhhrzjzlmc},//证件种类名称
																"tzfjjxzmc":{"value":dwnsr.tzfxx[i].tzfjjxzmc},//投资方经济性质名称
																"uuid":{"value":dwnsr.tzfxx[i].uuid},//投资方uuid
																"drxxuuid":{"value":dwnsr.tzfxx[i].drxxuuid},//投资方uuid
																"XZ":{"value":dwnsr.tzfxx[i].XZ},//选择
																*/
																
																"tzfhhhrmc":{"value":dwnsr.tzfxx[i].tzfhhhrmc},//投资方名称
																//"tzfjjxzmc":{"value":dwnsr.tzfxx[i].tzfjjxzDm},//投资方经济性质名称
																"tzfjjxzDm":{"realvalue":dwnsr.tzfxx[i].tzfjjxzDm},//投资方经济性质
																//"tzfjjxzDm":{"realvalue":dwnsr.tzfxx[i].tzfjjxzDm},
																"tzbl":{"value":dwnsr.tzfxx[i].tzbl},//投资比例(%)
																"tzfhhhrzjzlDm":{"value":dwnsr.tzfxx[i].tzfhhhrzjzlDm},//证件种类
																"tzfhhhrzjhm":{"value":dwnsr.tzfxx[i].tzfhhhrzjhm},//证件号码
																"gjhdqszDm":{"value":dwnsr.tzfxx[i].gjhdqszDm},//国籍
																//"gjhdqszDm":{"realvalue":dwnsr.tzfxx[i].gjhdqszDm},
																"dz":{"value":dwnsr.tzfxx[i].dz}//地址	
															}
														};
									$w('tzfxxGrid').insertRow(tzfxxObj);
								}
								
								//////////////////////////基本信息四///////////////////////////////////////////////////////////////////
								//总分机构信息
								
								//////////////////////////基本信息五///////////////////////////////////////////////////////////////////
								jQuery("input[name='jdxzDm'][type!='hidden']").val(dwnsr.jbxx.jdxz);//纳税人所处乡街
								jQuery("input[name='jdxzDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.jdxzDm);
								jQuery("input[name='dwlsgxDm'][type!='hidden']").val(dwnsr.jbxx.dwlsgx);//隶属关系
								jQuery("input[name='dwlsgxDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.dwlsgxDm);
								jQuery("input[name='gszgswjDm'][type!='hidden']").val(dwnsr.jbxx.gszgswj);//国税主管税务机关
								jQuery("input[name='gszgswjDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.gszgswjDm);
								jQuery("input[name='gszgswskfjDm'][type!='hidden']").val(dwnsr.jbxx.gszgswskfj);//国税主管税务所（科、分局）
								jQuery("input[name='gszgswskfjDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.gszgswskfjDm);
								jQuery("input[name='dszgswjDm'][type!='hidden']").val(dwnsr.jbxx.dszgswj);//地税主管税务机关
								jQuery("input[name='dszgswjDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.dszgswjDm);
								jQuery("input[name='dszgswskfjDm'][type!='hidden']").val(dwnsr.jbxx.dszgswskfj);//地税主管税务所（科、分局）
								jQuery("input[name='dszgswskfjDm'][type!='hidden']").attr('realvalue',dwnsr.jbxx.dszgswskfjDm);
								
								//////////////////////////代扣代缴、代收代缴///////////////////////////////////////////////////////////////////
								
								for(var i=0;i<dwnsr.dkdj.length;i++){	
									var dkdjObj = {"tds":{
																/*
																"xz":{"value":dwnsr.dkdj[i].xz},//选择
																*/

																"dkdjdsdjskywnr":{"value":dwnsr.dkdj[i].dkdjdsdjskywnr},//代扣代缴、代收代缴税款义务内容
																"dkdjdsdjsz":{"value":dwnsr.dkdj[i].dkdjdsdjszdm}//,//代扣代缴、代收代缴税种
																//"dkdjdsdjsz":{"realvalue":dwnsr.dkdj[i].dkdjdsdjszdm}
															}
														};
									$w('dkdjdsdjskxxGrid').insertRow(dkdjObj);
								}
								
								
								
							}
						});
					});
						

								
	}catch(e){alert("extends\n"+e);}
}
swdj_dwnsr();