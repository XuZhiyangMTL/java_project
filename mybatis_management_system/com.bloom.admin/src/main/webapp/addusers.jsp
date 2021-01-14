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
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addusers">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" placeholder="Please enter username">
            </div>
        </div>
        <div class="form-group">
            <label for="userpass" class="col-sm-2 control-label">password</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="userpass" name="userpass" placeholder="Please enter password">
            </div>
        </div>
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">nickname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Please enter nickname">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">age</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="age" name="age" placeholder="Please enter age">
            </div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-2 control-label">gender</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gender" name="gender" placeholder="Please enter gender">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">phone</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Please enter phone number">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="email" name="email" placeholder="Please enter email">
            </div>
        </div>
        <div class="form-group">
            <input type="submit" value="submit" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
</html>
