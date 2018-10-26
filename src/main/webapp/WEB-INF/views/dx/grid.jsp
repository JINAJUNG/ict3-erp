<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${skyPath}/dhtmlx.css"/>
<script>
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
/*  */
	var mData=[{id:'delete',text:'delete'},{id:'add',text:'add'}];
	var dxGrid,dxMenu;

	function doInit(){
		dxMenu = new dhtmlXMenuObject();
		dxMenu.setIconsPath('../common/images/');
		dxMenu.renderAsContextMenu();
		dxMenu.attachEvent('onclick',function(mId,type){
			console.log(mId+", "+type);
			
			if(mId=='delete'){
				var rId= dxGrid.getSelectedRowId();
				if(!rId){
					alert('삭제할 로우를 선택해 주세요.');
					return;
				}
				var cIdx = dxGrid.getColIndexByid('linum');
				var linum = dxGrid.cells(rId,cIdx).getValue();
				alert(linum);
			}else if(mId=='add'){
				dhx.ajax.get("/ict3/linum", function(res){
					var data = JSON.parse(res.xmlDoc.responseText);
					var rId = dxGrid.uid();
					dxGrid.addRow(rId,[data],dxGrid.getRowsNum());
					dxGrid.setRowAttribute(rId,'st','new');
					
				});
			}
		});
		dxMenu.loadStruct(mData);
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${skyPath}/imgs/');
		dxGrid.setHeader('번호,레벨,이름,설명');
		dxGrid.setColumnIds('linum,lilevel,liname,lidesc');
		dxGrid.setColTypes('ro,ed,ed,ed');
		dxGrid.enableContextMenu(dxMenu);
		dxGrid.init();
		dhx.ajax.get("/ict3/levelList", function(res){
			res = JSON.parse(res.xmlDoc.responseText);// json 객체에 대한 응답을 변환
			dxGrid.parse(res,'js');
		});
		dxGrid.attachEvent('onEditCell',function(stage,rId,cInd,nValue,oValue){
			if(stage==2){
				if(dxGrid.getRowAttribute(rId,'st')=='new'){
					return true;
				}
				if(nValue!=oValue){
					var rData = dxGrid.getRowData(rId);
					dhx.ajax.put('ict3/LevelList/'+rDatta.linum+'?'+makeParams(rData),function(){
						var data = JSON.parse(res.xmlDoc.responseText);
						alert(data);
						return true;
					})	
				}
			}
		})
	}

	window.addEventListener('load',doInit);
</script>
</head>
<body>
	<div id="dxGrid" style="width:400px;height:300px"></div>

</body>
</html>