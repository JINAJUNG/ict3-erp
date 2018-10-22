<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#lay{
		width:100%;
		height:100%;
		margin:auto 0px;
	}
</style>
<script>
	window.addEventListener('load',doInti);
	function doInti(){
		new dhtmlXLayoutObject('lay','3L');
	}
</script>
</head>
<body>
<div id="lay"></div>
</body>
</html>