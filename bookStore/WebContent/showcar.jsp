<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty sessionScope.car.map}">

<h3>您没有购买任何商品</h3>
</c:if>

<c:if test="${!empty sessionScope.car.map}">

	<table border="1">
	
		<tr>
		<th>书名</th>
		<th>数量</th>
		<th>单价</th>
		<th>小计</th>
		<th>操作</th>
		</tr>
		
		<c:forEach items="${sessionScope.car.map}" var="s">
		
		<tr>
			<td>${s.value.book.name}</td>
			<td><input id = "tet" type="text" value="${s.value.quanity}" onchange="changenum(this,${s.value.quanity})"> </td>
			<td>${s.value.book.price}</td>
			<td>${s.value.price}</td>
			<td>
				<a href="${pageContext.request.contextPath}/car?op=deletecar&id=${s.key}">删除</a>
			</td>
			
			
		</tr>
		
		</c:forEach>
		
	</table>

</c:if>

</body>

<script type="text/javascript">

	function changenum(obj,oldnum) {
		var sure = window.confirm("确定修改数量吗？");
		if(sure)
		{
			//obj.value = 
		}else  {
			obj.value = oldnum;
		}
	}
</script>

</html>