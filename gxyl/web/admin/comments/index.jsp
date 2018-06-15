<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					location.href="index.do?page=1";
				}
			});
		}
	}
	function getComment(){
		var title = $.trim($("#checkTitle").val());
		location.href="getCommentByTitle.do?page=1&title="+title;
	}
</script>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">交流答疑</span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="0" cellspacing="2">
            <tr>
              <td align="center"><a class="addbtn" href="edit.do?commentsAutoid=0">新增</a></td>              
              <td align="center"><a class="delbtn" href="javascript:delall();">删除</a></td>
              <td width="230" align="left"><input id="checkTitle" type="text"/><a class="editbtn" href="javascript:getComment()">查询</a></td>
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
            <th width="24%">标题</th>
            <th width="10%">作者</th>
            <th width="10%">时间</th>
            <th width="7%">回复数量</th>
            <th width="7%">编辑</th>
            <th width="7%">删除</th>
            <th width="7%">查看</th>
          </tr>
         <c:forEach items="${commentsList}" var="comment" varStatus="status">
	          <tr>
	            <td height="26"><input name="chk" type="checkbox" value="${comment.commentsAutoid}" /></td>
	            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
	            <td>${comment.title}</td>
	            <td>${comment.person.name}</td>
	            <td><fmt:formatDate value="${comment.date}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
	            <td>${comment.count}</td>
	            <td><a class="edittd" href="edit.do?commentsAutoid=${comment.commentsAutoid}">编辑</a></td>
	            <td><a class="deltd" href="javascript:del(${comment.commentsAutoid});">删除</a></td>
	            <td><a href="check.do?page=1&commentsAutoid=${comment.commentsAutoid}">查看</a></td>
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