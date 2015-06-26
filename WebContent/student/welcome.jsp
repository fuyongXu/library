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
		<title>welcome</title>

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
	<h2><font color="blue">欢迎登录！</font></h2><br>
		学生姓名：
		<s:property value="student.student_name" />
		<br />
		学生借阅号：
		<s:property value="student.student_id" /><br>
		<s:a action="logoutAction">注销</s:a>
		<br />
		<a href="index.jsp">书目索引</a>
		<s:a action="studentInfoAction">查看学生详细信息</s:a>
	</body>
</html>
