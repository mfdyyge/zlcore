<%--
  Created by IntelliJ IDEA.
  User: 小觜冰凉
  Date: 2017-2-6 0006
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    if (path.equals("/")) {
        path = "";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script type="text/javascript" src="<%=basePath%>static/js/jquery/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/71/css/main.css">

    <style type="text/css">
        .className {
            margin: 0 auto;
            width: 1000px;
            height: 200px;
        }

        td {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        //1.首先可以给js的数组对象定义一个函数，用于查找指定的元素在数组中的位置，即索引，代码为：
        Array.prototype.indexOf = function (val) {
            for (var i = 0; i < this.length; i++) {
                if (this[i] == val) return i;
            }
            return -1;
        };
        //2.然后使用通过得到这个元素的索引，使用js数组自己固有的函数去删除这个元素：代码为：

        Array.prototype.remove = function (val) {
            var index = this.indexOf(val);
            if (index > -1) {
                this.splice(index, 1);
            }
        };
    </script>

    <script type="text/javascript">
        //定义一个数组变量存放几个数据，一个定时器，一个标识变量
        var data_zg = ['任华', '刘文平', '张思雅', '张义勇', '陈安源', '刘晓平', '蒋华', '刘道明', '李平', '向芹', '谭奇莉', '罗琼', '刘如星', '罗鸿', '周朝斌'], timer = null, flag = 0;
        var data_hn = ['梅小川', '康泽', '徐巧巧', '刘旭', '李沛思'];
        var data_sds = ['谢忠毅', '刁星月', '冉旭彤', '刘群', '李梓松', '向胜兰', '郑爻莹', '霍杰', '李晶晶', '江军'];
    </script>

    <script type="text/javascript" src="<%=basePath%>static/71/js/getlucky.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/71/js/sj_sds.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/71/js/sj_hn.js"></script>
</head>


<body style="background-color:#2883f3;">
<div class="className">
    <table id="tb1" width="1000px" border="1" cellpadding="4" cellspacing="0">
        <tr>
            <td height="40" colspan="5"><img height="150" width="500" src="static/img/sw/zgsw2.png"></td>
        </tr>
        <%--****************************************************--%>
        <tr>
            <td width="50px"> 按钮</td>
            <td width="100px" class=""> 检查组：</td>
            <td width="200px"> 征管人员</td>
            <td width="100"> 货劳人员</td>
            <td width="100"> 所得税人员</td>
        </tr>
        <%--****************************************************--%>
        <tr>
            <td width="50px">
                <div class="bs">
                    <span class="begin" id="begin">开  始</span>
                    <span class="stop" id="stop">停  止</span>
                </div>
            </td>
            <td width="100px" class=""> 检查1组：</td>
            <td width="200px"><span class="title" id="zgry_span_1">暂无组队信息</span></td>
            <td width="100"><span class="title" id="hnry_span_1">暂无组队信息</span></td>
            <td width="150"><span class="title" id="sdsry_span_1">暂无组队信息</span></td>
        </tr>

        <%--****************************************************--%>
        <tr>
            <td width="100px">
                <div class="bs">
                    <span class="begin" id="begin2">开  始</span>
                    <span class="stop" id="stop2">停  止</span>
                </div>
            </td>
            <td width="100px" class="">
                检查2组：
            </td>
            <td width="200px"><span class="title" id="zgry_span_2">暂无组队信息</span></td>

            <td width="100"><span class="title" id="hnry_span_2">暂无组队信息</span></td>
            <td width="100"><span class="title" id="sdsry_span_2">暂无组队信息</span></td>
        </tr>
        <%--****************************************************--%>
        <tr>
            <td width="100px">
                <div class="bs">
                    <span class="begin" id="begin3">开  始</span>
                    <span class="stop" id="stop3">停  止</span>
                </div>
            </td>
            <td width="100px" class="">
                检查3组：
            </td>
            <td width="200px"><span class="title" id="zgry_span_3">暂无组队信息</span></td>

            <td width="100"><span class="title" id="hnry_span_3">暂无组队信息</span></td>
            <td width="100"><span class="title" id="sdsry_span_3">暂无组队信息</span></td>
        </tr>
        <%--****************************************************--%>
        <tr>
            <td width="100px">
                <div class="bs">
                    <span class="begin" id="begin4">开  始</span>
                    <span class="stop" id="stop4">停  止</span>
                </div>
            </td>
            <td width="100px" class="">
                检查4组：
            </td>
            <td width="200px"><span class="title" id="zgry_span_4">暂无组队信息</span></td>

            <td width="100"><span class="title" id="hnry_span_4">暂无组队信息</span></td>
            <td width="100"><span class="title" id="sdsry_span_4">暂无组队信息</span></td>
        </tr>
        <%--****************************************************--%>
        <tr>
            <td width="100px"></td>
            <td width="100px" class="">
                检查5组：
            </td>
            <td width="200px"><span class="title" id="zgry_span_5">暂无组队信息</span></td>

            <td width="100"><span class="title" id="hnry_span_5">暂无组队信息</span></td>
            <td width="100"><span class="title" id="sdsry_span_5">暂无组队信息</span></td>
        </tr>
        <tr>
            <td width="100px"></td>
            <td width="100px"></td>
            <td width="200px"> 征管人员:<span id="zg_count"></span></td>
            <td width="100"> 货劳人员:<span id="hn_count"></span></td>
            <td width="100"> 所得税人员:<span id="sds_count"></span></td>
        </tr>
    </table>
</div>

</body>
</html>