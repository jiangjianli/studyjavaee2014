<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-2.1.3.js"></script>


<script type="text/javascript">



function sumit() {
//	var name = document.getElementById("name").value;
//	var desc = document.getElementById("desc").value;

	document.forms[0].submit();
}
	

	
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

	table{
		margin: 0 auto;
	}
	
	.tt{
		border:5;
		border-color:red;
		width: 600px;
		height:100px;
	}
	tr {
		text-align: left;
	}
}
	
</style>

<title>Insert title here</title>

<%@include file="index.jsp" %>


</head>
<body >

	<form action="${pageContext.request.contextPath}/category?op=add" method="post">
	
		<table class="tt">
			<tr>
				<td>分类名称</td>
				<td><input id = "name" type="text" name = "name"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input id = "description" type="text" name = "description"></td>
			</tr>
		</table>
		
	</form>
	
	<input id = "sumb" type="button" value="提交" onclick="sumit();" />
	
</body>



</html>