<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编 辑</title>
<%@ include file="/include/easyui.jsp" %>
<%@ include file="/include/kindeditor.jsp" %>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/scripts/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		var clsName=QueryString("clsName");
		if(clsName!="results" && clsName!="school"){
			$("#trpic").hide();
		}
	});
	$("#attList>li>a").live("click", function(){
		$(this).parent("li").remove();
	});
});

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
	});

function check(){
	if($.trim($("input[name=title]").val())==""){
		alert("请输入标题");
		return false;
	}
	if($.trim($("input[name=date]").val())==""){
		alert("请选择时间");
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
            <td colspan="2"><input name="title" value="${comment.title}" style="width:300px;"/></td>
          </tr>
          <tr>
            <td height="26" width="70" align="right">时间：</td>
            <td colspan="2">
            <c:if test="${action=='create.do' }">
            	<input name="date" value="<fmt:formatDate value='<%=new Date()%>' pattern='yyyy-MM-dd HH:mm:ss'/>" style="width:300px;" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
            </c:if>
             <c:if test="${action!='create.do' }">
             	<input name="date" value="<fmt:formatDate value='${comment.date}' pattern='yyyy-MM-dd HH:mm:ss'/>" style="width:300px;" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
             </c:if>
            </td>
          </tr>
          <tr>
            <td align="right">内容：</td>
            <td width="675"><textarea name="content" id="content">${comment.content}</textarea></td>
          </tr>
        </table>
        <input type="hidden" name="commentsAutoid" value="${comment.commentsAutoid}"/>
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
</body>
</html>