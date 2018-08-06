<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>后台页面头部</title>
    <link href="/css/css/css.css" type="text/css" rel="stylesheet"/>
</head>
<body onselectstart="return false" oncontextmenu=return(false) style="overflow-x:hidden;">
<!--禁止网页另存为-->
<noscript>
    <iframe scr="*.htm"></iframe>
</noscript>
<!--禁止网页另存为-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
    <tr>
        <td rowspan="2" align="left" valign="top" id="logo">
        </td>
        <td align="left" valign="bottom">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="left" valign="bottom" id="header-name"><h1>Ambow</h1></td>
                    <td align="right" valign="top" id="header-right">

                        <a href="/login/loginOut.action" target="topFrame" onFocus="this.blur()"
                           class="admin-out">注销</a>
                        <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="bottom">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="left" valign="top" id="header-admin">党校管理系统</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>