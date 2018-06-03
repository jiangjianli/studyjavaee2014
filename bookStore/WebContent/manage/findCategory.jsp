<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
 <%@include file="index.jsp" %>
 <style type="text/css">
 		table {
			margin: 0 auto;
		}
 </style>
</head>
<body>

		
		<table border="2" width="500" height="400">
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
			<c:forEach items="${list}" var="ll" varStatus="vs">
				<tr>
					<th>${vs.count}</th>
					<th>${ll.name}</th>
					<th>${ll.description }</th>
					<td>
						<a href="#">修改</a>
						<a href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>

</body>
</html>