<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/eltag" prefix="el" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/system.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		
	});
});
function check(){
	if($("textarea[name=content]").val()==""){
		alert("请输入回复内容！");
		return false;
	}
	$("input[type=submit]").attr("disabled","disabled");
	return true;
}
</script>
<style type="text/css">
.tabsty{border-top:1px solid #ccc;border-right:1px solid #ccc;}
.tabsty tr td{border-bottom:1px solid #ccc;border-left:1px solid #ccc;padding-left:4px;}
</style>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>在线答疑</span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; margin:0 auto;">
	<div class="left">
    	<ul>
    		
    		<li class="current"><a href="${pageContext.request.contextPath}/comments/index.do?page=1">在线答疑</a></li>
    		
    	</ul>
    </div>
	<div class="right">
    	<h2 class="h2"></h2>
    	<table class="tabsty" width="100%" border="0" cellspacing="0" cellpadding="0">
    		<tr>
    			<td height="25">${comments.title}</td>
    			<td width="80" align="center">${comments.person.account}</td>
    			<td width="130" align="center"><fmt:formatDate value="${comments.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    		</tr>
    		<tr>
    			<td colspan="3" valign="top" height="25">${comments.content}</td>
    		</tr>
    	</table>
    	
    	<c:forEach var="reply" items="${list}">
    	<table border="0" width="100%" style="background:#ddd;margin-top:10px;">
    		<tr>
    			<td height="40" width="150" valign="top" align="center">
    				${reply.person.account}
    				<br/>
    				<fmt:formatDate value="${comments.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
    			</td>
    			<td>回复：${reply.content}</td>
    		
    		</tr>
    		</table>
    		</c:forEach>
    	
    	<p style="height:25px; line-height:25px; text-align:center; margin:0 auto;color:#000;">
    	${strPager }
    	</p>
    	<br/>
    	<form action="addreply.do" method="post" onsubmit="return check();">	
    	<div>
    		<table width="100%">
    			<tr>
    				<td width="80" align="center" valign="top">${person.account}</td>
    				<td>
    					<textarea rows="10" cols="80" name="content"></textarea>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center"><input type="submit" value="确 定"/></td>
    			</tr>
    		</table>
    		<input type="hidden" name="commentsAutoid" value="${comments.commentsAutoid}">
    	</div>
    	</form>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>