<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2 0002
  Time: 下午 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录界面</title>
    <link href="/css/css/alogin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form id="form1" runat="server" action="/login/login.action" method="post">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB">
                <br/>
                <br/>
                <br/>
                <span><h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Second  Team</h1></span>
            </li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                        <li><span class="left login-text">用户名：</span> <span>
                        <input id="Text1" type="text" class="txt" name="user.num" required="required"/>

                    </span></li>
                        <li><span class="left login-text">密码：</span> <span>
                       <input id="Text2" type="password" class="txt" name="user.password" required="required"/>
                    </span></li>
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C"><span class="btn"><button type="submit"><input name="" type="image"
                                                          src="/css/images/login/btnlogin.gif"/></button></span></li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
        </ul>
    </div>
</form>
</body>
</html>