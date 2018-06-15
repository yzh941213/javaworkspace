<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<%@ include file="/include/kindeditor.jsp" %>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/scripts/datepicker/WdatePicker.js"></script>
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
			$.post("deleteReply.do",{autoids: id},function(data){
				if(data!="0"){
					alert("删除成功！");
					location.href="check.do?page=1&commentsAutoid=${comment.commentsAutoid}";
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
              <td align="center"></td>              
              <td align="center"></td>
              <td width="230" align="right"><a href="javascript:history.back();">返回</a></td>
            </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
  	<td>
  		<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        	<table width="99%" class="grid" border="0" align="center" cellpadding="0" cellspacing="1">
          	<tr>
          		<td height="26" style="text-align:left;padding-left:10px;">${comment.title }</td>
          		<td width="80">${comment.person.name }</td>
          		<td width="100"><fmt:formatDate value="${comment.date }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
          	</tr>
          	<tr>
          		<td colspan="3" style="min-height:26px;text-align:left;padding-left:10px;">${comment.content }</td>
          	</tr>
          	</table>
          	<br/>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
  	</td>
  </tr>
  
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
          <table width="99%" class="grid" border="0" align="center" cellpadding="0" cellspacing="1">
          <c:forEach items="${replyList }" var="list">
	          <tr>
	            <td height="26" width="30">${(pager.pageindex-1)*pager.pagesize+status.count}</td>
	            <td width="80">${list.person.name }</td>
	            <td width="200"><fmt:formatDate value="${list.date }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
	            <td width="80"><a href="javascript:del(${list.replyAutoid });">删除</a></td>
	            <td width="80"><a href="editReply.do?replyAutoid=${list.replyAutoid }">编辑</a></td>
	            <td>&nbsp;</td>
	          </tr>
	          <tr>
	          	<td colspan="6" style="min-height:26px;text-align:left;padding-left:10px;">${list.content }</td>
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

<br/>
<form action="addReply.do" method="post">
 <table width="99%" class="gridedit" border="0" align="center" cellpadding="0" cellspacing="1">
          <tr>
            <th height="26" colspan="2"></th>
          </tr>
          <tr>
            <td height="26" align="right">回复时间：</td>
            <td><input name="date" value="<fmt:formatDate value='<%=new Date() %>' pattern='yyyy-MM-dd HH:mm:ss'/>" style="width:300px;" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
          </tr>
          <tr>
            <td height="26" align="right">回复内容：</td>
            <td><textarea rows="8" cols="80" name="content"></textarea></td>
          </tr>
          
        </table>
        <input type="hidden" name="commentsAutoid" value="${comment.commentsAutoid }">
        	<br/>
        	<div align="center"><input type="submit" value="保存"/></div>
</form>
<br/>

</body>
</html>