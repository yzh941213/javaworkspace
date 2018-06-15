var action;
var categoryAutoid=0;
$(document).ready(function(){
	$(function(){
		action=QueryString("action");
		categoryAutoid=QueryString("categoryAutoid");
		if(action=="edit"){
			init(categoryAutoid);
		}else{
			$("#parentID").val(categoryAutoid);
		}
	});
});
function init(id){
	var par={categoryAutoid:id};
	$.post("getCategoryByID.do", par, function(category){
		$("form").form("load", category);
		$("#bigimg").attr("src", urlRoot+category.bigpic);//urlRoot是定义在checklogin.js中的全局变量
	},"json");
}
//由index.js调用
var save=function(){
	var category=$("form").serializeObject();
	if(category.cateName==""){
		alert("请输入名称！");
		return;
	}
	var url="create.do"
	if(action=="edit"){
		url="modify.do";
	}
	$.post(url,category,function(result){
		if(result.flag!=undefined){
			alert(result.flag+result.action);
		}else{
			parent.window.saveCateOK(result);//调用course.js的saveCate函数
		}
	},"json");
}
function upimg(id){
	var url="../../common/uploadone.jsp?ext=image&path=image&id="+id;
	$("#ifm").attr("src",url);
	$("#diaUp").window("open");
}
//上传图片完成后由uploadone.jsp调用
var complete=function(response, id){
	var obj=$.parseJSON(response);
	var filePath=obj.filePath+obj.newName;
	if(id=="big"){
		$("#bigimg").attr("src", urlRoot+filePath);
		$("#bigpic").val(filePath);
	}
	$("#diaUp").window("close");
}