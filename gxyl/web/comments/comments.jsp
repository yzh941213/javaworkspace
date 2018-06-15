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
	if($("input[name=title]").val()==""){
		alert("请输入标题！");
		return false;
	}
	if($("textarea[name=content]").val()==""){
		alert("请输入内容！");
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
    	<form action="add.do" method="post" onsubmit="return check();">	
    	<div>
    		<table width="100%">
    			<tr>
    				<td width="80" align="center" valign="top">${person.account}</td>
    				<td>
    					<input name="title" type="text" style="width:300px;">
    				</td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><textarea rows="10" cols="80" name="content"></textarea></td>
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