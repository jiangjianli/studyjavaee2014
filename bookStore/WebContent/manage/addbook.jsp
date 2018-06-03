<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@include file="index.jsp" %>
 <style type="text/css">
table{
		margin: 0 auto;
	}
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/category?op=addBook" enctype="multipart/form-data" method="post">
	<table border="1">
		<tr>
			<td>书名</td>
			<td>
			<input type="text" name = "name">
			</td>
		</tr>
		
		<tr>
			<td>作者</td>
			<td>
			<input type="text" name = "author">
			</td>
		</tr>
		
		<tr>
			<td>价格</td>
			<td>
			<input type="text" name = "price">
			</td>
		</tr>
		
		<tr>
			<td>图片</td>
			<td>
			<input type="file" name = "file">
			</td>
		</tr>
		
		<tr>
			<td>描述</td>
			<td>
			<textarea rows="2" cols="10" name = "description"></textarea>
			</td>
		</tr>
		
		<tr>
			<td>所属分类</td>
			<td>
				<select name="categoryId">
					<c:forEach items="${list}" var="cc">
					
						<option  value="${cc.id}">${cc.name}</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		
		<tr> 
		
		</tr>
		
		
	</table>
	
	<input type="submit" value="保存">
		
</form>

</body>
</html>