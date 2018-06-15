<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${newsCls.name }</title>
<script type="text/javascript" src="../scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/news.css" type="text/css"/>
</head>
<body>
<%@ include file="/pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>${newsCls.name }</span></p>
</div>
<!--内容-->
<div style="width:1120px; margin:0 auto; min-height:650px;">
<div class="left">
	<div class="cai">
		<div class="title"><span><b></b></span> <b>申报材料</b></div>
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
    	<c:forEach items="${list}" var="news">
    	<p>
    		<span><fmt:formatDate value="${news.date}" pattern="yyyy-MM-dd"/></span>
    		<a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${news.newsAutoid}">${news.title}</a>
    	</p>
    </c:forEach>
    <div class="page">${strPager}</div>
    </div>
</div>
   
</div>
</body>
<%@ include file="/pagelet/footer.jsp" %>
</html>