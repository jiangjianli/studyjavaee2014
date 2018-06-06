<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	div {
		
		
		margin: 0 auto;
	}
</style>
</head>
<body>
<div>
		<a href="${pageContext.request.contextPath}/web?op=gohome">首页</a>
		<c:if test="${sessionScope.customer==null}">
		<a href="login.jsp">登陆</a>
		<a href="register.jsp">免费注册</a>
		</c:if>
		<br/>
		<c:if test="${sessionScope.customer!=null}">
		欢迎您${sessionScope.customer.nickName}
		<a href="${pageContext.request.contextPath}/regiser?op=logout">注销</a>
		</c:if>
		
		<a>我的订单</a>
		<a>购物车</a>
		
		
</div>
<br>
<div>
			
			所有分类
			<c:forEach items="${category}" var="c">
			<a href="${pageContext.request.contextPath}/web?op=gohomeandcategory&categoryId=${c.id}">${c.name}</a>
			
			</c:forEach>
			
		
</div>


<div>
	<table>
	
		<tr>
		
			<c:forEach items="${page.recoder}" var="s">
			
			<td>
				<img style="width: 100px;height: 100px;background-color: red;" alt="" src="${pageContext.request.contextPath}/images/${s.path}/${s.filename}">
				
				<br/>书名 ${s.name}<br/>
				作者${s.author}<br/>
				<a href="${pageContext.request.contextPath}/car?op=addcar&id=${s.id}">加入购物车</a><br/>
				<a href="${pageContext.request.contextPath}/showcar.jsp">购物车</a>
			</td>
			</c:forEach>
		
		</tr>
	</table>
	
</div>



		第${page.currentPage }页 /共${page.totalPage}页
		
		<a href="${pageContext.request.contextPath}/web?op=gohomeandcategory&num=${page.prePage}&categoryId=${selectcategoryid}">上一页</a>
		<a href="${pageContext.request.contextPath}/web?op=gohomeandcategory&num=${page.nextPage}&categoryId=${selectcategoryid}">下一页</a>
</body>
</html>