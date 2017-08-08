jQuery(function(){

	//alert("jQuery-已经成功加载")
	
	try
	{
		var link_dom=document.createElement("link");
			link_dom.type="text/css";
			link_dom.rel="stylesheet";
			link_dom.href="http://98.12.100.191:10086/hxzgck/js/extjs2/docs/resources/css/ext-all.css";
			document.head.appendChild(link_dom);
		document.close();
		//alert("/extjs2/docs/resources/css/ext-all.css-已经成功加载")
	}
	catch(e){
		alert("加载出错……");
	}
});

	//根据字段判断执行那种填写，例如：寻找文档中的某个关键字段，判断出发票类型。
		var win_div = new Element('div', {
		html: '<div id="hellowin" class="x-hidden"></div>',
		styles: {},
		events: {
			click: function(){
				WinpShowInput();
			}
		}
		});
		$(document.body).grab(win_div);




/**********************************************************************************************/

function WinpClearInput()
{
	var o=$("winp_shenqinghao");
	if(o)
	{
		o.set("value","");
	}
}

function WinpInitTools()
{

   if(!$("winp_shenqinghao"))
   {
		//根据字段判断执行那种填写，例如：寻找文档中的某个关键字段，判断出发票类型。
		 var tabs = new Ext.TabPanel({
            region    : 'center',
            //margins   : '3 3 3 0', 
            activeTab : 0,
            defaults  : {
				autoScroll : true
			},
            items     : [
						{
							title    : '受理单号',
							html     :  '<div id=msg_id></div>受理单号：<input id="winp_shenqinghao" type="text" size=25 value="" />'+
		
		'<input id="zsfp" type="button" onclick="ck();" value="开始填屏" />'
						 }
						]
        });

        // 发票类
        var nav = new Ext.Panel({
            title       : '发票类',
            region      : 'west',
            split       : true,
            width       : 'auto',
            collapsible : true,
           // margins     : '3 0 3 3',
            //cmargins    : '3 3 3 3',
			 items:[tabs]
        }); 
		
	var win= Ext.getCmp('hellowin');;
	   if(!win){
            win = new Ext.Window({
                applyTo     : 'hellowin',
				collapsible : true,
				closable:false,
				title:'网上预申请数据对接窗口-2014.09.01版',
                layout      : 'form',
                width       : 350,
                height      : 200,
				x:50,
				y:100,
                closeAction :'hide',
                plain       : false,
               // items       : [nav, tabs],
				items       : [nav]
				/* ,
                buttons: [{
                    text     : 'Submit',
                    disabled : true
                },{
                    text     : 'Close',
                    handler  : function(){
                        win.hide();
                    }
                }] */
            });
        }
        win.show();
		
		

	}
	
}

function ck()
{

var o=$("winp_shenqinghao");
var slhm=null;
		if(o)
		{
			slhm=o.get("value");
			var slhm_str=slhm.substring(0,3);//截取模块代码
			//alert("slhm>>"+slhm_str);
			switch (slhm_str) {//匹配对应模块
			case "201"://普通发票
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_ptfp.js");
				break;
			case "202"://增值税专用发票
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_zsfp.js");
				break;
			case "203"://货运发票
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_hyfp.js");
				break;
			case "208"://票种核定
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_pzhd.js");
				break;
			case "501"://延期申报
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_yqsb.js");
				break;
			case "801"://单位纳税人
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_dwnsr.js");
				break;
			case "802"://个体经营
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_gtjy.js");
				break;
			case "803"://零时纳税人
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_lsnsr.js");
				break;
			case "112"://税务变更
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_swbg.js");
				break;
			case "114"://财务会计
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_cwkj.js");
				break;
			case "105"://不认定增值税一般纳税人申请
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_zzs.js");
				break;
			case "124"://证件挂失
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_zjgs.js");
				break;
			case "123"://纳税人存款账户帐号报告表
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_nsrck.js");
				break;
			case "118"://小型微利企业认定
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_wlrd.js");
				break;
			case "125"://发票缴销
			
			jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_fpjx.js");
				
				break;
			case "116"://外出经营
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_wcjy.js");
				break;
			case "128"://企业购置税额
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_qygzse.js");
				break;
			case "119"://汇总纳税人
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_hzns.js");
				break;
			case "103"://逾期凭证抵扣
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_pzdk.js");
				break;
			case "106"://增值税一般纳税人
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_ybrrd.js");
				break;
			case "127":// 企业购置专用设备投资抵免企业所得税申请
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_qygzs.js");
				break;
			case "115"://发票挂失损毁
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_fpgssh.js");
				break;
			case "120"://简易征收办法认定
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_jyrd.js");
				break;
			case "150"://纳税人合并分立情况报告
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_nsrhbflqk.js");
				break;
			case "250"://扣缴税款登记
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_kjywrdj.js");
					break;
					case "141"://停业登记
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_tyfybgs.js");
					break;
					case "142"://注销税务登记
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_zxswdjsqsp.js");
					break;
					case "181"://证件增补发
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_zjzbf.js");
					break;
					case "182"://印有本单位发票备案
				jQuery.getScript("http://98.12.100.191:10086/ws/js/jsonp_js/jsonp_load_yybdwfpba.js");
					break;

			default://未匹配到相应模块
				
				break;
			}			
		}
}

/**************************************************************************************************************************/
setTimeout("WinpInitTools()",700);