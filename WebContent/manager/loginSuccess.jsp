<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<title>loginSuccess</title>

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
		<h2>
			<jsp:include page="managerLoginTop.jsp" />
			欢迎登录,您是图书管理员
		</h2>
		<br />
		<s:a href="manager/manager_info.jsp">我的信息</s:a><br>
		<s:a href="manager/businessProcess.jsp">业务处理</s:a><br>
		<s:a href="homePage.jsp">进入首页</s:a><br><br>
		<s:a action="managerLogoutAction">注销</s:a><br>
	</body>
</html>
