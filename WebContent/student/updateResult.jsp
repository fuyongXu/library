<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>updateReult</title>
		<base href=<%= basePath %>>
	</head>
	<body>
		<H1><s:property value="updateResult"/></H1><br>
		<s:if test="#session.STUDENT_LOGIN == null">
			您需要<a href="student/studentLogin.jsp">重新登录</a>才有效！
		</s:if>
	</body>
</html>