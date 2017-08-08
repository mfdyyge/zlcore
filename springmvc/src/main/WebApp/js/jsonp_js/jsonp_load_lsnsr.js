//临时纳税人税务登记
function swdj_lsnsr() {

try{
	var slhm = jQuery("#winp_shenqinghao").val();
	var url_lsnsr='http://98.12.100.191:10086/ws/queryLsnsrtoJson.action?lsJbxx.slhm='+slhm;
					var lsnsr;
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_lsnsr,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								lsnsr=jsonObj;
								////基本信息///////////////////////////////////////////////////////////////////
								jQuery("input[name='nsrmc'][type!='hidden']").val(lsnsr.jbxx.nsrmc);//*纳税人名称
								jQuery("input[name='zzjgDm'][type!='hidden']").val(lsnsr.jbxx.zzjgdm);//组织机构代码
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").val(lsnsr.jbxx.fdzl);//*法定代表人身份证件种类 
								jQuery("input[name='fddbrhfzrhyzsfzjzlDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.fddbrhfzrhyzsfzjzlDm);
								jQuery("input[name='fddbrhfzrhyzsfzjhm'][type!='hidden']").val(lsnsr.jbxx.fdhm);//*法定代表人身份证件号码
								jQuery("input[name='zzlxDm'][type!='hidden']").val(lsnsr.jbxx.zzmc);//证照名称
								jQuery("input[name='zzlxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.zzmc_code);
								jQuery("input[name='zzhm'][type!='hidden']").val(lsnsr.jbxx.zzhm);//证照号码
								jQuery("textarea[name='jyfw'][type!='hidden']").val(lsnsr.jbxx.jyfw);//*经营范围
								jQuery("input[name='gdghlxDm'][type!='hidden']").val(lsnsr.jbxx.gdgglx);//*国地共管户类型
								jQuery("input[name='gdghlxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.gdgglx_code);
								jQuery("input[name='djzclxDm'][type!='hidden']").val(lsnsr.jbxx.djzclx);//*登记注册类型
								jQuery("input[name='djzclxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.djzclx_code);
								jQuery("input[name='lsswdjlxDm'][type!='hidden']").val(lsnsr.jbxx.lx);//*临时税务登记类型
								jQuery("input[name='lsswdjlxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.lxDm);
	
								jQuery("input[name='kyslrq'][type!='hidden']").val(lsnsr.jbxx.kyrq);//*开业设立日期
								jQuery("input[name='pzsljglxDm'][type!='hidden']").val(lsnsr.jbxx.pzsljglb);//批准设立机关类别
								jQuery("input[name='pzsljglxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.pzsljglb_code);
								jQuery("input[name='pzsljgDm'][type!='hidden']").val(lsnsr.jbxx.pzsljg);//批准设立机关	
								jQuery("input[name='pzsljgDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.pzsljgDm);
								jQuery("input[name='pzzmhwjh'][type!='hidden']").val(lsnsr.jbxx.pzslwh);//批准设立证明或文件	
								jQuery("input[name='fddbrhfzrhyzxm'][type!='hidden']").val(lsnsr.jbxx.fdxm);//*法定代表人（负责人）名称
								jQuery("input[name='zfjglxDm'][type!='hidden']").val(lsnsr.jbxx.zfjglx);//*总分机构类型
								jQuery("input[name='zfjglxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.zfjglx_code);
								
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").val(lsnsr.jbxx.jydzszxzqy);//*经营地址所在行政区划
								jQuery("input[name='scjydzxzqhszDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.jydzszxzqy_code);
								jQuery("input[name='bzfsDm'][type!='hidden']").val(lsnsr.jbxx.bsfs);//*办证方式
								jQuery("input[name='bzfsDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.bsfs_code);
								
								jQuery("input[name='scjydz'][type!='hidden']").val(lsnsr.jbxx.scjydz);//*生产经营地址
								jQuery("input[name='lsswdjyxqq'][type!='hidden']").val(lsnsr.jbxx.lsswdjyxqq);//*临时税务登记有效期起
								
								jQuery("input[name='lsswdjyxqz'][type!='hidden']").val(lsnsr.jbxx.lsswdjyxqz);//临时税务登记有效期止
								//代理人未填写，可能会出现错误
								try{
								jQuery("input[name='swdlrmc'][type!='hidden']").val(lsnsr.dlrxx[0].swdlmc);//税务代理人姓名 
								jQuery("input[name='swdlrnsrsbh'][type!='hidden']").val(lsnsr.dlrxx[0].dlnsrsbh);//税务代理人纳税人识别号
								}catch(e){
								}
								
								
								
								jQuery("input[name='zjgnsrsbh'][type!='hidden']").val(lsnsr.jbxx.zjgnsrsbh);//*总机构纳税人识别号
								jQuery("input[name='zjgfddbrxm'][type!='hidden']").val(lsnsr.jbxx.fddbrxm);//*总机构法定代表人姓名
								jQuery("input[name='zjglxdh'][type!='hidden']").val(lsnsr.jbxx.fddbrmc);//*总机构联系电话
								jQuery("input[name='zjgzcdzyzbm'][type!='hidden']").val(lsnsr.jbxx.zcdzyzbm);//*总机构注册地址邮编
								jQuery("input[name='zjgmc'][type!='hidden']").val(lsnsr.jbxx.zjgmc);//*总机构名称
								jQuery("input[name='zjgzcdz'][type!='hidden']").val(lsnsr.jbxx.zjgzcdz);//*总机构注册地址
								jQuery("input[name='zjgjyfw'][type!='hidden']").val(lsnsr.jbxx.zjgjyfw);//*总机构经营范围
								
								
								//////分支机构/////////////////////////////////////////////////
								for(var i=0;i<lsnsr.fzjg.length;i++){	
										
									var fzjgObj = {"tds":{
															//分支机构fzjgxxGrid
																"fzjghfdnsrsbh":{"value":lsnsr.fzjg[i].nsrsbh},//分支机构纳税人识别号
																"fzjghfdmc":{"value":lsnsr.fzjg[i].fzjgmc},//分支机构名称
																"fzjghfddz":{"value":lsnsr.fzjg[i].zcdz}//分支机构注册地址
																
																
															}
														};
									$w('fzjgxxGrid').insertRow(fzjgObj);
								}
								
								///////////基本信息一///////////////////////////////////////////////////////////////////
								jQuery("input[name='scjyqxq']").val(lsnsr.jbxx.scjyqxq);//生产经营期限起
								jQuery("input[name='scjyqxz']").val(lsnsr.jbxx.scjyqxz);//生产经营期限止
								jQuery("input[name='zcdzxzqhszDm']").val(lsnsr.jbxx.zzdzxzql);//注册地址所在行政区划
								jQuery("input[name='zcdzxzqhszDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.zzdzxzql_code);
								jQuery("input[name='zcdz']").val(lsnsr.jbxx.zcdz);//注册地址
								jQuery("input[name='zcdyzbm']").val(lsnsr.jbxx.zcyzbm);//注册地邮编
								jQuery("input[name='zcdlxdh']").val(lsnsr.jbxx.yzlxdh);//注册地联系电话
								jQuery("input[name='scjydyzbm']").val(lsnsr.jbxx.scyzbm);//生产经营地邮编
								jQuery("input[name='scjydlxdh']").val(lsnsr.jbxx.yzblxdh);//生产经营地联系电话
								jQuery("input[name='hsfsDm']").val(lsnsr.jbxx.hsfs);//核算方式
								jQuery("input[name='hsfsDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.hsfsDm);
								jQuery("input[name='cyrs']").val(lsnsr.jbxx.cyry);//从业人数
								jQuery("input[name='wjcyrs']").val(lsnsr.jbxx.qzwjrs);//其中外籍人数
								jQuery("input[name='zzjglxDm']").val(lsnsr.jbxx.dwxz);//单位性质
								jQuery("input[name='zzjglxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.dwxzDm);
								jQuery("input[name='wz']").val(lsnsr.jbxx.wlwz);//网站网址
								jQuery("input[name='kjzdzzDm']").val(lsnsr.jbxx.sykjzd);//适用会计制度
								jQuery("input[name='kjzdzzDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.kjzdzzDm);
								jQuery("input[name='hyDm']").val(lsnsr.jbxx.gbxy);//国标行业（主）
								jQuery("input[name='hyDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.hyDm);
								jQuery("input[name='hyf1Dm']").val(lsnsr.jbxx.hyf1);//国标行业（附一）
								jQuery("input[name='hyf1Dm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.hyf1Dm);
								jQuery("input[name='hyf2Dm']").val(lsnsr.jbxx.hyf2);//国标行业（附二）
								jQuery("input[name='hyf2Dm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.hyf2Dm);
								jQuery("input[name='hyf3Dm']").val(lsnsr.jbxx.hyf3);//国标行业（附三）
								jQuery("input[name='hyf3Dm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.hyf3Dm);
								
								///////////基本信息二///////////////////////////////////////////////////////////////////
								jQuery("input[name='fddbrhfzrhyzgddh']").val(lsnsr.jbxx.fdgddh);//固定电话
								jQuery("input[name='fddbrhfzrhyzyddh']").val(lsnsr.jbxx.fdyddh);//移动电话
								jQuery("input[name='fddbrhfzrhyzdzyx']").val(lsnsr.jbxx.fddzyx);//电子邮箱
								jQuery("input[name='cwfzrxm']").val(lsnsr.jbxx.cwxm);//财务负责人姓名
								jQuery("input[name='cwfzrsfzjzlDm']").val(lsnsr.jbxx.cwzl);//身份证件种类
								jQuery("input[name='cwfzrsfzjzlDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.cwzlDm);
								jQuery("input[name='cwfzrsfzjhm']").val(lsnsr.jbxx.cwhm);//身份证件号码
								jQuery("input[name='cwfzrgddh']").val(lsnsr.jbxx.cwgddh);//固定电话
								jQuery("input[name='cwfzryddh']").val(lsnsr.jbxx.cwyddh);//移动电话
								jQuery("input[name='cwfzrdzyx']").val(lsnsr.jbxx.cwdzyx);//电子邮箱
								jQuery("input[name='bsrxm']").val(lsnsr.jbxx.bsxm);//办税人姓名
								jQuery("input[name='bsrsfzjzlDm']").val(lsnsr.jbxx.bszl);//身份证件种类
								jQuery("input[name='bsrsfzjzlDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.bszlDm);
								jQuery("input[name='bsrsfzjhm']").val(lsnsr.jbxx.bshm);//身份证件号码
								jQuery("input[name='bsrgddh']").val(lsnsr.jbxx.bsgddh);//固定电话
								jQuery("input[name='bsryddh']").val(lsnsr.jbxx.bsyddh);//移动电话
								jQuery("input[name='bsrdzyx']").val(lsnsr.jbxx.bsdzyx);//电子邮箱
								jQuery("input[name='swdlrlxdh']").val(lsnsr.jbxx.dllxdh);//联系电话
								jQuery("input[name='swdlrdzyx']").val(lsnsr.jbxx.dldzyx);//电子邮箱
								
								///////////基本信息三///////////////////////////////////////////////////////////////////
								jQuery("input[name='zczb']").val(lsnsr.jbxx.zczb);//注册资本
								try{
								jQuery("input[name='zczbbzyDm']").val(lsnsr.zczb[0].bzo);//币种一
								jQuery("input[name='zczbbzyDm'][type!='hidden']").attr('realvalue',lsnsr.zczb[0].bzoDm);
								jQuery("input[name='zczbbzyje']").val(lsnsr.zczb[0].jeo);//金额一
								jQuery("input[name='zczbbzeDm']").val(lsnsr.zczb[1].bzo);//币种二
								jQuery("input[name='zczbbzeDm'][type!='hidden']").attr('realvalue',lsnsr.zczb[1].bzoDm);
								jQuery("input[name='zczbbzeje']").val(lsnsr.zczb[1].jeo);//金额二
								jQuery("input[name='zczbbzsDm']").val(lsnsr.zczb[2].bzo);//币种三
								jQuery("input[name='zczbbzsDm'][type!='hidden']").attr('realvalue',lsnsr.zczb[2].bzoDm);
								jQuery("input[name='zczbbzsje']").val(lsnsr.zczb[2].jeo);//金额三
								jQuery("input[name='tzze']").val(lsnsr.jbxx.tzze);//投资总额
								jQuery("input[name='tzzebzyDm']").val(lsnsr.tzze[0].bzo);//币种一
								jQuery("input[name='tzzebzyDm'][type!='hidden']").attr('realvalue',lsnsr.tzze[0].bzoDm);
								jQuery("input[name='tzzebzyje']").val(lsnsr.tzze[0].jeo);//金额一
								jQuery("input[name='tzzebzeDm']").val(lsnsr.tzze[1].bzoDm);//币种二
								jQuery("input[name='tzzebzeDm'][type!='hidden']").attr('realvalue',lsnsr.tzze[1].bzoDm);
								jQuery("input[name='tzzebzeje']").val(lsnsr.tzze[1].jeo);//金额二
								jQuery("input[name='tzzebzsDm']").val(lsnsr.tzze[2].bzoDm);//币种三
								jQuery("input[name='tzzebzsDm'][type!='hidden']").attr('realvalue',lsnsr.tzze[2].bzoDm);
								jQuery("input[name='tzzebzsje']").val(lsnsr.tzze[2].jeo);//金额三
								}catch(e){}
								jQuery("input[name='gykglxDm']").val(lsnsr.jbxx.gykglxDm);//国有控股类型
								jQuery("input[name='gykglxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.gykglxDm);
								jQuery("input[name='zrrtzbl']").val(lsnsr.jbxx.zrrtzbl);//自然人投资比例（%）
								jQuery("input[name='wztzbl']").val(lsnsr.jbxx.wztzbl);//外资投资比例（%）
								jQuery("input[name='gytzbl']").val(lsnsr.jbxx.gytzbl);//国有投资比例（%）
								
								//////投资方信息/////////////////////////////////////////////////
								for(var i=0;i<lsnsr.tzfxx.length;i++){	
									var tzfxxObj = {"tds":{
																"tzfhhhrmc":{"value":lsnsr.tzfxx[i].tzfmc},//投资方名称
																"tzbl":{"value":lsnsr.tzfxx[i].tzbl},
																"tzgjjxzDm":{"value":lsnsr.tzfxx[i].tzgjjxzdm},//经济性质
																//"tzgjjxzDm":{"realvalue":lsnsr.tzfxx[i].tzgjjxzdm},
																"tzfhhhrzjzlDm":{"value":lsnsr.tzfxx[i].zjzldm},//证件种类
																//"tzfhhhrzjzlDm":{"realvalue":lsnsr.tzfxx[i].zjzldm},
																"tzfhhhrzjhm":{"value":lsnsr.tzfxx[i].tzzjhm},//证件号码
																"gjhdqszDm":{"value":lsnsr.tzfxx[i].tzfgjdm},//国籍
																//"gjhdqszDm":{"realvalue":lsnsr.tzfxx[i].tzfgjdm},
																"dz":{"value":lsnsr.tzfxx[i].dz}//地址
															}
														};
									$w('tzfxxGrid').insertRow(tzfxxObj);
								}
								
								///////////基本信息五///////////////////////////////////////////////////////////////////
								jQuery("input[name='jdxzDm']").val(lsnsr.jbxx.nsrscjx);//纳税人所处乡街
								jQuery("input[name='jdxzDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.nsrscjxDm);
								jQuery("input[name='dwlsgxDm']").val(lsnsr.jbxx.lsgx);//隶属关系
								jQuery("input[name='dwlsgxDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.lsgxDm);
								jQuery("input[name='gszgswjDm']").val(lsnsr.jbxx.gszgswj);//国税主管税务机关
								jQuery("input[name='gszgswjDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.gszgswjDm);
								jQuery("input[name='gszgswskfjDm']").val(lsnsr.jbxx.gszgswk);//国税主管税务所（科、分局）
								jQuery("input[name='gszgswskfjDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.gszgswkDm);
								jQuery("input[name='dszgswjDm']").val(lsnsr.jbxx.dszgswj);//地税主管税务机关
								jQuery("input[name='dszgswjDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.dszgswjDm);
								jQuery("input[name='dszgswskfjDm']").val(lsnsr.jbxx.dszgsws);//地税主管税务所（科、分局）
								jQuery("input[name='dszgswskfjDm'][type!='hidden']").attr('realvalue',lsnsr.jbxx.dszgswsDm);
								
								///////////代扣代缴、代收代缴//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
								for(var i=0;i<lsnsr.dkdj.length;i++){	
										
									var dkdjObj = {"tds":{
																"dkdjdsdjskywnr":{"value":lsnsr.dkdj[i].dkdjnr},//代扣代缴、代收代缴税款义务内容
																"dkdjdsdjsz":{"value":lsnsr.dkdj[i].dkdjszdm}//代扣代缴、代收代缴税种
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
swdj_lsnsr();