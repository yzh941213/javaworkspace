<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗？")){
		$.post("del.do", {menuAutoid:id}, function(data){
			if(data=="1"){
				alert("删除成功！");
				location.reload();
			}else{
				alert("删除失败！");
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
        <td width="921" background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">菜单</span></td>
        <td width="422" background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center"><a class="addbtn" href="addedit.do">新增</a></td>              
              <td align="center"></td>
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
            <th width="6%" height="26"><input type="checkbox" name="checkbox62" value="checkbox" /></th>
            <th width="6%">序号</th>
            <th width="10%">标题</th>
            <th width="10%">名称</th>
            <th width="20%">链接地址</th>
            <th width="20%">导航地址</th>
            <th width="7%">前台菜单</th>
            <th width="7%">排序</th>
            <th width="7%">编辑</th>
            <th width="7%">删除</th>
          </tr>
         <c:forEach items="${list}" var="menu" varStatus="status">
          <tr>
            <td height="26"><input name="chkall" type="checkbox" value="${menu.menuAutoid}" /></td>
            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
            <td>${menu.title}</td>
            <td>${menu.model}</td>
            <td>${menu.navigateUrl}</td>
            <td>${menu.webUrl}</td>
            <td>${menu.isWeb}</td>
            <td>${menu.sortIndex}</td>
            <td><a class="edittd" href="addedit.do?menuAutoid=${menu.menuAutoid}">编辑</a></td>
            <td><a class="deltd" href="javascript:del(${menu.menuAutoid});">删除</a></td>
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