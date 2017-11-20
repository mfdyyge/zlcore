/*//定义一个数组变量存放几个数据，一个定时器，一个标识变量
var data=['ipad mini','iphone 6','iphone 6s玫瑰金','kindle','ipad air','超极本'],
	timer=null
	flag=0;*/



//函数开始
$(function()
{
    $("#zg_count").html(data_zg);
    $("#begin").click(function () {       fnplay();    });
    $("#stop").click(function () {        fnstop();    });

    var random_zg_index1 ; //征管人员数组-下标
    var random_zg_index2 ;
    var random_zg_index3;

    var data_zg_name1,//征管人员名称
        data_zg_name2,
        data_zg_name3;
	//键盘事件 针对的是整个document
	document.onkeyup=fnkey;
/**************************************************************************************************************************************************8*/


	function fnplay()
    {
	//var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
	//每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃  
		clearInterval(timer);
		//定义一个定时器
		timer=setInterval(function()
        {
			//Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_zg_index1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
                            data_zg_name1=data_zg[random_zg_index1];                // 根据下标取出字符


            random_zg_index2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
                            data_zg_name2=data_zg[random_zg_index2];                // 根据下标取出字符


            random_zg_index3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
                            data_zg_name3=data_zg[random_zg_index3];                // 根据下标取出字符


			$("#zgry_span_1").html(data_zg_name1+data_zg_name2+data_zg_name3);//设置随机出来的名字

		},50);
		//按开始之后，让颜色改变一下
		begin.style.background="#999";
	}

	function fnstop()
    {
		clearInterval(timer);

        random_zg_index1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
                        data_zg_name1=data_zg[random_zg_index1];                // 根据下标取出字符
                        data_zg.remove(data_zg_name1);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
                        data_zg_name2=data_zg[random_zg_index2];                // 根据下标取出字符
                        data_zg.remove(data_zg_name2);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
                        data_zg_name3=data_zg[random_zg_index3];                // 根据下标取出字符
                        data_zg.remove(data_zg_name3);                          //删除数组里对应的字符,更新数组内容及长度
        $("#zgry_span_1").html(data_zg_name1+"|"+data_zg_name2+"|"+data_zg_name3);//设置随机出来的名字
		 $("#zg_count").html(data_zg);                         //设置显示当前征管部门的人数

		//恢复为原来的颜色
		begin.style.background="#708098";
	}

	function fnkey(event)
    {
		console.log(event.keyCode);
		event=event ||window.event;
		if(event.keyCode == 13){  //当按下回车键的时候
			//一开始是0的状态，我们改变。
			if(flag == 0){
				fnplay();
				//设置为1的状态，停止改变
				flag =1;
			}else{
				fnstop();
				flag=0;
			}
		}
	}
});

/************************************************************************************************************************************/
//函数开始-第2行表格
$(function()
{
    //alert("$(function()2");
    $("#begin2").click(function () {       fnplay2();    });
    $("#stop2").click(function () {        fnstop2();    });

    var random_zg_index2_1 ; //征管人员数组-下标
    var random_zg_index2_2 ;
    var random_zg_index2_3;

    var data_zg_name2_1,//征管人员名称
        data_zg_name2_2,
        data_zg_name2_3;
    //键盘事件 针对的是整个document

    /**************************************************************************************************************************************************8*/


    function fnplay2()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer);
        //定义一个定时器
        timer=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_zg_index2_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
            data_zg_name2_1=data_zg[random_zg_index2_1];                // 根据下标取出字符


            random_zg_index2_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
            data_zg_name2_2=data_zg[random_zg_index2_2];                // 根据下标取出字符


            random_zg_index2_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
            data_zg_name2_3=data_zg[random_zg_index2_3];                // 根据下标取出字符


            $("#zgry_span_2").html(data_zg_name2_1+data_zg_name2_2+data_zg_name2_3);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin2.style.background="#999";
    }

    function fnstop2()
    {
        clearInterval(timer);

        random_zg_index2_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
        data_zg_name2_1=data_zg[random_zg_index2_1];                // 根据下标取出字符
        data_zg.remove(data_zg_name2_1);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index2_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
        data_zg_name2_2=data_zg[random_zg_index2_2];                // 根据下标取出字符
        data_zg.remove(data_zg_name2_2);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index2_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
        data_zg_name2_3=data_zg[random_zg_index2_3];                // 根据下标取出字符
        data_zg.remove(data_zg_name2_3);                          //删除数组里对应的字符,更新数组内容及长度

        $("#zgry_span_2").html(data_zg_name2_1+"|"+data_zg_name2_2+"|"+data_zg_name2_3);//设置随机出来的名字

        $("#zg_count").html(data_zg);                         //设置显示当前征管部门的人数-这个ID不变

        //恢复为原来的颜色
        begin2.style.background="#708098";
    }
});


