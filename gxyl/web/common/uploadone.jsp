<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String path=request.getParameter("path");//保存文件的文件夹，是位于/uploads下的文件夹 
	String ext=request.getParameter("ext");//文件类型。
	String fileExt="";//"*.jpg;*.gif;*.png;*.bmp";
	String fileDesc="";//"*.jpg;*.gif;*.png;*.bmp图片格式文件";
	if(ext.equals("exe")){
		fileExt="*.exe;*.msi;*.zip;*.rar";
		fileDesc="*.exe;*.msi;*.zip;*.rar";
	}
	if(ext.equals("zip")){
		fileExt="*.exe;*.msi;*.zip;*.rar";
		fileDesc="*.exe;*.msi;*.zip;*.rar";
	}
	if(ext.equals("video")){
		fileExt="*.flv;*.mp4;*.wmv";
		fileDesc="*.flv;*.mp4;*.wmv视频文件";
	}
	if(ext.equals("flash")){
		fileExt="*.swf";
		fileDesc="*.swf文件";
	}
	if(ext.equals("unity3d")){
		fileExt="*.unity3d";
		fileDesc="*.unity3d文件";
	}
	if(ext.equals("image")){
		fileExt="*.jpg;*.gif;*.png;*.bmp";
		fileDesc="*.jpg;*.gif;*.png;*.bmp图片格式文件";
	}
	if(ext.equals("ini")){
		fileExt="*.ini";
		fileDesc="ini配置文件";
	}
	if(ext.equals("xls")){
		fileExt="*.xls;*.xlsx";
		fileDesc="excel电子表格";
	}
	if(ext.equals("doc")){
		fileExt="*.doc;*.docx;*.pdf";
		fileDesc="*.doc;*.docx;*.pdf文档";
	}
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<%@ include file="../include/uploadify.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	$("#uploadify").uploadify({
        'uploader': '../scripts/uploadify/uploadify.swf',
        'script': '../include/uploadFile.jsp',
        'cancelImg': '../scripts/uploadify/cancel.png',
        'folder': 'file',
        'queueID': 'fileQueue',
        'sizeLimit': '10737418240', //文件大小限制，单位为字节
        'buttonImg': '../scripts/uploadify/browse.png', //浏览按钮的图片
        'fileExt': '<%=fileExt%>',
        'fileDesc': '<%=fileDesc%>',
        'auto': true,
        'multi': false,
        'scriptData': {'fileFolder':'<%=path%>'},//这个参数用于传递用户自己的参数，此时'method' 必须设置为GET, 后台可以用request.getParameter('name')获取名字的值
        'method': 'GET',
        'onError': function (e, queueId, fileObj, errorObj) { alert("错误消息：" + errorObj.info + "\r\n" + "错误类型：" + errorObj.type); },
        'onComplete': function (e, queueId, fileObj, response, data) {
           parent.window.complete(response, QueryString("id"));
        }
    });
});
</script>
<style>
body{margin:0px;}
</style>
</head>
<body>
	<div id="fileQueue" style="width:380px;height:60px;"></div>
    <input type="file" name="uploadify" id="uploadify" />
</body>
</html>