<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.MANAGER_LOGIN != null">
			管理员
			<s:a href="manager/manager_info.jsp">
		<s:property value="#session.MANAGER_LOGIN.manager_name" />
	</s:a>已登录！
	<br>
</s:if>