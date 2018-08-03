<%--
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
    <title>全部考勤列表
    </title>
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
        <td width="99%" align="left" valign="top">
            <shiro:hasRole name="user">
                您的位置：我的考勤
            </shiro:hasRole>
            <shiro:lacksRole name="user">
                您的位置：考勤管理
            </shiro:lacksRole>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                        <shiro:lacksRole name="user">
                            <form method="post" action="<%=request.getContextPath()%>fuzzyQuery.action?index=1">
                                <span>模糊查询：</span>
                                <input type="text" name="str" value="" class="text-word">
                                <input name="" type="submit" value="查询" class="text-but">
                            </form>
                        </shiro:lacksRole>
                    </td>

                    <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;">
                        <shiro:lacksRole name="user">
                            <a href="<%=request.getContextPath()%>toNewCheck.action" target="mainFrame"
                               onFocus="this.blur()" class="add">新增考勤</a>
                        </shiro:lacksRole>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">工号</th>
                    <th align="center" valign="middle" class="borderright">干部姓名</th>
                    <th align="center" valign="middle" class="borderright">课程名</th>
                    <th align="center" valign="middle" class="borderright">缺勤次数</th>
                    <th align="center" valign="middle" class="borderright">详情</th>
                    <shiro:lacksRole name="user">
                        <th align="center" valign="middle">操作</th>
                    </shiro:lacksRole>
                </tr>
                <s:iterator value="list" var="a">
                    <tr>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#a.num"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#a.userName"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#a.courseName"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#a.absNum"/></td>
                        <td align="center" valign="middle" class="borderright borderbottom"><s:property
                                value="#a.info"/></td>
                        <shiro:lacksRole name="user">
                            <td align="center" valign="middle" class="borderbottom"><a
                                    href="<%=request.getContextPath()%>toUpdateCheck.action?id=<s:property value="#a.checkId"/>"
                                    target="mainFrame"
                                    onFocus="this.blur()"
                                    class="add">修改</a></td>
                        </shiro:lacksRole>
                    </tr>
                </s:iterator>
                <%--<c:forEach items="${requestScope.list}" var="a">--%>
                <%----%>

                <%--</c:forEach>--%>
            </table>
        </td>
    </tr>
    <shiro:lacksRole name="user">
        <tr>
            <td align="left" valign="top" class="fenye"><s:property value="#index"/>/<s:property value="#allPage"/>页&nbsp;&nbsp;
                <s:if test="#bj!='fuzzy'.toString()">
                <a href="<%=request.getContextPath()%>toCheckList.action?index=1" target="mainFrame"
                   onFocus="this.blur()">首页</a>&nbsp;&nbsp;

                <s:if test="#index==1">
                    <a id="prior" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#index>1">
                    <a id="prior"
                       href="<%=request.getContextPath()%>toCheckList.action?index=<s:property value="#index-1"/>"
                       target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage>#index">
                    <a id="last"
                       href="<%=request.getContextPath()%>toCheckList.action?index=<s:property value="#index+1"/>"
                       target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage<=#index">
                    <a id="last" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>

                <a
                        href="<%=request.getContextPath()%>toCheckList.action?index=<s:property value="#allPage"/>"
                        target="mainFrame" onFocus="this.blur()">尾页</a></td>
            </s:if>
            <s:if test="#bj=='fuzzy'.toString()">
                <a href="<%=request.getContextPath()%>fuzzyQuery.action?index=1&str=<s:property value="#str"/>"
                   target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;

                <s:if test="#index==1">
                    <a id="prior" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#index>1">
                    <a id="prior"
                       href="<%=request.getContextPath()%>fuzzyQuery.action?index=<s:property value="#index-1"/>&str=<s:property value="#str"/>"
                       target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage>#index">
                    <a id="last"
                       href="<%=request.getContextPath()%>fuzzyQuery.action?index=<s:property value="#index+1"/>&str=<s:property value="#str"/>"
                       target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allPage<=#index">
                    <a id="last" style="cursor: default;"
                       href="javascript:return false;" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
                </s:if>

                <a
                        href="<%=request.getContextPath()%>fuzzyQuery.action?index=<s:property value="#allPage"/>&str=<s:property value="#str"/>"
                        target="mainFrame" onFocus="this.blur()">尾页</a></td>
            </s:if>

        </tr>
    </shiro:lacksRole>
</table>

</body>
</html>

