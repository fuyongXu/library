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
		<title>updatePassword</title>

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
		<jsp:include page="studentLoginTop.jsp"></jsp:include>
		<br />
		<form action="updatePasswordAction">
			请输入旧密码：
			<input type="password" name="oldPassword" />
			<br>
			请输入新密码：
			<input type="password" name="newPassword" />
			<br>
			请再次输入新密码：
			<input type="password" name="reNewPassword" />
			<br>
			<font color="red"><s:property value="updateResult" />
			</font><br>
			<input type="submit">
		</form>
	</body>
</html>
