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
	if($.trim($("input[name=title]").val())==""){
		alert("请输入标题！");
		$("input[name=title]").focus();
		return false;
	}
	var model=$.trim($("input[name=model]").val());
	var menuAutoid=$("input[name=menuAutoid]").val();
	var obj={model:model, menuAutoid:menuAutoid};
	var result=SendAction("hasModel.do", null, obj);
	if(result=="1"){
		setRedText("md","****");
		alert("名称已存在，请更换一个");
		$("input[name=model]").select();
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
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">编辑</span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
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
            <td width="228" height="26" align="right">标题：</td>
            <td><input name="title" value="${menu.title}" style="width:300px"/></td>
          </tr>
          <tr>
            <td height="26" align="right">名称：</td>
            <td><input name="model" value="${menu.model}" style="width:300px"/><span id="md"></span></td>
          </tr>
          <tr>
            <td height="26" align="right">链接：</td>
            <td><input name="navigateUrl" value="${menu.navigateUrl}" style="width:300px"/></td>
          </tr>
          <tr>
            <td height="26" align="right">导航：</td>
            <td><input name="webUrl" value="${menu.webUrl}" style="width:300px"/></td>
          </tr>
          <tr>
            <td height="26" align="right">前台菜单：</td>
            <td><input name="isWeb" id="isWeb" type="checkbox" value="1" <c:if test="${menu.isWeb eq 1}">checked</c:if>/><label for="isWeb">是</label></td>
          </tr>
        </table>
        <input type="hidden" name="menuAutoid" value="${menu.menuAutoid}"/>
        <input type="hidden" name="parentID" value="${menu.parentID}"/>
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