<%@ page import="bean.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: xuxiaobo
  Date: 2020/9/5
  Time: 3:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    UserInfo userInfo = (UserInfo) request.getAttribute("user");

    out.print("欢迎登录" + userInfo.getPhone());
%>


</body>
</html>
