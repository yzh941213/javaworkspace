<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){});
	
	$("input[name=chkall]").click(function(){
		$("input[name=chk]").prop("checked",$(this).prop("checked"));
	});
});

function delall(){
	var ids=new Array();
	$("input[name=chk]:checked").each(function(index,demo){
		ids.push($(demo).val());
	});
	var autoids=ids.join(",");
	del(autoids);
}
	function del(id){
		if(confirm("您确定要删除吗？")){
			$.post("delete.do",{autoids: id},function(data){
				if(data!="0"){
					alert("删除成功！");
					location.href="person.do?page=1&personType=";
				}
			});
		}
	}
var autoids="";
function openPwd(){
	var ids=new Array();
	$("input[name=chk]:checked").each(function(index,demo){
		ids.push($(demo).val());
	});
	autoids=ids.join(",");
	if(ids.length==0){
		alert("请勾选要修改密码的账号");
		return;
	}
	$("#diaWin").window("open");
	$("#pwd1").empty();
	$("#pwd2").empty();
}
function savePwd(){
	if($.trim($("#pwd1").val())==""){
		alert("请输入密码");
		return;
	}
	if($.trim($("#pwd1").val())!=$.trim($("#pwd2").val())){
		alert("两次密码不一致");
		return;
	}
	$.post("setPassword.do", {autoids: autoids, password:$("#pwd1").val()}, function(data){
		if(data=="1"){
			alert("修改成功！");
			$("#diaWin").window("close");
		}else{
			alert("修改失败！");
		}
	});
}
</script>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">用户列表</span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="0" cellspacing="2">
            <tr>
              <td align="center"><a class="addbtn" href="add.do">新增</a></td>              
              <td align="center"><a class="delbtn" href="javascript:delall();">删除</a></td>
              <td align="center"><a  href="javascript:openPwd();">修改密码</a></td>
              <td align="left"><input><a class="editbtn" href="#">查询</a></td>
            </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
          <table width="99%" class="grid" border="0" align="center" cellpadding="0" cellspacing="1">
          <tr>
            <th width="6%" height="26"><input type="checkbox" name="chkall" /></th>
            <th width="8%">序号</th>
            <th width="24%">姓名</th>
            <th width="10%">账号</th>
            <th width="14%">电话</th>
            <th width="24%">角色</th>
            <th width="7%">编辑</th>
            <th width="7%">删除</th>
          </tr>
         <c:forEach items="${list}" var="person" varStatus="status">
          <tr>
            <td height="26"><input name="chk" type="checkbox" value="${person.personAutoid}" /></td>
            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
            <td>${person.name}</td>
            <td>${person.account}</td>
            <td>${person.telphone}</td>
            <td>${person.personType}</td>
            <td><a class="edittd" href="edit.do?personAutoid=${person.personAutoid}">编辑</a></td>
            <td><a class="deltd" href="javascript:del(${person.personAutoid});">删除</a></td>
          </tr>
         </c:forEach>
          
        </table>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/themes/tab_20.gif" width="15" height="29" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_21.gif">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"><span>共${pager.count}条纪录，当前第${pager.pageindex}/${pager.total}页，每页${pager.pagesize}条纪录</span></td>
            <td width="75%" valign="top" align="right">
              <table width="352" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle"><a href="${pager.firstPage}"><img src="${pageContext.request.contextPath}/themes/first.gif" border="0"/></a></td>
                  <td width="50" valign="middle"><a href="${pager.prevPage }"><img src="${pageContext.request.contextPath}/themes/back.gif" border="0" /></a></td>
                  <td width="54" valign="middle"><a href="${pager.nextPage }"><img src="${pageContext.request.contextPath}/themes/next.gif" border="0" /></a></td>
                  <td width="49" valign="middle"><a href="${pager.lastPage }"><img src="${pageContext.request.contextPath}/themes/last.gif" border="0" /></a></td>
                  <td width="59" valign="middle">转到第</td>
                  <td width="55" valign="middle">${pager.dropDownList}</td>
                  <td width="23" valign="middle">页</td>
                </tr>
              </table>
              ${pager.script}
            </td>
          </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
<div id="diaWin" class="easyui-dialog" data-options="title:'修改密码',closed:true,width:380,height:140,buttons:'#btns'">
	<table>
		<tr>
			<td>密码：</td>
			<td><input type="password" id="pwd1"/></td>
		</tr>
		<tr>
			<td>重复输入：</td>
			<td><input type="password" id="pwd2"/></td>
		</tr>
	</table>
</div>
<div id="btns"><a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="savePwd();">确定</a></div>
</body>
</html>