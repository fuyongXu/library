<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="#session.STUDENT_LOGIN">
	<s:a action="studentInfoAction">
		您好！<s:property value="#session.STUDENT_LOGIN.student_name" />
	</s:a>
	<br>
	<s:a action="logoutAction">注销</s:a>
	<br>
</s:if><s:else>
	学生<s:a href="student/studentLogin.jsp">未登录</s:a><br/>
</s:else>