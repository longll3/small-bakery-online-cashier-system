<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册成功</title>
</head>
<body>
<center>
<h1><b>欢迎新用户</b></h1>

用户名：${requestScope.username}<br>
邮箱：${requestScope.email}<br>

<!-- 用户名：${user.userName}<br> 
邮箱：${user.email}<br>   -->


</center>
</body>
</html>