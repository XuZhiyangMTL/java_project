<%--
  Created by IntelliJ IDEA.
  User: xuzhiyang
  Date: 2020/12/23
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--将请求转发到下一个页面-->
<%
    response.sendRedirect("/com_bloom_admin_war_exploded/servlet");
%>
</body>
</html>
