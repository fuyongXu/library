<%@ page language="java"
	import="java.util.*,beyond.library.util.DateUtil" pageEncoding="UTF-8"%>
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
<title>studentHandler</title>

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
	<br />
	<br />
	<br /> 学生信息：
	<br>
	<table id="table" border="1" bordercolor="green" width="1000px"
		cellspacing=0 align="center">
		<tbody align="center">
			<tr>
				<th>借阅号</th>
				<th>姓名</th>
				<th>借阅等级</th>
				<th>最大借阅量</th>
				<th>已借书本数</th>
				<th>最大借阅时间</th>
				<th>卡内余额</th>
				<th>累积借阅量</th>
				<th>累积借阅超期天数</th>
				<th>欠款</th>
			</tr>
			<tr>
				<td><s:property value="#session.STUDENT_INFO.student_id" /></td>
				<td><s:property value="#session.STUDENT_INFO.student_name" />
				</td>
				<td><s:property value="#session.STUDENT_INFO.grade" /></td>
				<td><s:property value="#session.STUDENT_INFO.max_borrow_count" />
				</td>
				<td><s:property value="#session.STUDENT_INFO.borrowed_count" />
				</td>
				<td><s:property value="#session.STUDENT_INFO.max_borrow_time" />
					天</td>
				<td><s:property value="#session.STUDENT_INFO.money" /> 元</td>
				<td><s:property
						value="#session.STUDENT_INFO.accumulate_borrow_books" /></td>
				<td><s:property
						value="#session.STUDENT_INFO.accumulate_beyond_borrow_max_days" />
				</td>
				<s:if test="#session.STUDENT_INFO.reduceMoney == 0">
					<td>0</td>
				</s:if>
				<s:else>
					<td align="center" width="80"><font color="red">-<s:property
								value="#session.STUDENT_INFO.reduceMoney" />
					</font> <s:a action="settleAccountsAction">结算</s:a></td>
				</s:else>
			</tr>
		</tbody>
	</table>
	<h3>已借书本详情：</h3>
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
				<th>续借</th>
			</tr>
			<s:if test="books != null && books.size != 0">
				<s:iterator value="books" id="book">
					<tr>
						<td><s:property value="book_name" /></td>
						<td><s:property value="book_id" /></td>
						<td><s:property value="publishing_company" /></td>
						<td><s:property value="author" /></td>
						<td><s:date name="publishing_date" format="yyyy-MM-dd" /></td>
						<td><s:property value="price" /></td>
						<td><s:date name="borrowed_date" format="yyyy-MM-dd" /></td>
						<td><s:if test="isBeyondBorrowDate">
								<font color="red"> <s:date name="returnDate"
										format="yyyy-MM-dd" />
								</font>
							</s:if> <s:else>
								<s:date name="returnDate" format="yyyy-MM-dd" />
							</s:else></td>
						<th><s:a action="renewBookAction2?book_id=%{book_id}">续借 </s:a>
						</th>
					</tr>
				</s:iterator>
				<div align="right">
					<s:if test="renewResult.equals('续借成功！')">
						<font color="green"><s:property value="renewResult" /> </font>
					</s:if>
					<s:else>
						<font color="red"><s:property value="renewResult" /> </font>
					</s:else>
				</div>
			</s:if>
			<s:else>
				<tr>
					<th colspan="9" align="center">没有已借的书本</th>
				</tr>
			</s:else>
		</tbody>
	</table>
	<br>
	<br>
	<h3>预约书本</h3>
	<br>
	<table id="table" border="1" bordercolor="green" width="1000px"
		cellspacing=0 align="center">
		<tbody>
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
						<td><s:date name="returnDate" format="yyyy-MM-dd" /></td>
						<td><s:if test="book.borrowedDate == null">
						您预约的书本已经可以借阅
					</s:if> <s:else>
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
		</tbody>
	</table>
	<br><br><br>
	<form action="borrowBookAction">
		书号： <input type="text" name="book_id" /> <input type="submit"
			value="书本借阅" />
		<s:if test="borrowedResult == '借书办理成功！'">
			<font color="green"><s:property value="borrowedResult" /> </font>
		</s:if>
		<s:else>
			<font color="red"><s:property value="borrowedResult" /> </font>
		</s:else>
	</form>
	<br />
	<br />
	<s:a href="manager/businessProcess.jsp">返回</s:a>
	<br />
	<s:a href="index.jsp">索引</s:a>
</body>
</html>
