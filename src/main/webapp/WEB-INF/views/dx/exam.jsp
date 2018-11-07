<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${skyPath}/dhtmlx.css"/>
<script>
	var dxGrid;

	function doInit(){
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${skyPath}/imgs/');
		dxGrid.setHeader('번호,레벨,이름,설명');
		dxGrid.setColumnIds('linum,lilevel,liname,lidesc');
		dxGrid.setColSorting("number,str,str,str"); 
		dxGrid.setColTypes('ro,ed,ed,ed');
		dxGrid.init();
		dhx.ajax.get("/ict3/levelList", function(res){
			res = JSON.parse(res.xmlDoc.responseText);// json 객체에 대한 응답을 변환
			dxGrid.parse(res,'js');
		});
	}
	window.addEventListener('load',doInit);
</script>
</head>
<body>
	<div id="dxGrid" style="width:400px;height:300px"></div>

</body>
</html>