<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'follows.jsp' starting page</title>
    
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
  	<c:if test="${selectedUser == null }">
    	<thead><h1>我关注的人</h1></thead>
    	<tbody>
		    <c:forEach items="${followsList}" var="follow" >
		    	 <tr>
		    	 	<td><a href="/Together/app4m/app/user/userRelation/userInfo?id=${follow.id}">${follow.appUserName }</a></td>  
		    	 	<td>
						<c:choose>
  							<c:when test="${follow.relationStatus== 0}">
  								相互关注 
  							</c:when>

  						</c:choose>
  						<a href="/Together/app4m/app/user/userRelation/cancelFollow?id=${follow.id }">取消关注</a>
  						<a href="/Together/app4m/app/user/userRelation/deFriend?id=${follow.id }">拉黑</a>
		    	 	</td>
		    	 </tr>  
		    </c:forEach>
	    </tbody>
	  </c:if>
	  <c:if test="${selectedUser != null} and ${selectedUser.id != appUser.id }">
	  	<thead><h1>他关注的人</h1></thead>
	  	<tbody>
	  	 <c:forEach items="${followsList}" var="follow" >
		    	 <tr>
		    	 	<td><a href="/Together/app4m/app/user/userRelation/userInfo?id=${follow.id}">${follow.appUserName}</td>
  					<td>
  						<c:choose>
  							<c:when test="${follow.relationStatus== 0}">
  								相互关注 <a href="/Together/app4m/app/user/userRelation/cancelFollow?id=${follow.id}">取消关注</a>
  							</c:when>
	  						<c:when test="${follow.id eq appUser.id}">
	  							本人
	  						</c:when>
  							<c:when test="(${follow.id > appUser.id} and ${follow.relationStatus == 1}) or (${follow.id < appUser.id} and ${follow.relationStatus == -1})">
  								已关注
  							</c:when>
  							<c:otherwise>
  								<a href="/Together/app4m/app/user/userRelation/follow?id=${follow.id}">关注</a>
  							</c:otherwise>
  						</c:choose>
  						<c:choose>
  							<c:when test="${follow.relationStatus <= -10 } or (${follow.id > appUser.id} and ${follow.relationStatus == 2})  or (${follow.id < appUser.id} and ${follow.relationStatus == -2})">
  								已拉黑
  							</c:when>
  							<c:otherwise><a href="/Together/app4m/app/user/userRelation/deFriend?id=${follow.id}">拉黑</a></c:otherwise>
  						</c:choose>
  					</td>
		    	 </tr>  
		    </c:forEach>
	    </tbody>
	  </c:if>
    </table>
  </body>
</html>
