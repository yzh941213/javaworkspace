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
	var par={account:$.trim($("input[name=account]").val())}
	if(par.account==""){
		alert("请输入账号名！");
		return false;
	}
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
            <td height="26" align="right">账号：</td>
            <td><input name="account" value="${person.account}" <c:if test="${action eq 'modify.do' }">disabled</c:if> /></td>
          </tr>
          <tr>
            <td height="26" align="right">姓名：</td>
            <td><input name="name" value="${person.name}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">电话：</td>
            <td><input name="telphone" value="${person.telphone}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">角色：</td>
            <td><input type="radio" name="personType" id="admin" value="admin" checked><label for="admin">管理员</label>
            	<input type="radio" name="personType" id="teacher" value="teacher" <c:if test="${person.personType eq 'teacher'}">checked</c:if> /><label for="teacher">教师</label>
            	<input type="radio" name="personType" id="student" value="student" <c:if test="${person.personType eq 'student'}">checked</c:if> /><label for="student">学生</label>
            	</td>
          </tr>
        </table>
        <input type="hidden" name="personAutoid" value="${person.personAutoid}"/>
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