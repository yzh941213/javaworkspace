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
	var second=2000;
	$(function(){
		setInterval("back()",second);
	});
});
function back(){
	var msg="${result}";
	if(msg=="right"){
		window.location.href="${url}";
	}
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
    	<p style="height:25px; line-height:25px; text-align:center; margin:0 auto;color:#000;">
    	${message} <a href="${url}">返回</a>
    	</p>
    	<br/>
    	
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>