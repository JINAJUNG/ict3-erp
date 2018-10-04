<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="levelList2" method="get">
<div>
liname : <input type="text" name="liname">
<button>검색</button>
</div>
</form>
	<table border="1">
		<tr>
			<th>linum</th>
			<th>lilevel</th>
			<th>liname</th>
			<th>lidesc</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
			<th>움 데이터가 엄는걸?</th>
			</tr>
		</c:if>
		<c:forEach var="li" items="${list}">
			<tr onclick="window.location='<%=path %>/levelview?linum=${li.linum}'">
				<td>${li.linum }</td>
				<td>${li.lilevel }</td>
				<td>${li.liname }</td>
				<td>${li.lidesc }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%=path %>/url/level:insert" type="button">등록</a>
	
</body>
</html>