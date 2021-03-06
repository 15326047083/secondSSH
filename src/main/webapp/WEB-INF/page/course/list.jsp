<%@ page import="com.ambow.second.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/8/1
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>全部课程信息</title>
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
            color: #FFF;
            float: left
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
            background: url(/css/images/main/add.jpg) no-repeat -3px 7px #548fc9;
            padding: 0 10px 0 26px;
            height: 40px;
            line-height: 40px;
            font-size: 14px;
            font-weight: bold;
            color: #FFF;
            float: right
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
            background: #f9f9f9
        }
    </style>
</head>
<body>

<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：课程管理</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                    </td>
                    <shiro:hasRole name="admin">
                        <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a
                                href="/course/toNew.action" target="mainFrame" onFocus="this.blur()"
                                class="add">新增课程</a>
                        </td>
                    </shiro:hasRole>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">课程名</th>
                    <th align="center" valign="middle" class="borderright">上课时间</th>
                    <th align="center" valign="middle" class="borderright">下课时间</th>
                    <th align="center" valign="middle" class="borderright">课程信息</th>
                    <th align="center" valign="middle" class="borderright">总课时</th>
                    <th align="center" valign="middle" class="borderright">课程状态</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <s:iterator value="courseList" var="cl">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                        onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#cl.name"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#cl.startTime"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#cl.endTime"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#cl.info"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#cl.lessons"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom">
                            <s:if test="#cl.alive==0">授课中 </s:if>
                            <s:elseif test="#cl.alive==1">已结课</s:elseif>
                        </td>
                        <td align="center" valign="middle" class="borderbottom">
                            <a href="/course/getInfoByCourseIdAndTeacherId.action?courseId=<s:property value="#cl.id"/>&teacherId=<s:property value="#cl.teacherId"/>"
                               target="mainFrame" onFocus="this.blur()" class="add">查看详情</a><span class="gray">&nbsp;|&nbsp;</span>
                            <shiro:lacksRole name="user">
                                <a href="/course/updateCourse.action?courseId=<s:property value="#cl.id"/>"
                                   target="mainFrame" onFocus="this.blur()" class="add">点击结课</a><span class="gray">&nbsp;|&nbsp;</span>
                                <shiro:hasRole name="admin">
                                    <a href="/course/deleteCourse.action?courseId=<s:property value="#cl.id"/>"
                                       target="mainFrame" onFocus="this.blur()" class="add">删除</a>
                                </shiro:hasRole>
                            </shiro:lacksRole>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </td>
    </tr>
    <tr>
        <shiro:lacksRole name="teacher">
            <td align="left" valign="top" class="fenye"><s:property value="#index"/>/<s:property value="#allPage"/>页&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>queryCourse.action?index=1" target="mainFrame"
                   onFocus="this.blur()">首页</a>&nbsp;&nbsp;

                <s:if test="#index==1">
                    <a id="prior" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#index>1">
                    <a id="prior"
                       href="<%=request.getContextPath()%>queryCourse.action?index=<s:property value="#index-1"/>"
                       target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage>#index">
                    <a id="last"
                       href="<%=request.getContextPath()%>queryCourse.action?index=<s:property value="#index+1"/>"
                       target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage<=#index">
                    <a id="last" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>

                <a
                        href="<%=request.getContextPath()%>queryCourse.action?index=<s:property value="#allPage"/>"
                        target="mainFrame" onFocus="this.blur()">尾页</a></td>
        </shiro:lacksRole>
    </tr>

</table>

</body>
</html>