/************************************************************************************************************************************/
//函数开始-第3行表格
$(function()
{
    //alert("$(function()2");
    $("#begin3").click(function () {       fnplay3();    });
    $("#stop3").click(function () {        fnstop3();    });

    var random_zg_index3_1 ; //征管人员数组-下标
    var random_zg_index3_2 ;
    var random_zg_index3_3;

    var data_zg_name3_1,//征管人员名称
        data_zg_name3_2,
        data_zg_name3_3;
    //键盘事件 针对的是整个document
    /**************************************************************************************************************************************************8*/


    function fnplay3()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer);
        //定义一个定时器
        timer=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_zg_index3_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
            data_zg_name3_1=data_zg[random_zg_index3_1];                // 根据下标取出字符


            random_zg_index3_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
            data_zg_name3_2=data_zg[random_zg_index3_2];                // 根据下标取出字符


            random_zg_index3_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
            data_zg_name3_3=data_zg[random_zg_index3_3];                // 根据下标取出字符


            $("#zgry_span_3").html(data_zg_name3_1+data_zg_name3_2+data_zg_name3_3);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin3.style.background="#999";
    }

    function fnstop3()
    {
        clearInterval(timer);

        random_zg_index3_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
        data_zg_name3_1=data_zg[random_zg_index3_1];                // 根据下标取出字符
        data_zg.remove(data_zg_name3_1);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index3_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
        data_zg_name3_2=data_zg[random_zg_index3_2];                // 根据下标取出字符
        data_zg.remove(data_zg_name3_2);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index3_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
        data_zg_name3_3=data_zg[random_zg_index3_3];                // 根据下标取出字符
        data_zg.remove(data_zg_name3_3);                          //删除数组里对应的字符,更新数组内容及长度

        $("#zgry_span_3").html(data_zg_name3_1+"|"+data_zg_name3_2+"|"+data_zg_name3_3);//设置随机出来的名字

        $("#zg_count").html(data_zg);                         //设置显示当前征管部门的人数-这个ID不变

        //恢复为原来的颜色
        begin3.style.background="#708098";
    }
});



/************************************************************************************************************************************/
//函数开始-第4行表格
$(function()
{

    $("#begin4").click(function () {       fnplay4();    });
    $("#stop4").click(function () {        fnstop4();    });

    var random_zg_index4_1 ; //征管人员数组-下标
    var random_zg_index4_2 ;
    var random_zg_index4_3;

    var data_zg_name4_1,//征管人员名称
        data_zg_name4_2,
        data_zg_name4_3;
    //键盘事件 针对的是整个document
    /**************************************************************************************************************************************************8*/


    function fnplay4()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer);
        //定义一个定时器
        timer=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_zg_index4_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
            data_zg_name4_1=data_zg[random_zg_index4_1];                // 根据下标取出字符


            random_zg_index4_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
            data_zg_name4_2=data_zg[random_zg_index4_2];                // 根据下标取出字符


            random_zg_index4_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
            data_zg_name4_3=data_zg[random_zg_index4_3];                // 根据下标取出字符


            $("#zgry_span_4").html(data_zg_name4_1+data_zg_name4_2+data_zg_name4_3);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin4.style.background="#999";
    }

    function fnstop4()
    {
        clearInterval(timer);

        random_zg_index4_1 =Math.floor(Math.random()*data_zg.length); // 1 取当前数组长度，产生随机下标
        data_zg_name4_1=data_zg[random_zg_index4_1];                // 根据下标取出字符
        data_zg.remove(data_zg_name4_1);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index4_2 =Math.floor(Math.random()*data_zg.length); // 2 取当前数组长度，产生随机下标
        data_zg_name4_2=data_zg[random_zg_index4_2];                // 根据下标取出字符
        data_zg.remove(data_zg_name4_2);                          //删除数组里对应的字符,更新数组内容及长度

        random_zg_index4_3 =Math.floor(Math.random()*data_zg.length); // 3 取当前数组长度，产生随机下标
        data_zg_name4_3=data_zg[random_zg_index4_3];                // 根据下标取出字符
        data_zg.remove(data_zg_name4_3);                          //删除数组里对应的字符,更新数组内容及长度

        $("#zgry_span_4").html(data_zg_name4_1+"|"+data_zg_name4_2+"|"+data_zg_name4_3);//设置随机出来的名字
        $("#zgry_span_5").html(data_zg[0]+"|"+data_zg[1]+"|"+data_zg[2]);//设置随机出来的名字
        $("#zg_count").html(data_zg);                         //设置显示当前征管部门的人数-这个ID不变

        //恢复为原来的颜色
        begin4.style.background="#708098";
    }
});
