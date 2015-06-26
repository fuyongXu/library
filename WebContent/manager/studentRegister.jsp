<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href=<%= basePath %>>
    <title>studentRigister</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="..js/register.js"></script>
  </head>
  	
  <body>
	<jsp:include page="managerLoginTop.jsp" />
			
	<form action="studentRegisterAction" method="post">
		姓名：<input type="text" name="name" id="name"/><br>
		密码：<input type="password" name="password" id="password"><br>
		确认密码：<input type="password" id="repassword"><br>
		<button>提交</button><font color="red"><s:property value="registerResult"/></font>
	</form>
  </body>
  		
</html>
