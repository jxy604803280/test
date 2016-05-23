<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<table>
  		<thead><h1>粉丝列表</h1></thead>
  		<tbody>
  			<c:forEach var="fan" items="${fansList}">
  				<tr>
  					<td><a href="/Together/app4m/app/user/userRelation/userInfo?id=${fan.id}">${fan.appUserName}</td>
  					<td>
  						<c:choose>
  							<c:when test="${fan.relationStatus== 0}">
  								相互关注 <a href="/Together/app4m/app/user/userRelation/cancelFollow?id=${fan.id}">取消关注</a>
  							</c:when>
	  						<c:when test="${fan.id eq appUser.id}">
	  							本人
	  						</c:when>
  							<c:when test="${fan.id > appUser.id and fan.relationStatus == 1 or (fan.id < appUser.id and fan.relationStatus == -1)}">
  								已关注  <a href="/Together/app4m/app/user/userRelation/cancelFollow?id=${fan.id}">取消关注</a>
  							</c:when>
  							<c:when test="${fan.relationStatus <= -10 or (fan.id > appUser.id and fan.relationStatus == -2)  or (fan.id < appUser.id and fan.relationStatus == 2)}">
  								已拉黑
  							</c:when>
  							<c:otherwise>
  								<a href="/Together/app4m/app/user/userRelation/follow?id=${fan.id}">关注</a>
  							</c:otherwise>
  						</c:choose>
  						
  						<c:choose>
  							<c:when test="${fan.relationStatus <= -10 or (fan.id > appUser.id and fan.relationStatus == -2)  or (fan.id < appUser.id and fan.relationStatus == 2)}">
  								
  							</c:when>
  							<c:when test="${fan.id eq appUser.id}">
	  
	  						</c:when>
  							<c:otherwise><a href="/Together/app4m/app/user/userRelation/deFriend?id=${fan.id}">拉黑</a></c:otherwise>
  						</c:choose>
  					</td>
  				</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  </body>
</html>
