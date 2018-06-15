<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script type="text/javascript">
function openUp(){
	var t=new Date().getTime();
	var url="../../common/uploadone.jsp?ext=&path=ware&id=ff&t="+t;
	$("#ifmUp").attr("src", url);
	$("#diaUp").window("open");
}

var complete=function(response, id){
	var obj=$.parseJSON(response);
	if(obj!=null){
		$("#file").text(obj.oldName);
		$("input[name=fileName]").val(obj.oldName);
		$("input[name=filePath]").val(obj.filePath+obj.newName);
	}
	$("#diaUp").window("close");
}
function check(){
	if($("input[name=fileName]").val()==""){
		alert("请上传申报文件");
		return false;
	}
	$("input[type=submit]").attr("disabled","disabled");
	return true;
}
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
            <td height="26" align="right">名称：</td>
            <td><input name="wareName" value="${ware.wareName}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">文件：</td>
            <td>&nbsp;<span id="file">${ware.fileName}</span>&nbsp;<a href="javascript:openUp();">上传文件</a></td>
          </tr>
        </table>
        <input type="hidden" name="fileName" value="${ware.fileName}" />
        <input type="hidden" name="filePath" value="${ware.filePath}">
        <input type="hidden" name="wareAutoid" value="${ware.wareAutoid}"/>
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