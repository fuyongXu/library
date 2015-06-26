<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="table" border="1" bordercolor="green" width="1000px"
			cellspacing=0 align="center" title="书目信息">
			<tbody>
				<tr>
					<th>书名</th>
					<th>书号</th>
					<th>出版社</th>
					<th>作者</th>
					<th>出版时间</th>
					<th>价格</th>
					<th>是否被借</th>
					<th>书本详情</th>
					<s:if test="#session.MANAGER_LOGIN != null && books != null && books.size() != 0">
						<th>删除书目</th>
					</s:if>
				</tr>
				<s:if test="books != null && books.size() != 0">
				<s:iterator value="books" id="book">
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
						<td>
							<s:if test="borrowed_date == null">否</s:if>
							<s:else>是</s:else>
						</td>
						<td>
							<s:a href="bookDetailsAction?book_id=%{#book.book_id}">details</s:a>
						</td>
						<s:if test="#session.MANAGER_LOGIN != null">
							<th>
								<s:a onclick='return deleteOr();'
									action="deleteBookAction?book_id=%{#book.book_id}">刪除</s:a>
							</th>
						</s:if>
						<s:if test="#session.STUDENT_LOGIN != null">
					</s:if>
					</tr>
				</s:iterator>
				</s:if><s:else>
					<tr>
						<th colspan="8"><font color="red"><s:property value="noResult"/></font></th>
					</tr>
				</s:else>
			</tbody>
		</table>
</body>
</html>