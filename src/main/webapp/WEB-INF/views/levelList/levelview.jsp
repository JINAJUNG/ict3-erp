<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="lev" value="${lev }" ></c:set>
	<table border="1">
		<tr>
			<th>linum</th>
			<td>${lev.linum }</td>
		</tr>
		<tr>
			<th>lilevel</th>
			<td>${lev.lilevel }</td>
		</tr>
		<tr>
			<th>liname</th>
			<td>${lev.liname }</td>
		</tr>
		<tr>
			<th>lidesc</th>
			<td>${lev.lidesc }</td>
		</tr>
	</table>
	<button>수정</button>
	<button>삭제</button>
</body>
</html>