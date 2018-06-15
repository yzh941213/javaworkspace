<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/eltag" prefix="el" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${flowcls.fcName}</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/course.css" type="text/css"/>
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
	<p class="current">当前位置 &gt; <a href="${pageContext.request.contextPath }/course/index.do?page=1&fcAutoid=0">仿真教学资源</a> 
	<c:if test="${fcAutoid ne 0}"> &gt; </c:if>
	<span>${flowcls.fcName}</span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; margin:0 auto;min-height:650px;overflow:hidden;">
<div class="left">
	<div class="cai">
		<div class="title"><span><b><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=0">more</a></b></span> <b>仿真实验教学资源</b></div>
		<div class="shen">
			<ul class="ziyuan">
				<c:forEach var="flowcls" items="${flowclsList}">
    			<li id="${flowcls.fcAutoid}"><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=${flowcls.fcAutoid}">${flowcls.fcName}</a></li>
    		</c:forEach>
			</ul>
		</div>
	</div>
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
	<div class="cai">
		<div class="title"><span><b></b></span> <b>师资队伍</b></div>
		<div class="shen">
			<ul class="ziyuan">
				<c:forEach items="${newsClsList }" var="newsCls">
            	<li><a href="${pageContext.request.contextPath}/center/index.do?newsClsAutoid=${newsCls.newsClsAutoid}&clsName=${newsCls.clsName}">${newsCls.name }</a></li>
            	</c:forEach>
			</ul>	
		</div>
	</div>
</div>
<div class="right">
	<div class="nei">
		<h2 class="h2"><c:if test="${fcAutoid eq 0}">仿真教学资源</c:if>${flowcls.fcName }</h2>
		<br/>
		<ul>
			<c:forEach var="flow" items="${flowList}">
			<li>
				<c:choose>
    			<c:when test="${flow.flowType eq 'soft'}">
					<div><a href="${pageContext.request.contextPath}/course/flowinfo.do?flowAutoid=${flow.flowAutoid}"><img width="240" height="150" src="${pageContext.request.contextPath}${flow.imageUrl}"/></a></div>
					<p><font><a href="${pageContext.request.contextPath}/course/flowinfo.do?flowAutoid=${flow.flowAutoid}">${flow.flowName}</a></font></p>
					<p><a href=""></a>${flow.typeName }</p>
				</c:when>
				<c:otherwise>
					<div><a href="${pageContext.request.contextPath}/course/view.do?flowAutoid=${flow.flowAutoid}"><img width="240" height="150" src="${pageContext.request.contextPath}${flow.imageUrl}"/></a></div>
					<p><font><a href="${pageContext.request.contextPath}/course/view.do?flowAutoid=${flow.flowAutoid}">${flow.flowName}</a></font></p>
					<p><a href=""></a>${flow.typeName }</p>
				</c:otherwise>
    			</c:choose>
			</li>
			</c:forEach>
		</ul>
    	
    	<p class="page">
    		${strPager}
    	</p>  
    </div>
</div>

</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>