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
		<title>addSuccess</title>

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
		<h3>
			addSuccess
		</h3>
		<jsp:include page="managerLoginTop.jsp" />
		你要增加的书本数为：<s:property value="count"/><br>
		它们的书号分别为：
		<s:iterator value="book_ids" id="id">
			<s:property value="id"/>
		</s:iterator><br/><br/>
		书本信息如下：
		<br>
		书本名：<s:property value="book.book_name"/><br>
    	作者：<s:property value="book.author"/><br>
    	出版社：<s:property value="book.publishing_company"/><br>
    	出版日期：<s:property value="book.publishing_date"/><br>
    	价格：<s:property value="book.price"/><br>
    	书本介绍：<s:property value="book.introduce"/><br>
    	<s:a href="manager/businessProcess.jsp">返回</s:a><br>
    	<s:a href="manager/addbook.jsp">继续添加书本</s:a>
	</body>
</html>
