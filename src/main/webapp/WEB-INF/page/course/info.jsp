<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/8/1
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主要内容区main</title>
    <link href="/css/css/css.css" type="text/css" rel="stylesheet"/>
    <link href="/css/css/main.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/css/images/main/favicon.ico"/>
    <style>
        body {
            overflow-x: hidden;
            background: #f2f0f5;
            padding: 15px 0px 10px 5px;
        }

        #searchmain {
            font-size: 12px;
        }

        #search {
            font-size: 12px;
            background: #548fc9;
            margin: 10px 10px 0 0;
            display: inline;
            width: 100%;
            color: #FFF
        }

        #search form span {
            height: 40px;
            line-height: 40px;
            padding: 0 0px 0 10px;
            float: left;
        }

        #search form input.text-word {
            height: 24px;
            line-height: 24px;
            width: 180px;
            margin: 8px 0 6px 0;
            padding: 0 0px 0 10px;
            float: left;
            border: 1px solid #FFF;
        }

        #search form input.text-but {
            height: 24px;
            line-height: 24px;
            width: 55px;
            background: url(/css/images/main/list_input.jpg) no-repeat left top;
            border: none;
            cursor: pointer;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #666;
            float: left;
            margin: 8px 0 0 6px;
            display: inline;
        }

        #search a.add {
            background: url(/css/images/main/add.jpg) no-repeat 0px 6px;
            padding: 0 10px 0 26px;
            height: 40px;
            line-height: 40px;
            font-size: 14px;
            font-weight: bold;
            color: #FFF
        }

        #search a:hover.add {
            text-decoration: underline;
            color: #d2e9ff;
        }

        #main-tab {
            border: 1px solid #eaeaea;
            background: #FFF;
            font-size: 12px;
        }

        #main-tab th {
            font-size: 12px;
            background: url(/css/images/main/list_bg.jpg) repeat-x;
            height: 32px;
            line-height: 32px;
        }

        #main-tab td {
            font-size: 12px;
            line-height: 40px;
        }

        #main-tab td a {
            font-size: 12px;
            color: #548fc9;
        }

        #main-tab td a:hover {
            color: #565656;
            text-decoration: underline;
        }

        .bordertop {
            border-top: 1px solid #ebebeb
        }

        .borderright {
            border-right: 1px solid #ebebeb
        }

        .borderbottom {
            border-bottom: 1px solid #ebebeb
        }

        .borderleft {
            border-left: 1px solid #ebebeb
        }

        .gray {
            color: #dbdbdb;
        }

        td.fenye {
            padding: 10px 0 0 0;
            text-align: right;
        }

        .bggray {
            background: #f9f9f9;
            font-size: 14px;
            font-weight: bold;
            padding: 10px 10px 10px 0;
            width: 120px;
        }

        .main-for {
            padding: 10px;
        }

        .main-for input.text-word {
            width: 310px;
            height: 36px;
            line-height: 36px;
            border: #ebebeb 1px solid;
            background: #FFF;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            padding: 0 10px;
        }

        .main-for select {
            width: 310px;
            height: 36px;
            line-height: 36px;
            border: #ebebeb 1px solid;
            background: #FFF;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #666;
        }

        .main-for input.text-but {
            width: 100px;
            height: 40px;
            line-height: 30px;
            border: 1px solid #cdcdcd;
            background: #e6e6e6;
            font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
            color: #969696;
            float: left;
            margin: 0 10px 0 0;
            display: inline;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
        }

        #addinfo a {
            font-size: 14px;
            font-weight: bold;
            background: url(/css/images/main/addinfoblack.jpg) no-repeat 0 1px;
            padding: 0px 0 0px 20px;
            line-height: 45px;
        }

        #addinfo a:hover {
            background: url(/css/images/main/addinfoblue.jpg) no-repeat 0 1px;
        }
    </style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：课程管理&nbsp;&nbsp;>&nbsp;&nbsp;课程详情</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">课程名：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#course.name"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">上课时间：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#course.startTime"/>
                    </td>
                </tr>

                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">下课时间：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#course.endTime"/>
                    </td>
                </tr>

                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">课程信息：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#course.info"/>
                    </td>
                </tr>

                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">总课时：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#course.lessons"/>
                    </td>
                </tr>

                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师工号：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.num"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师名称：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.name"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师手机：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.phone"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师邮箱：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.email"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师部门：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.deptId"/>
                    </td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">授课教师职务：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <s:property value="#teacher.duty"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
