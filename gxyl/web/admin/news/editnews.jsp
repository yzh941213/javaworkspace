<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<%@ include file="/include/kindeditor.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		
	});
	$("#attList>li>a").live("click", function(){
		$(this).parent("li").remove();
	});
});

function openUp(id){
	var t=new Date().getTime();
	var url="../../common/uploadone.jsp?ext=image&path=image&id="+id+"&t="+t;
	if(id=="attach"){
		url="../../common/uploadone.jsp?ext=&path=attach&id="+id+"&t="+t;
	}
	$("#ifmUp").attr("src", url);
	$("#diaUp").window("open");
}

var complete=function(response, id){
	var obj=$.parseJSON(response);
	if(obj!=null){
		if(id=="pic"){
			$("#img").attr("src", urlRoot+obj.filePath+obj.newName);
			$("input[name=image]").val(obj.filePath+obj.newName);
		}
		if(id=="attach"){
			var newsAutoid=${news.newsAutoid};
			var att=JSON2.stringify({newsAutoid:newsAutoid,name:obj.oldName,fileName:obj.newName,filePath:obj.filePath+obj.newName,fileSize:obj.fileSize});
			var list="<li id='"+att+"'><span><a href='down.do?path="+obj.filePath+obj.newName+"'>"+obj.oldName+"</a></span>&nbsp;&nbsp;<a href='javascript:;'>删除</a></li>";
			$("#attList").append(list);
		}
	}
	$("#diaUp").window("close");
}

var editor;
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
	    
	    K('#imgmanage').click(function() {
					editor.loadPlugin('filemanager', function() {
						editor.plugin.filemanagerDialog({							
							viewType : 'VIEW',
							dirName : 'image',
							clickFn : function(url, title) {
								$("#img").attr("src", url);
								var _url=url.replace(urlRoot, "");								
								K('#image').val(_url);
								editor.hideDialog();
							}
						});
					});
				});
});

function check(){
	if($.trim($("input[name=title]").val())==""){
		alert("请输入标题");
		return false;
	}
	try{
		var cont=editor.html();
		$("#content").val(cont);
	}catch(e){
	
	}
	var atts=new Array();
	$("#attList>li").each(function(index,demo){
		atts.push($(this).attr("id"));
	});
	
	$("input[name=attachs]").val("["+atts.join(",")+"]");
	$("input[type=submit]").attr("disabled","disabled");
	return true;
}
</script>
</head>
<body>
<form id="form" action="${action}" method="post" onsubmit="return check();">
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
            <th height="26" colspan="3"></th>
          </tr>
         
          <tr>
            <td height="26" width="70" align="right">标题：</td>
            <td colspan="2"><input name="title" value="${news.title}" style="width:300px;"/></td>
          </tr>
          <tr>
            <td height="26" align="right">类别：</td>
            <td colspan="2">
            	<select name="newsClsAutoid">
            		<c:forEach items="${clsList}" var="newsCls">
            		<option value="${newsCls.newsClsAutoid}" <c:if test="${newsCls.newsClsAutoid eq news.newsClsAutoid}">selected</c:if>>${newsCls.name}</option>
            		</c:forEach>
            	</select>
            </td>
          </tr>
          <tr>
            <td height="26" align="right">日期：</td>
            <td colspan="2"><input name="date" value="<fmt:formatDate value="${news.date}" pattern="yyyy-MM-dd"/>" class="Wdate" onFocus="WdatePicker({maxDate:'#F{\'2020-10-01\'}',dateFmt:'yyyy-MM-dd'})"/></td>
          </tr>
          <tr>
            <td align="right">内容：</td>
            <td width="675"><textarea name="content" id="content">${news.content}</textarea></td>
            <td valign="top">
            	<p style="padding-left:10px;"><a href="javascript:openUp('attach')">添加附件</a></p>
            	<ul id="attList">
            		<c:forEach items="${attachList}" var="attach">
            			<li id='{"newsAutoid":${attach.newsAutoid},"name":"${attach.name}","fileName":"${attach.fileName}","filePath":"${attach.filePath}","fileSize":"${attach.fileSize}"}'><span><a href="down.do?path=${attach.filePath}">${attach.name}</a></span>&nbsp;&nbsp;<a href='javascript:;'>删除</a></li>
            		</c:forEach>
            	</ul> 
            	<input name="attachs" type="hidden" value="${news.attachs}"/>           	
            </td>
          </tr>
          <tr>
          	<td align="right">图片：</td>
          	<td colspan="2">
          		<img id="img" src="${pageContext.request.contextPath}${news.image}" height="100" width="150"/>
          		<a href="javascript:openUp('pic');">上传图片</a><input type="hidden" id="image" name="image" value="${news.image}"/>&nbsp;&nbsp;
          		<a href="javascript:;" id="imgmanage">选择图片</a>
          	</td>
          </tr>
        </table>
        <input type="hidden" name="newsAutoid" value="${news.newsAutoid}"/>
        	<br/>
        	<div align="center">
        		<input type="submit" value="保存" />
        	</div>
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