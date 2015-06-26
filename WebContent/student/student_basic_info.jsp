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
    <title>student_basic_info</title>
    
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
    学生姓名：<s:property value="#session.STUDENT_LOGIN.student_name" /><br/>
    学生借阅号：<s:property value="#session.STUDENT_LOGIN.student_id" /><br/>
    学生借阅等级：<s:property value="#session.STUDENT_LOGIN.grade" /><br/>
    学生最大借阅量：<s:property value="#session.STUDENT_LOGIN.max_borrow_count" /><br/>
    已借书本数：<s:property value="#session.STUDENT_LOGIN.borrowed_count" /><br/>
    最大借阅时间：<s:property value="#session.STUDENT_LOGIN.max_borrow_time" /><br/>
    卡内余额：<s:property value="#session.STUDENT_LOGIN.money" /><br/>
    累积借阅量：<s:property value="#session.STUDENT_LOGIN.accumulate_borrow_books" /><br/>
    累积借阅超期天数：<s:property value="#session.STUDENT_LOGIN.accumulate_beyond_borrow_max_days" /><br/>
    <s:a action="borrowedInfoAction">查询借书详情</s:a><br>
    <s:a href="student/updatePassword.jsp">密码修改</s:a>
    <br>
    <a href="index.jsp">书目索引</a>
  </body>
</html>
