<%--
  Created by IntelliJ IDEA.
  User: xuxiaobo
  Date: 2020/8/17
  Time: 10:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ include file="bottom_c.jsp"%>&lt;%&ndash;底部公共样式&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="..." %>--%>
<%@ page import="cn.tomcat.web.bean.RalUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error_c.jsp" isErrorPage="false" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>

  <%! String xbody = "boboxu";
  %>
<%--动态获取虚拟目录--%>
${pageContext.request.contextPath}
  <form action="${pageContext.request.contextPath}/login" method="post"></form>
  <%
    String str = request.getParameter("name");

    RalUser user = new RalUser();
    user.setNickname("bobo");
    user.setPassword("123456");
    user.setId(123456);

//    1.当前页面共享数据，还可以获取其他8个内置对象
//    pageContext   PageContext

//    2.一次请求访问的多个资源
//    request HttpServletRequest

//    3.响应对象
//    response HttpServletResponse

//    4.一次会话的多个请求间
//    session HttpSession

//    5.所有用户间共享数据
//    application ServletContext

//    6.当前页面(Servlet的对象)this
//    page Object

//    7.输出对象 数据输出到页面上
//    out JspWriter

//    8.Servlet配置对象
//    config ServletConfig

//    9.异常对象
//    exception Throwable

  %>
  <%=xbody %>
  </body>
</html>
