//延期申报
function yqsb()
{
	var yqsb_data;
	
	try{
				//var o=$("winp_shenqinghao");//Mootools 查找Dom|| 设置属性
				//var slhm=o.get("value");
				 var slhm = jQuery("#winp_shenqinghao").val();
						
				var url_yqsb='http://98.12.100.191:10086/ws/queryYqsbtoJson.action?yqsbjbxx.slhm='+slhm;
					
					jQuery(function(){
						//jQuery("#msg_id").html("加载插件完毕");
						//alert("jQuery(function()!!!!!!!!!!!!!!!!!");
						jQuery.ajax(
						{
							url:url_yqsb,
							dataType:"jsonp",
							jsonp:"callback",
							jsonpCallback:"callback_function",
							success:function(jsonObj){
								yqsb_data=jsonObj;
								
								for(var i=0;i<yqsb_data.sqxx.length;i++)
									{
											var yqsbdataObj = {"tds":{
																	"sqyqsbsz":{"value":yqsb_data.sqxx[i].yqsbszDm/*obj.hwmc_1*/},
																	"yqsqsbpm":{"value":yqsb_data.sqxx[i].yqsbpmDm},
																	"skssqq":{"value":yqsb_data.sqxx[i].skssqq},
																	"skssqz":{"value":yqsb_data.sqxx[i].skssqz},
																	"sbqx":{"value":yqsb_data.sqxx[i].sbqx},
																	"sqyqsbqx":{"value":yqsb_data.sqxx[i].yqsbqx}
																}
															};
											
											$w('sqxxGrid').insertRow(yqsbdataObj);
									}
						jQuery("textarea[name='sqyqsbdly']").val(yqsb_data.jbxx.yqsbly);
						jQuery("input[name='sqr']").val(yqsb_data.jbxx.jbr);
							}
						});
					});
		
		
		
	}catch(e){
		alert("extends\n"+e);
	}
}
yqsb();