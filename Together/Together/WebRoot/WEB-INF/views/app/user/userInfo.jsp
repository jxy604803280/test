<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		showCminds();
	})
	
	 function showCminds(){
		var id = $("#userIdText").val();
		$.ajax(
			{
				type:"POST",
				url:'/Together/app4m/app/cmind/cmind/showCminds',
				data:{"id":id},
				cache:false,
				dataType:'json',
				async:true,
				success:function(data){
					$("#cmindsTable").append("<thead>Cminds</thead>");
					for(var i=0;i<data.length;i++){
						$("#cmindsTable").append("<div style='width:500px;height:60px;border: medium;border-color:black;text-align: left;'>"+data[i].context
						+"<i><br/><font size='1px'>"+data[i].cmindDate+"</font></i></br>"+"<input name='cmindId' type='text' placeholder='请评论'/></div>");
					};
				},
				error:function(){
					alert("error");
				}
			}
		)		
	} 
</script>
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
    <input type="text" id="userIdText" style="display: none" value="${empty selectedUser?appUser.id:selectedUser.id}"/>
    ${empty selectedUser?appUser.appUserName:selectedUser.appUserName}
     &nbsp;关注:<a href="/Together/app4m/app/user/userRelation/showFollows<c:if test="${not empty  selectedUser?true:false}">?id=${selectedUser.id}</c:if>">${followsCount}</a>
   	  粉丝:<a href="/Together/app4m/app/user/userRelation/showFans<c:if test="${not empty  selectedUser?true:false}">?id=${selectedUser.id}</c:if>">${fansCount}</a>
   	</h1>
   	<br/>
   	<table>
    	
    	<tbody>
    		<c:if test="${selectedUser == null}">
    			<thead>你感兴趣的人</thead>
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
    <c:if test="${not empty cmindsList}">
	    <c:forEach items="${cmindsList}" var="cmind">
	    	<div><i>${cmind.context}</i><br/><font size="2px">${cmind.cmindDate }</font></div>
	    </c:forEach>
    </c:if>
  </body>
  <table id="cmindsTable" >
  </table>
</html>
