<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/eltag" prefix="el" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<c:if test="${clsID eq '1'}">理论计算</c:if>
	<c:if test="${clsID eq '2'}">高危高害</c:if>
</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/system.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		
	});
});
</script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span><c:if test="${clsID eq '1'}">理论计算</c:if>
	<c:if test="${clsID eq '2'}">高危高害</c:if></span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; margin:0 auto;">
	<div class="left">
    	<ul>
    		<c:forEach var="flowcls" items="${flowclsList}">
    			<li id="${flowcls.fcAutoid}"><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=${flowcls.fcAutoid}">${flowcls.fcName}</a></li>
    		</c:forEach>
    		<li <c:if test="${clsID eq '1'}">class="current"</c:if>> <a href="${pageContext.request.contextPath}/course/soft.do?page=1&clsID=1">理论计算</a></li>
          	<li <c:if test="${clsID eq '2'}">class="current"</c:if>> <a href="${pageContext.request.contextPath}/course/soft.do?page=1&clsID=2">高危高害</a></li>
    	</ul>
    </div>
	<div class="right">
    	<h2 class="h2"></h2>
    	<table border="0" width="100%">
    	<c:forEach var="soft" items="${softList}">
    		<tr>
    			<td height="25" width="40%">${soft.softName}</td>
    			<td height="25" width="10%">${soft.fileSize} kb</td>
    			<td height="25" align="left"><a href="${pageContext.request.contextPath}${soft.filePath}">下载</a></td>
    		</tr>
    		<tr>
    			<td colspan="3" valign="top" style="border-bottom:1px solid #ccc;"></td>
    		</tr>
    		</c:forEach>
    	</table>
    	<p style="height:25px; line-height:25px; text-align:center; margin:0 auto;color:#000;">
    	${strPager }
    	</p>    	
    	
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>