<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script type="text/javascript">
function check(){
	if($.trim($("input[name=name]").val())==""){
		alert("请输入名称！");
		$("input[name=name]").focus();
		return false;
	}
	if($.trim($("input[name=url]").val())==""){
		alert("请输入链接地址！");
		$("input[name=url]").focus();
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
            <td><input name="name" value="${friend.name}" style="width:300px"/></td>
          </tr>
          <tr>
            <td height="26" align="right">链接：</td>
            <td><input name="url" value="${friend.url}" style="width:300px"/></td>
          </tr>
        </table>
        <input type="hidden" name="friendAutoid" value="${friend.friendAutoid}"/>
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
</body>
</html>