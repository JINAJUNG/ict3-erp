<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	//window.onload가(똑같은 이름을 가진) 두개 있으면 후에 작성한 것으로 재정의
	//아래 addEventListener을 사용하면 둘다 작성 순서대로 서버에 올려놓는다.
	//아래처럼 펑션디클레어를 사용해 function을 만들어 놓고 호출도 가능
	//var on = function(){}는 안됨 load되고 난 후에 읽힘
/* 	window.addEventListener('load', onload1);
	window.addEventListener('load', function() {
		alert('새정의');
	})

	function onload1() {
		var libody = document.querySelector('#libody');
		alert(libody);
		alert('나 서버 갓다오는 아이')
	} */
	var AjaxUtil = function(conf){
		var xhr = new XMLHttpRequest();
		var url = conf.url;
		var method = conf.method?conf.method:'GET';
		var param = conf.params;
		
		var success = conf.success?conf.success:function(res){
			alert(res);
		}
		var error = conf.error?conf.error:function(res){
			alert(res);
		}
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=="200"){
					success(xhr.responseText);
				}else{
					error(xhr.responseText);
				}
			}
		}
		xhr.open(method,url);
		if(method!='GET'){
			xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
		}
		this.send = function(){
			xhr.send();
		}
	}
	 window.addEventListener('load',function(){
		var conf = {
				url : '/ict3-erp/levelList',
				success : function(res){
					res = JSON.parse(res);
					var html = '';
					for(var li of res){
						html += '<tr id="lv'+li.linum+'">';
						html += '<td>' + li.linum + '</td>';
						html += '<td><input type="text" id="lilevel'+li.linum+'" value="' + li.lilevel + '"></td>';
						html += '<td><input type="text" id="liname'+li.linum+'" value="' + li.liname + '"></td>';
						html += '<td><input type="text" id="lidesc'+li.linum+'" value="' + li.lidesc + '"></td>';
						html += '<td><button onclick="updateLevelInfo('+li.linum+')">수정</button><button onclick="deleteLevelInfo('+li.linum+')">삭제</button></td>';
						html += '</tr>';
					} 
					document.querySelector('#libody').insertAdjacentHTML('beforeend',html);
				}
		}
		var au = new AjaxUtil(conf);
		au.send();
	});
	</script>
<body>
	<div>
		liname : <input type="text" name="liname">
		<button id="searchbtn">검색</button>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th>linum</th>
				<th>lilevel</th>
				<th>liname</th>
				<th>lidesc</th>
				<th>up/del</th>
			</tr>
		</thead>
		<tbody id="libody">

		</tbody>
	</table>
	<button onclick ="addLevelInfo()">레벨추가</button>
	<script>

	function updateLevelInfo(linum){
		var lilevel = document.querySelector("#lilevel" + linum ).value;
		var liname = document.querySelector("#liname" + linum).value;
		var lidesc = document.querySelector("#lidesc" + linum).value;
		var params = {lilevel:lilevel, liname:liname, lidesc:lidesc, linum:linum};
		params = JSON.stringify(params);
		

		var conf = {
				url : '/ict3-erp/levelList/'+linum,
				method : 'PUT',
				params : params,
				success : function(res){
					alert(res);
				}
		}
		var au = new AjaxUtil(conf);
		au.send();

		alert(lilevel + "," + liname + "," +lidesc);
	}
	
/* 	var del = document.querySelector('#del');
	del.onclick = function(){
		
	} */
	function deleteLevelInfo(linum){
		var conf = {
				url : '/ict3-erp/levelList/'+linum,
				method : 'DELETE',
				success : function(res){
					alert(res);
					location.href='/ict3-erp/url/levelList:list';
				}
		}
		var au = new AjaxUtil(conf);
		au.send();
	}
	
	function addLevelInfo(){
			var html = '<tr>';
			html += '<td> &nbsp;</td>';
			html += '<td><input type="text" id="lilevel" value=""></td>';
			html += '<td><input type="text" id="liname" value=""></td>';
			html += '<td><input type="text" id="lidesc" value=""></td>';
			html += '<td><button onclick="saveLevelInfo()">등록</button></td>';
			html += '</tr>';
		document.querySelector('#libody').insertAdjacentHTML('beforeend',html);
	}
	function saveLevelInfo(){

		var lilevel = document.querySelector("#lilevel").value;
		var liname = document.querySelector("#liname").value;
		var lidesc = document.querySelector("#lidesc").value;
		var params = {lilevel:lilevel, liname:liname, lidesc:lidesc};
		params = JSON.stringify(params);
		

		var conf = {
				url : '/ict3-erp/levelList/',
				method : 'POST',
				params : params,
				success : function(res){
					if(res=='1'){
						alert('저장완료');
						location.href='/ict3-erp/url/levelList:list';
					}
				}
		}
		var au = new AjaxUtil(conf);
		au.send();

		alert(lilevel + "," + liname + "," +lidesc);
	
	}
	/* ------------------------------------------------------------- */
	var searchbtn = document.querySelector('#searchbtn');
	searchbtn.addEventListener('click',function(){
		 var conf = {
					url : '/ict3-erp/levelList/'+document.querySelector('input[name=liname]').value,
					success : function(res){
						res = JSON.parse(res);
						var html = '';
						if(res != null){
							
							html += '<tr>';
							html += '<td>' + res.linum + '</td>';
							html += '<td>' + res.lilevel + '</td>';
							html += '<td>' + res.liname + '</td>';
							html += '<td>' + res.lidesc + '</td>';
							html += '<td><button>수정</button><button>삭제</button></td>';
							html += '</tr>';
						}
						document.querySelector('#libody').innerHTML='';
						document.querySelector('#libody').insertAdjacentHTML('beforeend',html);
					}
			}
		 console.log(document.querySelector('input[name=liname]').value);
			var au = new AjaxUtil(conf);
			au.send();
	 })
	</script>
</body>
</html>