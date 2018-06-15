<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${news.title}</title>
<script type="text/javascript" src="../scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css" type="text/css"/>
</head>
<body>
<div style="width:1120px; min-height:692px; overflow:hidden; margin:0 auto;">
<%@ include file="/pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span><a href="${pageContext.request.contextPath}/">首页</a> &gt; ${news.title}</span></p>
</div>
<!--内容-->
<div class="content" style="width:1040px; min-height:650px; margin:0px auto;padding:10px 40px;;overflow:hidden; background:#fff;">
    <h2 class="h2">${news.title }</h2>
    <p>${news.content }</p>
    <br/>
    <c:if test="${fn:length(list)>0}">
    <div style="float:left;font-weight:bold;">附件：</div>
    <div style="padding-left:30px;">
    	<c:forEach items="${list}" var="attach">
    		<a href="down.do?path=${attach.filePath}">${attach.name}</a><br/>
    	</c:forEach>
    </div>
    </c:if>
    <br/>
</div>
<%@ include file="/pagelet/footer.jsp" %>
</div>
</body>
</html>