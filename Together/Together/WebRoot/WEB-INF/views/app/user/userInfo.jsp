<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
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
  
    <h1>
    ${empty selectedUser?appUser.appUserName:selectedUser.appUserName}
     &nbsp;关注:<a href="/Together/app4m/app/user/userRelation/showFollows<c:if test="${not empty  selectedUser?true:false}">?id=${selectedUser.id}</c:if>">${followsCount}</a>
   	  粉丝:<a href="/Together/app4m/app/user/userRelation/showFans<c:if test="${not empty  selectedUser?true:false}">?id=${selectedUser.id}</c:if>">${fansCount}</a>
   	</h1>
   	<br/>
   	<table>
    	
    	<tbody>
    		<c:if test="${selectedUser == null}">
    			<thead><h1>你感兴趣的人</h1></thead>
			    <c:forEach items="${strangersList}" var="stranger" >
			    	 <tr>
			    	 	<td><a href="/Together/app4m/app/user/userRelation/userInfo?id=${stranger.id}">${stranger.appUserName }</a></td>  
			    	 	<td>
			    	 		<a href="/Together/app4m/app/user/userRelation/follow?id=${stranger.id}">关注</a>
			    	 		<a href="/Together/app4m/app/user/userRelation/deFriend?id=${stranger.id}">拉黑</a>
			    	 	</td>
			    	 </tr>  
			    </c:forEach>
			  </c:if>
			  <br/>
	    </tbody>
    </table>
    <form name="cmind" action="/Together/app4m/app/cmind/cmind/publish" method="post">
    	<input type="text" name="context" placeholder="请发表您心中的感想" />
    	<input type="submit"/>
    </form>
    <a href="/Together/app4m/app/cmind/cmind/showCminds">展示cminds</a>
  </body>
</html>
