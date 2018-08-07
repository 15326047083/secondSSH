<%--
  Created by IntelliJ IDEA.
  User: guowei
  Date: 2018/8/6
  Time: 上午20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户管理</title>
    <link href="/css/css/css.css" type="text/css" rel="stylesheet"/>
    <link href="/css/css/main.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/css/cimages/main/favicon.ico"/>
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
        <td width="99%" align="left" valign="top">您的位置：考勤管理</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                        <div style="float: left; width: 200px;">
                            <s:form action="doUpload.action" method="post" enctype="multipart/form-data">
                                <s:file name="upload" class="text-word" onchange="submit()"/>
                            </s:form>
                        </div>
                        <a href="download.action" target="mainFrame" onFocus="this.blur()" class="add">导出</a>
                        <div style="margin-left: 200px;">
                            <form method="post" action="<%=request.getContextPath()%>likeSelect.action">
                                <span>模糊查询：</span>
                                <input type="text" name="selectKey" value="" class="text-word">
                                <input name="" type="submit" value="查询" class="text-but">
                            </form>
                        </div>
                    </td>
                    <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;">
                        <a href="/user/toAddUser.action" target="mainFrame" onFocus="this.blur()" class="add">新增用户</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">姓名</th>
                    <th align="center" valign="middle" class="borderright">工号</th>
                    <th align="center" valign="middle" class="borderright">手机号</th>
                    <th align="center" valign="middle" class="borderright">邮箱</th>
                    <th align="center" valign="middle" class="borderright">性别</th>
                    <th align="center" valign="middle" class="borderright">学历</th>
                    <th align="center" valign="middle" class="borderright">注册时间</th>
                    <th align="center" valign="middle" class="borderright">部门ID</th>
                    <th align="center" valign="middle" class="borderright">职务</th>
                    <th align="center" valign="middle" class="borderright">用户类型</th>
                    <th align="center" valign="middle" class="borderright">用户状态</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <s:iterator var="selectList" value="likeSelectList" status="likeSelectList">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                        onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.name"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.num"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.phone"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.email"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.sex"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.edu"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.joinTime"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.deptId"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.duty"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#selectList.userType"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom">
                            <s:if test="#selectList.alive==0">在校</s:if>
                            <s:if test="#selectList.alive==1">离校</s:if>
                        </td>
                        <td align="center" valign="middle" class="borderbottom">
                            <a href="/user/toUpdate.action?userId=<s:property value="#selectList.id"/>"
                               target="mainFrame" onFocus="this.blur()" class="add">编辑</a>
                            <span class="gray">&nbsp;|&nbsp;</span>
                            <a href="/user/updateAlive.action?userId=<s:property value="#selectList.id"/>"
                               target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
                    </tr>
                </s:iterator>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="fenye"><s:property value="#index"/>/<s:property value="#allPage"/>页


            <a href="<%=request.getContextPath()%>likeSelect.action?index=1&selectKey=<s:property value="#selectKey"/>" target="mainFrame"
               onFocus="this.blur()">首页</a>&nbsp;&nbsp;

            <s:if test="#index==1">
                <a id="last" style="cursor: default;"
                   href="javascript:return false;" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
            </s:if>
            <s:if test="#index>1">
                <a href="likeSelect.action?index=<s:property value="index-1"/>&selectKey=<s:property value="#selectKey"/>">上一页</a>
            </s:if>
            <s:if test="#allPage<=#index">
                <a id="last"
                   href="javascript:return false;" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
            </s:if>
            <s:if test="#allPage>#index">
                <a href="likeSelect.action?index=<s:property value="index+1"/>&selectKey=<s:property value="#selectKey"/>">下一页</a>
            </s:if>

            <a href="<%=request.getContextPath()%>likeSelect.action?index=<s:property value="#allPage"/>&selectKey=<s:property value="#selectKey"/>"
               target="mainFrame" onFocus="this.blur()">尾页</a>

        </td>
    </tr>
</table>

</body>
</html>