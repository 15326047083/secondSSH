<%@ page import="com.ambow.second.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>左侧导航menu</title>
    <link href="/css/css/css.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/css/js/sdmenu.js"></script>
    <script type="text/javascript">
        // <![CDATA[
        var myMenu;
        window.onload = function () {
            myMenu = new SDMenu("my_menu");
            myMenu.init();
        };
        // ]]>
    </script>
    <style type=text/css>
        html {
            SCROLLBAR-FACE-COLOR: #538ec6;
            SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0;
            SCROLLBAR-SHADOW-COLOR: #2c6daa;
            SCROLLBAR-3DLIGHT-COLOR: #dce5f0;
            SCROLLBAR-ARROW-COLOR: #2c6daa;
            SCROLLBAR-TRACK-COLOR: #dce5f0;
            SCROLLBAR-DARKSHADOW-COLOR: #dce5f0;
            overflow-x: hidden;
        }

        body {
            overflow-x: hidden;
            background: url(/css/images/main/leftbg.jpg) left top repeat-y #f2f0f5;
            width: 194px;
        }
    </style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
    <%
        User user = (User) session.getAttribute("userSession");
    %>
    <div><img src="/css/images/main/member.gif" width="44" height="44"/></div>
    <span>用户：<%=user.getName()%><br>角色：
        <shiro:hasRole name="admin">
            超级管理员&nbsp;
        </shiro:hasRole>
        <shiro:hasRole name="user">
            学员&nbsp;
        </shiro:hasRole>
        <shiro:hasRole name="teacher">
            老师
        </shiro:hasRole>
    </span>
</div>
<div style="float: left" id="my_menu" class="sdmenu">
    <shiro:hasRole name="admin">
        <div class="collapsed">
            <span>党员管理</span>
            <a href="main.jsp" target="mainFrame" onFocus="this.blur()">后台首页</a>
            <a href="/user/queryAll.action" target="mainFrame" onFocus="this.blur()">用户管理</a>
            <a href="/score/getAlladmin.action?index=1" target="mainFrame" onFocus="this.blur()">成绩管理</a>
            <a href="/check/toCheckList.action?index=1" target="mainFrame" onFocus="this.blur()">考勤管理</a>
        </div>
    </shiro:hasRole>

    <shiro:hasRole name="teacher">
        <div class="collapsed">
            <span>党员管理</span>
            <a href="main.jsp" target="mainFrame" onFocus="this.blur()">后台首页</a>
            <a href="/score/getAlladmin.action?index=1" target="mainFrame" onFocus="this.blur()">成绩管理</a>
            <a href="/check/toCheckList.action?index=1" target="mainFrame" onFocus="this.blur()">考勤管理</a>
        </div>
    </shiro:hasRole>

    <shiro:hasRole name="admin">
        <div class="collapsed">
            <span>课程管理</span>
            <a href="/course/queryCourse.action?index=1" target="mainFrame" onFocus="this.blur()">全部课程</a>
            <a href="/course/toNew.action" target="mainFrame" onFocus="this.blur()">新增课程</a>
        </div>
    </shiro:hasRole>
    <shiro:hasRole name="teacher">
        <div class="collapsed">
            <span>课程管理</span>
            <a href="/course/queryTeacherId.action?teacherNum=<%=user.getNum()%>" target="mainFrame"
               onFocus="this.blur()">我的课程</a>
        </div>
    </shiro:hasRole>
    <div class="collapsed">
        <span>个人信息</span>
        <shiro:hasRole name="user">
            <a href="main.jsp" target="mainFrame" onFocus="this.blur()">后台首页</a>
            <a href="/course/queryCourse.action?index=1" target="mainFrame" onFocus="this.blur()">我的课程</a>
            <a href="main_info.html" target="mainFrame" onFocus="this.blur()">我的成绩</a>
            <a href="/check/toListByUserId.action" target="mainFrame" onFocus="this.blur()">我的考勤</a>
        </shiro:hasRole>
        <a href="/user/toUpdate.action?userId=<%=user.getId()%>" target="mainFrame" onFocus="this.blur()">我的信息</a>
    </div>
</div>
</body>
</html>