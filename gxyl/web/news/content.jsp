<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${news.title}</title>
<script type="text/javascript" src="../scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css" type="text/css"/>
</head>
<body>
<%@ include file="/pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span><a href="news.do?page=1&clsName=${news.newsCls.clsName}">${news.newsCls.name}</a> &gt; ${news.title}</span></p>
</div>
<!--内容-->
<div style="width:1120px; min-height:650px; margin:0px auto;overflow:hidden;">
<div class="left">
	<div class="cai">
		<div class="title"><span><b> </b></span> <b>申报材料</b></div>
		<div class="shen">
			<ul class="marl">
				<li><a href="${pageContext.request.contextPath}/ware/index.do?type=book">申报书</a></li>
				<li><a href="${pageContext.request.contextPath}/ware/index.do?type=material">支撑材料</a></li>
				<li><a href="${pageContext.request.contextPath}/ware/index.do?type=video">视频介绍</a></li>
			</ul>
		</div>
	</div>	
	<div class="cen">
		<div class="title"><span><b><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=0">more</a></b></span> <b>仿真实验教学资源</b></div>
		<div class="con">
			<c:forEach var="flow" items="${flowList}">
            <c:choose>
            <c:when test="${flow.flowType eq 'soft'}">
			<div class="c_dv">
				<div class="c_left"><a href="${pageContext.request.contextPath}/course/flowinfo.do?flowAutoid=${flow.flowAutoid}"><img src="${pageContext.request.contextPath}${flow.imageUrl}" width="100" height="80"/></a></div>
				<div class="c_right">
					<p><font><a href="${pageContext.request.contextPath}/course/flowinfo.do?flowAutoid=${flow.flowAutoid}">${flow.flowName}</a></font></p>
					<p><a href="${pageContext.request.contextPath }/course/index.do?page=1&fcAutoid=${flow.fcAutoid }">${flow.flowcls.fcName}</a></p>
				</div>
			</div>
			 </c:when>
			  	<c:otherwise>
			<div class="c_dv">
				<div class="c_left"><a href="${pageContext.request.contextPath}/course/view.do?flowAutoid=${flow.flowAutoid}"><img src="${pageContext.request.contextPath}${flow.imageUrl}" width="100" height="80"/></a></div>
				<div class="c_right">
					<p><font><a href="${pageContext.request.contextPath}/course/view.do?flowAutoid=${flow.flowAutoid}">${flow.flowName}</a></font></p>
					<p><a href="${pageContext.request.contextPath }/course/index.do?page=1&fcAutoid=${flow.fcAutoid }">${flow.flowcls.fcName}</a></p>
				</div>
			</div>
			</c:otherwise>
			</c:choose>
            </c:forEach>
		</div>
	</div>
</div>
<div class="right">
	<div class="nei">
    <h2 class="h2">${news.title }</h2>
    <br/>
    <center>发布者：${news.person.account} <fmt:formatDate value="${news.date}" pattern="yyyy-MM-dd"/></center>
    <br/>
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
</div>
</div>
<%@ include file="/pagelet/footer.jsp" %>
</body>
</html>