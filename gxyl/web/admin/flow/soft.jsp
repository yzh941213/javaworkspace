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
function remove(){
	var arrs=new Array();
	$("input[name=chk]:checked").each(function(index, demo){
		arrs.push($(demo).val());
	});
	var ids=arrs.join(",");
	if(arrs.length==0){
		alert("请勾选要删除的数据！");
		return;
	}
	del(ids);
}
function del(ids){
	if(confirm("您确定要删除吗？")){
		$.post("delete.do",{autoids:ids},function(result){
			if(result!="" && result!="0"){
				alert("删除成功！");
				window.location.href="soft.do?page=1&clsID="+QueryString("clsID");
			}
		});
	}
}
</script>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">仿真教学资源-<c:if test="${clsID eq '1'}">理论计算</c:if><c:if test="${clsID eq '2'}">高危高害</c:if></span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="0" cellspacing="2">
            <tr>
              <td align="center"><a class="addbtn" href="editsoft.do?clsID=${clsID}">新增</a></td>              
              <td align="center"><a class="delbtn" href="javascript:remove();">删除</a></td>
              <td width="230" align="left"><input><a class="editbtn" href="#">查询</a></td>
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
            <th width="6%" height="26"><input type="checkbox" name="chkall" value="checkbox" /></th>
            <th width="8%">序号</th>
            <th width="24%">软件名称</th>
            <th width="10%">文件名</th>
            <th width="28%">路径</th>
            <th width="10%">大小</th>
            <th width="7%">编辑</th>
            <th width="7%">删除</th>
          </tr>
         <c:forEach items="${list}" var="soft" varStatus="status">
          <tr>
            <td height="26"><input name="chk" type="checkbox" value="${soft.softAutoid }" /></td>
            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
            <td>${soft.softName }</td>
            <td>${soft.fileName }</td>
            <td>${soft.filePath }</td>
            <td>${soft.fileSize }</td>
            <td><a class="edittd" href="editsoft.do?softAutoid=${soft.softAutoid}">编辑</a></td>
            <td><a class="deltd" href="javascript:del(${soft.softAutoid })">删除</a></td>
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
</body>
</html>