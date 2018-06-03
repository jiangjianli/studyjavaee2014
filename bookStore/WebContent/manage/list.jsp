<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <%@include file="index.jsp" %>
</head>
<body>

<table border="1">
	
	<tr>
	<th>序号</th>
	<th>书名</th>
	<th>作者</th>
	<th>单价</th>
	<th>描述</th>
	<th>所属分类</th>
	<th>图片</th>
	<th>操作</th>
	</tr>
	
	
	<c:forEach items="${page.recoder}" var="l" varStatus="s">
	
		<tr>
	
			<td>${s.count}</td>
			<td>${l.name}</td>
			<td>${l.author}</td>
			<td>${l.price }</td>
			<td>${l.description }</td>
			<td>${l.category.name }</td>
			<td>
			<img alt="" src="${pageContext.request.contextPath}/images/${l.path}/${l.filename}">
			</td>
			<td>
				<a href="#">修改</a>
				<a href="#">删除</a>
			</td>
		</tr>
	</c:forEach>
	
</table>

	第${page.currentPage }页 共${page.totalPage}页
		
		<a href="${pageContext.request.contextPath}/category?op=showbook&num=${page.prePage}">上一页</a>
		<a href="${pageContext.request.contextPath}/category?op=showbook&num=${page.nextPage}">下一页</a>
</body>
</html>