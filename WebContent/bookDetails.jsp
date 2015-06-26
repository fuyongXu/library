<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>bookDetails</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="js/script.js">
</script>
	</head>

	<body>
		<s:if test="#session.STUDENT_LOGIN != null">
			<jsp:include page="student/studentLoginTop.jsp" />
		</s:if>
		<s:else>
			<s:if test="#session.MANAGER_LOGIN == null">
				<a href="student/studentLogin.jsp">未登录</a>
			</s:if>
		</s:else>
		<s:if test="#session.MANAGER_LOGIN != null">
			<jsp:include page="manager/managerLoginTop.jsp" />
		</s:if>
		<br />
		书号：
		<s:property value="book.book_id" />
		<br>
		书名：
		<s:property value="book.book_name" />
		<br>
		<img src='bookImages/<s:property value="book.image"/>' width="100"
			height="120" />
		<br>
		出版社：
		<s:property value="book.publishing_company" />
		<br />
		作者：
		<s:property value="book.author" />
		<br />
		出版日期：
		<s:property value="book.publishing_date.toString().substring(0, 10)" />
		<br />
		价格：
		<s:property value="book.price" />
		<br />
		是否被借：
		<s:if test="book.borrowed_date == null">否</s:if>
		<s:else>是<br>
			应还日期：<s:property value="book.returnDate.toString().substring(0, 10)" />
		</s:else>
		<br />
		<s:if test="book.borrowed_date == null"></s:if>
		<s:else>
			借阅日期：<s:property
				value="book.borrowed_date.toString().substring(0, 10)" />
			<br />
		</s:else>
		书本简介：
		<s:property value="book.introduce" />
		<br />
		<s:if test="#session.STUDENT_LOGIN != null">
			<s:a action="reservationBookAction?book_id=%{book.book_id}">预约</s:a>&nbsp;&nbsp;&nbsp;
			<s:if test="result != '预约成功！'">
				<font color="red"><s:property value="result"/></font>
			</s:if><s:else>
				<font color="green"><s:property value="result"/></font>
			</s:else>
		</s:if>
		<br>
		<s:a action="borrowedInfoAction">返回</s:a>
	</body>
	
</html>
