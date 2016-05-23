<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	${appUser.message}<br/>
  	Register
    <form action="app4m/app/user/user/register" method="post">
    	&nbsp;&nbsp;name:<input type="text" name="appUserName"/><br/>
    	password:<input type="password" name="password"/><br/>
    	&nbsp;&nbsp;mail:<input type="text" name="userMail" /><br/>
    	<input type="submit" value="注册"/><br/>
    	<a href="/Together/app4m/app/user/user/showLogin">去登陆</a>
    </form>
  </body>
</html>
