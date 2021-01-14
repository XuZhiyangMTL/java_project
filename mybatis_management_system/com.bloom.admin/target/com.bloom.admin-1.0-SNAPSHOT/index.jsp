<%--
  Created by IntelliJ IDEA.
  User: xuzhiyang
  Date: 2020/12/22
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>bloom.com users control center</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/2.2.4/jquery-1.12.4.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>user controller system <small>users data control center</small></h1>
        </div>
    </div>
    <div class="row">
        <h1>author</h1>
        <p>Zhiyang XU</p>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/addusers.jsp" role="button">add new user</a></p>
    </div>
    <div class="row">
        <table class="table table-hover table-striped">
            <tr>
                <th>id</th>
                <th>username</th>
                <th>nickname</th>
                <th>email</th>
                <th>phone</th>
                <th>date created</th>
                <th>status</th>
                <th>operate</th>
            </tr>
            <c:forEach var="user" items="${usersList}"> <!--item表示要循环的对象在servlet中将数据存在了usersList中-->
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.nickname}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.createTime}</td>
                <c:if test="${user.userStatus==0}">
                    <td>normal</td>
                </c:if>
                <c:if test="${user.userStatus==1}">
                    <td>locked</td>
                </c:if>
                <c:if test="${user.userStatus==2}">
                    <td>deleted</td>
                </c:if>
                <td>
                    <a href="${pageContext.request.contextPath}/detail?id=${user.id}">check</a>
                    <c:if test="${user.userStatus == 0}">
                    <a href="${pageContext.request.contextPath}/deluser?id=${user.id}&type=lock">lock</a>
                    </c:if>
                    <c:if test="${user.userStatus == 1}">
                        <a href="${pageContext.request.contextPath}/deluser?id=${user.id}&type=unlock">unlock</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/deluser?id=${user.id}&type=del">delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
