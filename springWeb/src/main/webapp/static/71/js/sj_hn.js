/*//定义一个数组变量存放几个数据，一个定时器，一个标识变量
var data=['ipad mini','iphone 6','iphone 6s玫瑰金','kindle','ipad air','超极本'],
	timer_hn=null
	flag=0;*/

var timer_hn=null;
var flag_hn=0;

/************************************************************************************************************************************/
//函数开始-第1行-3列表格
$(function()
{
    $("#hn_count").html(data_hn);
    $("#begin").click(function () {       fnplay_hn_1();    });
    $("#stop").click(function () {        fnstop_hn_1();    });

    var random_hn_index1 ; //征管人员数组-下标
    var random_hn_index2 ;


    var data_hn_name1,//征管人员名称
        data_hn_name2;

	//键盘事件 针对的是整个document

/**************************************************************************************************************************************************8*/


	function fnplay_hn_1()
    {
	//var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
	//每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃  
		clearInterval(timer_hn);
		//定义一个定时器
		timer_hn=setInterval(function()
        {
			//Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_hn_index1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
                            data_hn_name1=data_hn[random_hn_index1];                // 根据下标取出字符




			$("#hnry_span_1").html(data_hn_name1);//设置随机出来的名字

		},40);
		//按开始之后，让颜色改变一下
		begin.style.background="#999";
	}

	function fnstop_hn_1()
    {
		clearInterval(timer_hn);

        random_hn_index1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
                        data_hn_name1=data_hn[random_hn_index1];                // 根据下标取出字符
                        data_hn.remove(data_hn_name1);                          //删除数组里对应的字符,更新数组内容及长度


        $("#hnry_span_1").html(data_hn_name1);//设置随机出来的名字
		 $("#hn_count").html(data_hn);                         //设置显示当前征管部门的人数

		//恢复为原来的颜色
		begin.style.background="#708098";
	}

});

/************************************************************************************************************************************/
//函数开始-第2行表格
$(function()
{
    //alert("$(function()2");
    $("#begin2").click(function () {       fnplay2();    });
    $("#stop2").click(function () {        fnstop2();    });

    var random_hn_index2_1 ; //征管人员数组-下标
    var random_hn_index2_2 ;


    var data_hn_name2_1,//征管人员名称
        data_hn_name2_2;

    //键盘事件 针对的是整个document

    /**************************************************************************************************************************************************8*/


    function fnplay2()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer_hn);
        //定义一个定时器
        timer_hn=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_hn_index2_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
            data_hn_name2_1=data_hn[random_hn_index2_1];                // 根据下标取出字符


            $("#hnry_span_2").html(data_hn_name2_1);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin2.style.background="#999";
    }

    function fnstop2()
    {
        clearInterval(timer_hn);

        random_hn_index2_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
        data_hn_name2_1=data_hn[random_hn_index2_1];                // 根据下标取出字符
        data_hn.remove(data_hn_name2_1);                          //删除数组里对应的字符,更新数组内容及长度



        $("#hnry_span_2").html(data_hn_name2_1);//设置随机出来的名字

        $("#hn_count").html(data_hn);                         //设置显示当前征管部门的人数-这个ID不变

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

    var random_hn_index3_1 ; //征管人员数组-下标
    var random_hn_index3_2 ;


    var data_hn_name3_1,//征管人员名称
        data_hn_name3_2;

    //键盘事件 针对的是整个document
    /**************************************************************************************************************************************************8*/


    function fnplay3()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer_hn);
        //定义一个定时器
        timer_hn=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_hn_index3_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
            data_hn_name3_1=data_hn[random_hn_index3_1];                // 根据下标取出字符


            $("#hnry_span_3").html(data_hn_name3_1);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin3.style.background="#999";
    }

    function fnstop3()
    {
        clearInterval(timer_hn);

        random_hn_index3_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
        data_hn_name3_1=data_hn[random_hn_index3_1];                // 根据下标取出字符
        data_hn.remove(data_hn_name3_1);                          //删除数组里对应的字符,更新数组内容及长度

        $("#hnry_span_3").html(data_hn_name3_1);//设置随机出来的名字

        $("#hn_count").html(data_hn);                         //设置显示当前征管部门的人数-这个ID不变

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

    var random_hn_index4_1 ; //征管人员数组-下标
    var random_hn_index4_2 ;


    var data_hn_name4_1,//征管人员名称
        data_hn_name4_2;

    //键盘事件 针对的是整个document
    /**************************************************************************************************************************************************8*/


    function fnplay4()
    {
        //var that=this;//这里指的是begin这个按钮 这里暂时不考虑这个。
        //每个开始之前关闭一下定时器，不然每次按click的时候容易加快速度，以至于整个浏览器容易奔溃
        clearInterval(timer_hn);
        //定义一个定时器
        timer_hn=setInterval(function()
        {
            //Math.random()拿到的是0-1之前的数字，去乘数组的长度 再取整数可以拿到想要的数组下标
            random_hn_index4_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
            data_hn_name4_1=data_hn[random_hn_index4_1];                // 根据下标取出字符



            $("#hnry_span_4").html(data_hn_name4_1);//设置随机出来的名字

        },50);
        //按开始之后，让颜色改变一下
        begin4.style.background="#999";
    }

    function fnstop4()
    {
        clearInterval(timer_hn);

        random_hn_index4_1 =Math.floor(Math.random()*data_hn.length); // 1 取当前数组长度，产生随机下标
        data_hn_name4_1=data_hn[random_hn_index4_1];                // 根据下标取出字符
        data_hn.remove(data_hn_name4_1);                          //删除数组里对应的字符,更新数组内容及长度


        $("#hnry_span_4").html(data_hn_name4_1);//设置随机出来的名字
        $("#hnry_span_5").html(data_hn[0]);//设置随机出来的名字
        $("#hn_count").html(data_hn);                         //设置显示当前征管部门的人数-这个ID不变

        //恢复为原来的颜色
        begin4.style.background="#708098";
    }
});
