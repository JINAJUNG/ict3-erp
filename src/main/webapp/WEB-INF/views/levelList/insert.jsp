<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--다알고있다  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String rPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${!empty map}">
	<script>
	alert('${map.msg}');
	if(${map.cnt}==1)
	location.href = '<%=rPath%>/levelList';
	</script>
</c:if>
</head>
<body>
	<form action="<%=rPath%>/levelIn" method="post">
		liname : <input type="text" name="liname"><br> 
		lilevel :<input type="text" name="lilevel"><br> 
		lidesc : <input	type="text" name="lidesc"><br>
		<button>전송</button>
	</form>
</body>
</html>