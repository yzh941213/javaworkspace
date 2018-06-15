<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${newsCls.name}</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/system.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		
	});
});
</script>
<style>
.mm{float:left;width:150px;min-height:300px;padding-top:20px;border:0px solid blue;}
.mm ul{border:1px solid blue;}
.mm ul li{line-height:27px;border:1px solid blue;margin:2px;padding-left:3px;padding-right:3px;}
.tt{margin-left:160px;padding-top:20px;min-height:300px;}
.curr{background-color:#00767d;}
.curr a{color:#fff;}
</style>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span></span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; margin:0 auto;">
	<div class="left">
    	<ul>    		
    		<li class="current"></li>
    		
    	</ul>
    </div>
	<div class="right">
    	<div class="mm">
    		<ul>
    			<li class="curr"><a href="#">无机化学研究所</a></li>
    			<li><a href="#">有机化学科学研究所</a></li>
    			<li><a href="#">化学教育科学研究所</a></li>
    		</ul>
    	</div>
    	<div class="tt">
    		这里是内容
    	</div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>