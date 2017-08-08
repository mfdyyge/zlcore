//税务登记-个体经营
function swdj_gtjy() {

try{
	var slhm = jQuery("#winp_shenqinghao").val();
	var url_gtjy='http://98.12.100.191:10086/ws/querySwdjGtjytoJson.action?gtJbxx.slhm='+slhm;
					var gtjy;
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_gtjy,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								gtjy=jsonObj;
								jQuery("input[name='nsrmc'][type!='hidden']").val(gtjy.jbxx.nsrmc);//纳税人名称
								jQuery("input[name='zzjgDm'][type!='hidden']").val(gtjy.jbxx.zzjgDm);//组织机构代码
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzsfzjzl);//业主法定代表人身份证件种类
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.fddbrhfzrhyzsfzjzlDm);
								jQuery("input[name='fddbrhfzrhyzsfzjhm'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzsfzjhm);//业主法定代表人身份证件号码
								jQuery("input[name='zzlxDm'][type!='hidden']").val(gtjy.jbxx.zzlx);//证照名称
								jQuery("input[name='zzlxDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.zzlxDm);
								jQuery("input[name='zzhm'][type!='hidden']").val(gtjy.jbxx.zzhm);//证照号码
									
								//个体经营税务登记证信息采集_纳税人基本信息
								jQuery("input[name='nsrsbh'][type!='hidden']").val(gtjy.jbxx.nsrsbh);//纳税人识别号
								jQuery("input[name='djzclxDm'][type!='hidden']").val(gtjy.jbxx.djzclx);//登记注册类型
								jQuery("input[name='djzclxDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.djzclxDm);
								jQuery("input[name='kyslrq'][type!='hidden']").val(gtjy.jbxx.kyslrq);//开业设立日期
								jQuery("input[name='pzsljglxDm'][type!='hidden']").val(gtjy.jbxx.pzsljglx);//批准设立机关类别（代码）
								jQuery("input[name='pzsljglxDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.pzsljglxDm);
								jQuery("input[name='pzsljgDm'][type!='hidden']").val(gtjy.jbxx.pzsljg);//批准设立机关（代码）
								jQuery("input[name='pzsljgDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.pzsljgDm);
								
								
								jQuery("input[name='fddbrhfzrhyzxm'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzxm);//业主姓名	
								
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").val(gtjy.jbxx.scjydzxzqhsz);//经营地址所在行政区划	
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.scjydzxzqhszDm);
								jQuery("input[name='scjydz'][type!='hidden']").val(gtjy.jbxx.scjydz);//生产经营地址
								jQuery("textarea[name='jyfw'][type!='hidden']").val(gtjy.jbxx.jyfw);//经营范围
								
								jQuery("input[name='gdghlxDm'][type!='hidden']").val(gtjy.jbxx.gdghlx);//国地管户类型（代码）
								jQuery("input[name='gdghlxDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.gdghlxDm);
								jQuery("input[name='bzfsDm'][type!='hidden']").val(gtjy.jbxx.bzfs);//办证方式
								jQuery("input[name='bzfsDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.bzfsDm);
								
								jQuery("input[name='swdlrnsrsbh'][type!='hidden']").val(gtjy.jbxx.swdlrnsrsbh);//税务代理人纳税人别号
								jQuery("input[name='swdlrmc'][type!='hidden']").val(gtjy.jbxx.swdlrmc);//税务代理人名称
								
								/////////基本信息一/////////////////////////////////////////////////////////////////////
								jQuery("input[name='scjyqxq'][type!='hidden']").val(gtjy.jbxx.scjyqxq);//生产经营期限起
								jQuery("input[name='scjyqxz'][type!='hidden']").val(gtjy.jbxx.scjyqxz);//生产经营期限止
								jQuery("input[name='zcdzxzqhszDm'][type!='hidden']").val(gtjy.jbxx.zcdzxzqhsz);//注册地址所在行政区划
								jQuery("input[name='zcdzxzqhszDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.zcdzxzqhszDm);
								jQuery("input[name='zcdz'][type!='hidden']").val(gtjy.jbxx.zcdz);//注册地址
								jQuery("input[name='zcdyzbm'][type!='hidden']").val(gtjy.jbxx.zcdyzbm);//注册地邮编
								jQuery("input[name='zcdlxdh'][type!='hidden']").val(gtjy.jbxx.zcdlxdh);//注册地联系电话
								jQuery("input[name='scjydz'][type!='hidden']").val(gtjy.jbxx.scjydz);//生产经营地址
								jQuery("input[name='scjydyzbm'][type!='hidden']").val(gtjy.jbxx.scjydyzbm);//生产经营地邮编
								jQuery("input[name='scjydlxdh'][type!='hidden']").val(gtjy.jbxx.scjydlxdh);//生产经营地联系电话
								jQuery("input[name='hhrs'][type!='hidden']").val(gtjy.jbxx.hhrs);//合伙人数
								jQuery("input[name='ggrs'][type!='hidden']").val(gtjy.jbxx.ggrs);//雇工人数
								jQuery("input[name='gdgrs'][type!='hidden']").val(gtjy.jbxx.gdgrs);//其中固定工人数
								jQuery("input[name='wz'][type!='hidden']").val(gtjy.jbxx.wz);//网站网址
								jQuery("input[name='hyDm'][type!='hidden']").val(gtjy.jbxx.hy);//国标行业（主）
								jQuery("input[name='hyDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.hyDm);
								jQuery("input[name='hyf1Dm'][type!='hidden']").val(gtjy.jbxx.hyf1);//国标行业（附一）
								jQuery("input[name='hyf1Dm'][type!='hidden']").attr('realvalue',gtjy.jbxx.hyf1Dm);
								jQuery("input[name='hyf2Dm'][type!='hidden']").val(gtjy.jbxx.hyf2);//国标行业（附二）
								jQuery("input[name='hyf2Dm'][type!='hidden']").attr('realvalue',gtjy.jbxx.hyf2Dm);
								jQuery("input[name='hyf3Dm'][type!='hidden']").val(gtjy.jbxx.hyf3);//国标行业（附三）
								jQuery("input[name='hyf3Dm'][type!='hidden']").attr('realvalue',gtjy.jbxx.hyf3Dm);
								
								/////////基本信息二/////////////////////////////////////////////////////////////////////
								jQuery("input[name='fddbrhfzrhyzgddh'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzgddh);//固定电话
								jQuery("input[name='fddbrhfzrhyzyddh'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzyddh);//移动电话
								jQuery("input[name='fddbrhfzrhyzdzyx'][type!='hidden']").val(gtjy.jbxx.fddbrhfzrhyzdzyx);//电子邮箱
								jQuery("input[name='gjhdqszDm'][type!='hidden']").val(gtjy.jbxx.gjhdqszDm);//国籍
								jQuery("input[name='gjhdqszDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.gjhdqszDm);
								jQuery("input[name='hjszd'][type!='hidden']").val(gtjy.jbxx.hjszd);//户籍所在地
								
								/////////合伙人信息/////////////////////////////////////////////////////////////////////
								for(var i=0;i<gtjy.hhr.length;i++){	
										
									var hhrObj = {"tds":{
															
																
																"tzfhhhrmc":{"value":gtjy.hhr[i].tzfhhhrmc},//合伙人名称
																"gjhdqszDm":{"value":gtjy.hhr[i].gjhdqszDm},//国籍
																//"gjhdqszDm":{"realvalue":gtjy.hhr[i].gjhdqszDm},
																"dz":{"value":gtjy.hhr[i].dz},//地址
																"tzfhhhrzjzlDm":{"value":gtjy.hhr[i].tzfhhhrzjzlDm},//证件种类
																//"tzfhhhrzjzlDm":{"realvalue":gtjy.hhr[i].tzfhhhrzjzlDm},
																"tzfhhhrzjhm":{"value":gtjy.hhr[i].tzfhhhrzjhm},//证件号码
																"tzje":{"value":gtjy.hhr[i].tzje},//投资金额（万元）
																"tzbl":{"value":gtjy.hhr[i].tzbl},//投资比例（%）	
																"fpbl":{"value":gtjy.hhr[i].fpbl}//分配比例（%）
															}
														};
									$w('tzfxxGrid').insertRow(hhrObj);
								}
								
								/////////分店情况/////////////////////////////////////////////////////////////////////
								for(var i=0;i<gtjy.fdqk.length;i++){	
									var fdqkObj = {"tds":{
															
																
																"fzjghfdnsrsbh":{"value":gtjy.fdqk[i].fzjghfdnsrsbh},//纳税人识别号
																"fzjghfdmc":{"value":gtjy.fdqk[i].fzjghfdmc},//分店名称
																"fzjghfddz":{"value":gtjy.fdqk[i].fzjghfddz},//分店地址
																"fzjghfdlxdh":{"value":gtjy.fdqk[i].fzjghfdlxdh}//分店联系电话
															}
														};
									$w('fzjgGrid').insertRow(fdqkObj);
								}
								/////////基本信息三/////////////////////////////////////////////////////////////////////
								jQuery("input[name='jdxzDm'][type!='hidden']").val(gtjy.jbxx.jdxz);//纳税人所处乡街
								jQuery("input[name='jdxzDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.jdxzDm);
								jQuery("input[name='dwlsgxDm'][type!='hidden']").val(gtjy.jbxx.dwlsgx);//隶属关系
								jQuery("input[name='dwlsgxDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.dwlsgxDm);
								jQuery("input[name='gszgswjDm'][type!='hidden']").val(gtjy.jbxx.gszgswj);//国税主管税务机关
								jQuery("input[name='gszgswjDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.gszgswjDm);
								jQuery("input[name='gszgswskfjDm'][type!='hidden']").val(gtjy.jbxx.gszgswskfj);//国税主管税务所（科、分局）
								jQuery("input[name='gszgswskfjDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.gszgswskfjDm);
								jQuery("input[name='dszgswjDm'][type!='hidden']").val(gtjy.jbxx.dszgswj);//地税主管税务机关
								jQuery("input[name='dszgswjDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.dszgswjDm);
								jQuery("input[name='dszgswskfjDm'][type!='hidden']").val(gtjy.jbxx.dszgswskfj);//地税主管税务所（科、分局）
								jQuery("input[name='dszgswskfjDm'][type!='hidden']").attr('realvalue',gtjy.jbxx.dszgswskfjDm);
								
								/////////代扣代缴、代收代缴税款/////////////////////////////////////////////////////////////////////
								for(var i=0;i<gtjy.dkdj.length;i++){	
										
									var dkdjObj = {"tds":{
															
																
																"dkdjdsdjskywnr":{"value":gtjy.dkdj[i].dkdjdsdjskywnr},//代扣代缴、代收代缴税款义务内容
																"dkdjdsdjsz":{"value":gtjy.dkdj[i].dkdjdsdjszdm}//,//代扣代缴、代收代缴税种
																//"dkdjdsdjsz":{"realvalue":gtjy.dkdj[i].dkdjdsdjszdm}
															}
														};
									$w('dkdjdsdjskxxGrid').insertRow(dkdjObj);
								}
							}
						});
					});

								//验证信息
								
								
								//jQuery("input[name='slrq']").val("2012");//受理日期
	}catch(e){alert("extends\n"+e);}							//jQuery("input[name='pzsljgDm']").val("2012");//修改受理日期理由
								//jQuery("input[name='slswjgmc']").val("2012");//受理税务机关
}
swdj_gtjy();