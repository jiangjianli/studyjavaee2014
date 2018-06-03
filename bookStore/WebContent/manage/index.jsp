<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">

	body {
		text-align: center;
	}
	
	table{
		margin: 0 auto;
	}
	
</style>
</head>
<body>

	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/manage/addcategory.jsp">添加分类</a>
	<a href="${pageContext.request.contextPath}/category?op=find">查询分类</a>
	<a href="${pageContext.request.contextPath}/category?op=find_addbook">添加图书</a>
	<a href="${pageContext.request.contextPath}/category?op=showbook">查询图书</a>
	<a href="#">待处理订单</a>
	<a href="#">已处理订单</a>
	<br/>
	<br/>
	
	
</body>
</html>