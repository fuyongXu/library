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
		<title>处理业务</title>
		<base href=<%=basePath%>>
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
		<a href="manager/addbook.jsp">添加书目</a>
		<br>
		学生业务办理
		<form action="studentHandlerAction" method="post">
			<input type="text" name="student_id" />
			<input type="submit" value="业务办理">
			<font color="red"><s:property value="result" />
			</font>
		</form>
		<form action="returnBookAction" method="post">
			<input type="text" name="book_id" />
			<input type="submit" value="书本归还">
		</form>
		<br>
		<a href="manager/studentRegister.jsp">用户注册</a>
		<br>
		<s:a action="managerLogoutAction">注销</s:a>
		<br />
		<br />
		<br />
		<s:a href="index.jsp">索引书目</s:a>
		<br>
		<s:property value="returnResult" />
		<br>
		-----------------------------------------------------------------------------------------------------------------------------------
		<br>
		<s:if
			test="#session.RETURNED_BOOKS != null && #session.RETURNED_BOOKS.size != 0">
		已经还的书本：<br>
			<table id="table" border="1" bordercolor="green" width="1000px"
				cellspacing=0 align="center">
				<tbody>
					<tr>
						<th>
							书名
						</th>
						<th>
							书号
						</th>
						<th>
							出版社
						</th>
						<th>
							作者
						</th>
						<th>
							出版时间
						</th>
						<th>
							价格
						</th>
					</tr>
					<s:iterator value="#session.RETURNED_BOOKS" id="book">
						<tr>
							<td>
								<s:property value="book_name" />
							</td>
							<td>
								<s:property value="book_id" />
							</td>
							<td>
								<s:property value="publishing_company" />
							</td>
							<td>
								<s:property value="author" />
							</td>
							<td>
								<s:property value="publishing_date.toString().substring(0, 10)" />
							</td>
							<td>
								<s:property value="price" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
	</body>
</html>
