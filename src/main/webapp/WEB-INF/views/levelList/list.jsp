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
		var param = conf.param;
		
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
		this.send = function(){
			xhr.send();
		}
	}
	 window.addEventListener('load',function(){
		var conf = {
				url : '/ict3/levelList',
				success : function(res){
					res = JSON.parse(res);
					var html = '';
					for(var li of res){
						html += '<tr>';
						html += '<td>' + li.linum + '</td>';
						html += '<td>' + li.lilevel + '</td>';
						html += '<td>' + li.liname + '</td>';
						html += '<td>' + li.lidesc + '</td>';
						html += '<td><button>수정</button><button>삭제</button></td>';
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
	<script>
	var searchbtn = document.querySelector('#searchbtn');
	searchbtn.addEventListener('click',function(){
		 var conf = {
					url : '/ict3/levelList/'+document.querySelector('input[name=liname]').value,
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