<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- pageEncoding="ISO-8859-1" -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/css/bootstrap.css"/>
	<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/login.css"/>
	<base href="<%=basePath%>">
	
	<title>My jsp "login.jsp" starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
</head>
<body>
	<!-- <form action="login" method="post">
		<label>用户名：</label><input type="text" name="userName"/><br/>
		<label>password：</label><input type="password" name="password"/><br/>
		<input type="submit" value="login"/>
		<input type="reset" value="reset"/>
	</form> -->
	
	<div class="signin">
		<form class="form-signin" action="login" method="post">
		      <h2 class="form-signin-heading">Please sign in</h2>
		      <label for="username" class="sr-only">username</label><input type="text" name="userName" id="username" class="form-control" placeholder="username" required autofocus>
		      <label for="inputPassword" class="sr-only">password</label><input type="password" name="password" id="inputPassword" class="form-control" placeholder="password" required>
		      <!-- <div class="checkbox">
		        <label>
		          <input type="checkbox" value="remember-me"> Remember me
		        </label>
		      </div> -->
		      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		      <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
		      <a href="<%=request.getContextPath()%>/register">Register</a>
    	</form>
	</div>
	
	
	${error}
</body>
</html>