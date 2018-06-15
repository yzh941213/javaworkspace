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
function delmore(){
	var ids=new Array();
	$("input[name=chk]:checked").each(function(index,demo){
		ids.push($(demo).val());
	});
	var autoids=ids.join(",");
	if(ids.length==0){
		alert("请选择要删除的数据！");
		return;
	}
	if(confirm("您确定要删除吗？")){
		$.post("del.do",{autoids:autoids},function(data){
				if(data!="0"){
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
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">仿真教学资源<c:if test="${flowcls ne null}">-${flowcls.fcName}</c:if></span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="2" cellspacing="0">
            <tr>
              <td align="center"><a class="addbtn" href="editflow.do?flowType=soft&fcAutoid=${flowcls.fcAutoid}">新增软件</a></td>              
              <td align="center"><a class="addbtn" href="editres.do?flowType=flash&fcAutoid=${flowcls.fcAutoid}">新增动画</a></td>              
              <td align="center"><a class="addbtn" href="editres.do?flowType=video&fcAutoid=${flowcls.fcAutoid}">新增视频</a></td>              
              <td align="center"><a class="addbtn" href="editres.do?flowType=unity3d&fcAutoid=${flowcls.fcAutoid}">新增3D</a></td>              
              <td align="center"><a class="delbtn" href="javascript:delmore();">删除</a></td>
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
            <th width="5%" height="26"><input type="checkbox" name="chkall" /></th>
            <th width="5%">序号</th>
            <th width="17%">名称</th>
            <th width="9%">类型</th>
            <th width="9%">编号</th>
            <th width="9%">状态</th>
            <th width="15%">公司</th>
            <th width="9%">培训项目数量</th>
            <th width="8%">所属分类</th>
            <th width="7%">编辑</th>
            <th width="7%">查看项目</th>
          </tr>
         <c:forEach items="${list}" var="flow" varStatus="status">
          <tr>
            <td height="26"><input name="chk" type="checkbox" value="${flow.flowAutoid}" /></td>
            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
            <td>${flow.flowName}</td>
            <td>${flow.flowType}</td>
            <td>${flow.itemID}</td>
            <td>${flow.state}</td>
            <td>${flow.companyID}</td>
            <td>${flow.count}</td>
            <td>${flow.fcName}</td>
           <c:choose>
            <c:when test="${flow.flowType eq 'soft'}">
            	<td><a class="edittd" href="editflow.do?flowAutoid=${flow.flowAutoid}">编辑</a></td>
            	<td><a href="${pageContext.request.contextPath}/course/flowinfo.do?flowAutoid=${flow.flowAutoid}" target="_blank">查看</a></td>
            </c:when>
            <c:otherwise>
            	<td><a class="edittd" href="editres.do?flowAutoid=${flow.flowAutoid}">编辑</a></td>
            	<td><a href="${pageContext.request.contextPath}/course/view.do?flowAutoid=${flow.flowAutoid}" target="_blank">查看</a></td>
            </c:otherwise>
            </c:choose>
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