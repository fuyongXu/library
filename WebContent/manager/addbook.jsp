<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
  <head>
  	<base href=<%= basePath %>>
    <title>addBook</title>
    
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
    <form action="addBookAction.action" method="post" enctype="multipart/form-data">
    	书名：<input type="text" name="book_name"/>
    	书类号<select name="kind_id">
    		<option>未选择</option>
			<option value="A">A：马克思主义、列宁主义、毛泽东思想、邓小平理论</option>
			<option value="B">B：哲学、宗教 </option>
			<option value="C">C：社会科学总论</option>
			<option value="D">D：政治、法律</option>
			<option value="E">E：军事</option>
			<option value="F">F：经济</option>
			<option value="G">G：文化、科学、教育、体育</option>
			<option value="H">H：语言、文字</option>
			<option value="I">I：文学</option>
			<option value="J">J：艺术</option>
			<option value="K">K：历史、地理</option>
			<option value="N">N：自然科学总论</option>
			<option value="O">O：数理科学和化学</option>
			<option value="P">P：天文学、地球科学 </option>
			<option value="Q">Q：生物科学</option>
			<option value="R">R：医药、卫生</option>
			<option value="S">S：农业科学</option>
			<option value="T">T：工业技术</option>
			<option value="U">U：交通运输</option>
			<option value="V">V：航空、航天</option>
			<option value="X">X：环境科学、安全科学</option>
			<option value="Z">Z：综合图书</option>
		</select><br/>
    	作者：<input type="text" name="author"/><br>
    	出版社：<input type="text" name="publishing_company"/><br>
    	出版日期：<input type="text" name="publishing_date"/><br>
    	价格：<input type="text" name="price"><br>
    	图片：<input type="file" name="image"><br>
    	书本介绍：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<textarea name="introduce" cols ="50" rows = "4"></textarea><br>
		添加书本数：<select name="count">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
		</select><br/>
		<input type="submit" name="add">
    </form><br><br>
    <s:a href="manager/businessProcess.jsp">返回业务办理</s:a>
  </body>
</html>
