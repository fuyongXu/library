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
    <title>borrowSuccess</title>
    <base href=<%= basePath %>>
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
		<h3><s:property value="book.student.student_name"/>恭喜您！借阅成功。</h3><br/>
		已借书本信息如下：<br/>
			书号：<s:property value="book.book_id"/><br>
			书名：<s:property value="book.book_name"/><br>
			作者：<s:property value="book.author"/><br>
			出版社：<s:property value="book.publishing_company"/><br>
			出版日期：<s:property value="book.publishing_date.toString().substring(0, 10)"/><br>
			应还日期：<s:property value="book.returnDate"/><br>
			<s:a href="manager/borrowBook.jsp">返回借阅页面</s:a>
  </body>
</html>
