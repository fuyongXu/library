<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>beyond图书馆首页</title>

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
			欢迎来到beyond图书馆！
		</h1>
		<br>
		<s:if test="session.STUDENT_LOGIN != null">
			<jsp:include page="student/studentLoginTop.jsp" />
		</s:if><s:else>
		<s:if test="#session.MANAGER_LOGIN == null">
			<a href="student/studentLogin.jsp">未登录</a>
			</s:if>
		</s:else>
		<s:if test="#session.MANAGER_LOGIN != null">
			<jsp:include page="manager/managerLoginTop.jsp" />
		</s:if>
		<br />
		<a href="index.jsp">书目索引</a>
		<br>
		<s:if test="#session.STUDENT_LOGIN == null">
			<a href="student/studentLogin.jsp">用户登录</a>
			<br>
		</s:if>
		<a href="newBooksAction?pageNow=1">最近上架</a>
		<s:if test="#session.MANAGER_LOGIN != null">
			<s:a href="managerLogoutAction">注销</s:a>
		</s:if>
	</body>
</html>
