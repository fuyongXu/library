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
		<title>borrowBook</title>

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
		<jsp:include page="managerLoginTop.jsp" />
		
		<form action="borrowBookAction">
			学生号：<input type="text" name="student_id"><br/>
			书号：<input type="text" name="book_id"><br/>
			<input type="submit" value="借阅"/>
		</form>
		
		<s:a href="manager/studentHandler.jsp">返回</s:a>
		<br>
		<s:a href="manager/businessProcess.jsp">返回业务处理页面</s:a>
	</body>
</html>