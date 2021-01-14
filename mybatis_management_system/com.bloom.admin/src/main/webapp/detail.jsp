<%--
  Created by IntelliJ IDEA.
  User: xuzhiyang
  Date: 2020/12/26
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <p><a class="btn btn-primary btn-lg" href="#" role="button">bloom.com home page</a></p>
    </div>
</div>
<c:set var="user" value="${user}"></c:set>
<div class="row">
    <div calss="col-md-6 col-md-offset-2">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/updateusers">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label class="col-sm-2 control-label">useraccount</label>
            <div class="col-sm-10">
                <p class="form-control-static">${user.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">password</label>
            <div class="col-sm-10">
                <p class="form-control-static">********</p>
            </div>
        </div>
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">nickname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nickname" value="${user.nickname}" name="nickname" placeholder="Please enter nickname">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">age</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="Please enter age">
            </div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-2 control-label">gender</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gender" name="gender" value="${user.gender}" placeholder="Please enter gender">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">phone</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" placeholder="Please enter phone number">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="email" name="email" value="${user.email}" placeholder="Please enter email">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">createTime</label>
            <div class="col-sm-10">
                <p class="form-control-static">
                    <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">updateTime</label>
            <div class="col-sm-10">
                <p class="form-control-static">
                    <fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">lastLoginTime</label>
            <div class="col-sm-10">
                <p class="form-control-static">
                    <fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">userStatus</label>
            <div class="col-sm-10">
                <c:if test="${user.userStatus == 0}">
                <p class="form-control-static">normal</p>
                </c:if>
                <c:if test="${user.userStatus == 1}">
                    <p class="form-control-static">locked</p>
                </c:if>
                <c:if test="${user.userStatus == 2}">
                    <p class="form-control-static">deleted</p>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <label for="remark" class="col-sm-2 control-label">remark</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="remark" name="remark" value="${user.remark}" placeholder="Please enter remark">
            </div>
        </div>
        <div class="form-group">
            <input type="submit" value="submit update" class="btn btn-primary">
        </div>
    </form>
    </div>
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>id</th>
                <th>nation</th>
                <th>province</th>
                <th>city</th>
                <th>country</th>
                <th>street</th>
                <th>detail</th>
                <th>is default</th>
            </tr>
            <c:forEach var="addr" items="${user.addresses}">
                <tr>
                    <td>${addr.id}</td>
                    <td>${addr.nation}</td>
                    <td>${addr.province}</td>
                    <td>${addr.city}</td>
                    <td>${addr.country}</td>
                    <td>${addr.street}</td>
                    <td>${addr.remark}</td>
                    <c:if test="${addr.defaultAddr == true}">
                        <td>default address</td>
                    </c:if>
                    <c:if test="${addr.defaultAddr == false}">
                        <td>------------</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
