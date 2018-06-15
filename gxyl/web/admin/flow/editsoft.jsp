<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<%@ include file="/include/kindeditor.jsp" %>
<script type="text/javascript">
function openUp(){
	var t=new Date().getTime();
	var url="../../common/uploadone.jsp?ext=zip&path=file&id=&t="+t;
	$("#ifmUp").attr("src", url);
	$("#diaUp").window("open");
}

var complete=function(response, id){
	var obj=$.parseJSON(response);
	if(obj!=null){
		//$("input[name=softName]").val(obj.oldName);
		$("input[name=softName]").focus();
		$("#spName").text(obj.oldName);
		$("input[name=fileName").val(obj.oldName);
		$("#spPath").text(obj.filePath+obj.newName);
		$("input[name=filePath]").val(obj.filePath+obj.newName);
		$("#spSize").text(obj.fileSize);
		$("input[name=fileSize]").val(obj.fileSize);
		$("#dwn").attr("href", urlRoot+obj.filePath+obj.newName);
		$("#dwn").show();
		$("#diaUp").window("close");
	}else{
		alert("上传失败！");
	}
	
}
function check(){
	if($("input[name=fileName]").val()==""){
		alert("请添加软件！");
		return false;
	}
	if($.trim($("input[name=softName]").val())==""){
		alert("请填写软件名称！");
		return false;
	}
	$("input[type=submit]").attr("disabled","disabled");
	return true;
}
var editor;
/*
KindEditor.ready(function (K) {
	      editor = K.create('#content', {
	    	 minWidth:'310px',width:'675px',height:'250px',
	    	items: ['source', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', '|', 
	    	        'subscript', 'superscript', 'fontname', 'fontsize', 'forecolor', 'hilitecolor', '|', 
	    	        'bold', 'italic', 'underline', '|', 'insertorderedlist', 'preview', 'fullscreen', '|', 
	    	        'cut', 'copy', 'paste', '|', 'image','lineheight','table', 'link'],
	        resizeType:0,
	        cssPath: '../../kindeditor-4.1.10/plugins/code/prettify.css',
	        uploadJson: '../../kindeditor-4.1.10/jsp/upload_json.jsp',
	        fileManagerJson: '../../kindeditor-4.1.10/jsp/file_manager_json.jsp',
	        allowFileManager: true,
	        afterCreate: function () {
	    	    editor=this;
	            var self = this;
	            K.ctrl(document, 13, function () {
	                self.sync();                
	            });
	            K.ctrl(self.edit.doc, 13, function () {
	                self.sync();               
	            });
	        }
	    });
	    prettyPrint();
	});
	*/
</script>
</head>
<body>
<form action="${action}" method="post" onsubmit="return check();">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td width="1021" background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">编辑</span></td>
        <td width="322" background="${pageContext.request.contextPath}/themes/tab_05.gif">
        	<div style="float:right;margin-right:20px;"><a href="javascript:history.back();">返回</a></div>
        </td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
          <table width="99%" class="gridedit" border="0" align="center" cellpadding="0" cellspacing="1">
          <tr>
            <th height="26" colspan="2"></th>
          </tr>
         <tr>
         	<td height="26" align="right">分类：</td>
         	<td><select id="clsID" name="clsID">
         			<option value="1" <c:if test="${soft.clsID eq '1'}">selected</c:if>>理论计算</option>
         			<option value="2" <c:if test="${soft.clsID eq '2'}">selected</c:if>>高危高害</option>
         		</select>&nbsp;
         		<input type="button" value="上传文件" onclick="openUp()">
         	</td>
         </tr>
          <tr>
            <td height="26" align="right">软件名称：</td>
            <td><input name="softName" value="${soft.softName}"/ style="width:300px;"></td>
          </tr>
          <tr>
            <td height="26" align="right">文件名：</td>
            <td><span id="spName">${soft.fileName}</span>&nbsp;&nbsp;<a id="dwn" href="${pageContext.request.contextPath}${soft.filePath}" <c:if test="${action eq 'create.do'}">style="display:none;"</c:if>>下载</a><input type="hidden" name="fileName" value="${soft.fileName}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">路径：</td>
            <td><span id="spPath">${soft.filePath }</span><input type="hidden" name="filePath" value="${soft.filePath}"/></td>
          </tr>
          <tr>
          	<td height="26" align="right">大小：</td>
          	<td><span id="spSize">${soft.fileSize}</span><input type="hidden" name="fileSize" value="${soft.fileSize}" /></td>
          </tr>
        </table>
        
        <input type="hidden" name="softAutoid" value="${soft.softAutoid}"/>
        	<br/>
        	<div align="center"><input type="submit" value="保存"/></div>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/themes/tab_20.gif" width="15" height="29" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_21.gif" align="center">
          &nbsp;</td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<div id="diaUp" class="easyui-dialog" data-options="title:'上传文件',closed:true,width:380,height:140">
	<iframe id="ifmUp" frameborder="0" scrolling="no" style="width:100%;height:100%"></iframe>
</div>
</body>
</html>