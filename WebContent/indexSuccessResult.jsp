<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="paging" uri="tags-com" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>intdexResult</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/script.js"></script>
	</head>
	<body>
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
		<jsp:include page="books_table.jsp"></jsp:include>
		<paging:paging href="indexAction"/>
		<br>
		<button onclick="return returnLastPage();">返回</button>
		<a href="index.jsp">书目索引</a>
	</body>
</html>
