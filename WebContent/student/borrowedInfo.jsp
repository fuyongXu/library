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
<base href=<%=basePath%>>
<title>borrowedInfo</title>

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
	<br>

	<div align="right">
		<s:if test="renewResult.equals('续借成功！')">
			<font color="green"><s:property value="renewResult" /> </font>
		</s:if>
		<s:else>
			<font color="red"><s:property value="renewResult" /> </font>
		</s:else>
	</div>

	<br>
	<h3>已借书本</h3>
	<br>
	<table id="table" border="1" bordercolor="green" width="1000px"
		cellspacing=0 align="center">
		<tbody>
			<tr>
				<th>书名</th>
				<th>书号</th>
				<th>出版社</th>
				<th>作者</th>
				<th>出版时间</th>
				<th>价格</th>
				<th>被借日期</th>
				<th>应还日期</th>
				<th>details</th>
				<th>续借</th>
			</tr>
			<s:if test="borrowedBooks!=null&&borrowedBooks.size()!=0">
				<s:iterator value="borrowedBooks" id="book">
					<tr>
						<td><s:property value="book_name" /></td>
						<td><s:property value="book_id" /></td>
						<td><s:property value="publishing_company" /></td>
						<td><s:property value="author" /></td>
						<td><s:date name="publishing_date" format="yyyy-MM-dd" /></td>
						<td><s:property value="price" /></td>
						<td><s:date name="borrowed_date" format="yyyy-MM-dd" /></td>
						<td><s:date name="returnDate" format="yyyy-MM-dd" /></td>
						<td><s:a href="bookDetailsAction?book_id=%{#book.book_id}">详情</s:a></td>
						<td><s:a action="renewBookAction?book_id=%{#book.book_id}">续借</s:a></td>
					</tr>
					<s:if test="book.isRenewed">
						<font color="green"><s:property value="isSucess" /></font>
					</s:if>
					<s:else>
						<font color="red"><s:property value="isSucess" /></font>
					</s:else>
				</s:iterator>
			</s:if>
			<s:else>
				<tr>
					<th colspan="10">没有已借的书本</th>
				</tr>
			</s:else>
		</tbody>
	</table>

	<h3>已预阅的书本</h3>
	<br>
	<table id="table" border="1" bordercolor="green" width="1000px"
		cellspacing=0 align="center">
		<tr>
			<th>书号</th>
			<th>书名</th>
			<th>应还日期</th>
			<th>预约提醒</th>
		</tr>
		<s:if test="reservationBooks!=null&&reservationBooks.size()!=0">
			<s:iterator value="reservationBooks" id="book_">
			<tr>
				<td><s:property value="book_id" /></td>
				<td><s:property value="book_name" /></td>
				<td><s:date name="returnDate"
						format="yyyy-MM-dd" /></td>
				<td><s:if test="book.borrowedDate == null">
						您预约的书本已经可以借阅
					</s:if>
					<s:else>
						书本未归还
					</s:else></td>
			</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<th colspan="4">没有预阅的书本！</th>
			</tr>
		</s:else>
	</table>
	<a href="index.jsp">书目索引</a>
</body>
</html>
