//变更登记
function swbg()
{
	try{
			 var slhm = jQuery("#winp_shenqinghao").val();
					
					var url_jyrd='http://98.12.100.191:10086/ws/Queryjyrd_tp.action?jyrd.sldh='+slhm;
				
				jQuery(function(){
					jQuery.ajax(
					{
						url:url_jyrd,
						dataType:"jsonp",
						jsonp:"callback",
						jsonpCallback:"callback_function",
						success:function(jsonObj)
						{
							//alert("success---------------");
																		//纳税人识别号 nsrsbh
																		var nsrsbh=$$("input[name='nsrsbh']");nsrsbh.set('value',jsonObj.jyrd.nsrsbh);
																		
																		//纳税人名称nsrmc
																		var nsrmc=$$("input[name='nsrmc']");nsrmc.set('value',jsonObj.jyrd.nsrmc);
																		
																		//有效期起yxqq
																		var yxqq=$$("input[name='yxqq']");yxqq.set('value',jsonObj.jyrd.ssqq);
																		
																		//有效期止yxqz
																		var yxqz=$$("input[name='yxqz']");yxqz.set('value',jsonObj.jyrd.ssqz);
																		
																		//申请日期lrrq
																		var lrrq=$$("input[name='lrrq']");lrrq.set('value',jsonObj.jyrd.sqrq);
																		
																		var lxStr = "";
																		var vlStr = "";
																		var index = 0;
																		
																		if(jsonObj.jyrd.zzshwlxDm1!=null&&jsonObj.jyrd.zzshwlxDm1!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm1;
																			vlStr = vlStr+"一般纳税人销售自己使用过的属于条例第十条规定不得抵扣且未抵扣进项税额的固定资产，按简易办法依4%征收率减半征收增值税";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm2!=null&&jsonObj.jyrd.zzshwlxDm2!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm2;
																			vlStr = vlStr+"一般纳税人纳税人销售旧货按4%征收率减半征收增值税";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm3!=null&&jsonObj.jyrd.zzshwlxDm3!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm3;
																			vlStr = vlStr+"县级及县级以下小型水力发电单位生产的电力";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm4!=null&&jsonObj.jyrd.zzshwlxDm4!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm4;
																			vlStr = vlStr+"建筑用和生产建筑材料所用的砂、土、石料";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm5!=null&&jsonObj.jyrd.zzshwlxDm5!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm5;
																			vlStr = vlStr+"以自己采掘的砂、土、石料或其他矿物连续生产的砖、瓦、石灰";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm6!=null&&jsonObj.jyrd.zzshwlxDm6!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm6;
																			vlStr = vlStr+"用微生物、微生物代谢产物、动物毒素、人或动物的血液或组织制成的生物制品";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm7!=null&&jsonObj.jyrd.zzshwlxDm7!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm7;
																			vlStr = vlStr+"自来水";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm8!=null&&jsonObj.jyrd.zzshwlxDm8!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm8;
																			vlStr = vlStr+"商品混凝土";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm9!=null&&jsonObj.jyrd.zzshwlxDm9!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm9;
																			vlStr = vlStr+"寄售商店代销寄售物品";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm10!=null&&jsonObj.jyrd.zzshwlxDm10!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm10;
																			vlStr = vlStr+"典当业销售死当物品";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm11!=null&&jsonObj.jyrd.zzshwlxDm11!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm11;
																			vlStr = vlStr+"中外合作油（气）田开采的原油、天然气按实物征收增值税，征收率为5％";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm12!=null&&jsonObj.jyrd.zzshwlxDm12!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm12;
																			vlStr = vlStr+"对拍卖行受托拍卖增值税应税货物，按照4%的征收率征收增值税";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm13!=null&&jsonObj.jyrd.zzshwlxDm13!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm13;
																			vlStr = vlStr+"属于增值税一般纳税人的单采血浆站销售非临床用人体血液，可以按照简易办法依照6%征收率计算应纳税额";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm14!=null&&jsonObj.jyrd.zzshwlxDm14!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm14;
																			vlStr = vlStr+"被认定为动漫企业的试点纳税人中的一般纳税人，为开发动漫产品提供的动漫脚本编撰、形象设计、背景设计等服务，以及在境内转让动漫版权";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm15!=null&&jsonObj.jyrd.zzshwlxDm15!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm15;
																			vlStr = vlStr+"试点纳税人中的一般纳税人，以试点实施之日前购进或者自制的有形动产为标的物提供的经营租赁服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm16!=null&&jsonObj.jyrd.zzshwlxDm16!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm16;
																			vlStr = vlStr+"试点纳税人中的一般纳税人提供的公共交通运输服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm17!=null&&jsonObj.jyrd.zzshwlxDm17!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm17;
																			vlStr = vlStr+"电影放映服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm18!=null&&jsonObj.jyrd.zzshwlxDm18!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm18;
																			vlStr = vlStr+"仓储服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm19!=null&&jsonObj.jyrd.zzshwlxDm19!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm19;
																			vlStr = vlStr+"装卸搬运服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm20!=null&&jsonObj.jyrd.zzshwlxDm20!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm20;
																			vlStr = vlStr+"收派服务";
																			index++;
																		}
																		
																		if(jsonObj.jyrd.zzshwlxDm21!=null&&jsonObj.jyrd.zzshwlxDm21!=""){
																			if(index!=0){
																				lxStr = lxStr+",";
																				vlStr = vlStr+",";
																			}
																			lxStr = lxStr+jsonObj.jyrd.zzshwlxDm21;
																			vlStr = vlStr+"属于增值税一般纳税人的药品经营企业销售生物制品，可以选择简易办法按照生物制品销售额和3％的征收率计算缴纳增值税";
																			index++;
																		}
																		
																		//选择简易办法征收增值税类型xshwlxDm
																		var xshwlxDm=$$("input[name='xshwlxDm']");xshwlxDm.set('value',vlStr);
																		var xshwlxDm=$$("input[name='xshwlxDm']");xshwlxDm.set('realvalue',lxStr);
						}
					
					});
			
			});
				
	
	}catch(e)
	{
		alert("extends\n"+e)
	}



 				
}				
swbg();		