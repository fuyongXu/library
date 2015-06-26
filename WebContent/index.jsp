<%@ page language="java"
	import="java.util.*,beyond.library.medol.Student" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>index book</title>
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
		<jsp:include page="student/studentLoginTop.jsp" />
		<jsp:include page="manager/managerLoginTop.jsp" />
		<br />
		<form action="indexAction.action">
			索引方式：
			<select name="query_kinds">
				<option>
					按书名查询
				</option>
				<option>
					按作者查询
				</option>
				<option>
					按出版社查询
				</option>
			</select>
			<br>
			<input type="hidden" value="1" name="pageNow" />
			查询条件：
			<input name="dimName" type="text" />
			<br />
			页面显示条数：
			<select name="pageSize">
				<option>
					20
				</option>
				<option>
					40
				</option>
				<option>
					60
				</option>
				<option>
					80
				</option>
				<option>
					100
				</option>
			</select>
			<br>
			<input name="submit" type="submit" />
		</form>
		<br>
		<a href="student_infoAction.action">查看学生详细信息</a>
		<br />
		<a href="homePage.jsp">主页</a>
	</body>
</html>
