<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="paging" uri="tags-com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new_books</title>
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
		<jsp:include page="books_table.jsp"/>
		<paging:paging href="newBooksAction"/>
		<br>
		<button onclick="return returnLastPage();">返回</button>
		<a href="homePage.jsp">主页</a>
</body>
</html>