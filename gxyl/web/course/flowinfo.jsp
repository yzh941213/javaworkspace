<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flowinfo.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/dialog/dialog-min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/dialog/ui-dialog.css"/>
<script type="text/javascript">
$(document).ready(function(){
	$(function(){
		
	});
	$(".mm>li").click(function(){
		$(".mm>li").removeClass("current2");
		$(this).addClass("current2");
		
		var i=$(this).index();
		$(".cnt").each(function(index, demo){
			if(index==i){
				$(demo).show();
			}else{
				$(demo).hide();
			}
		});
	});
});
//启动软件
function statSoft(itemID, subID, personAutoid, courseAutoid, learnrecAutoid){
	var t=new Date().getTime();
	var url="${pageContext.request.contextPath}/course/runmod.jsp?itemID="+itemID+"&subID="+subID+"&personAutoid="+personAutoid+"&courseAutoid="+courseAutoid+"&learnrecAutoid="+learnrecAutoid+"&t="+t;
	$("#ifm").attr("src", url);
}
var down=function(){
	//var dc=document.getElementById("ds");
	var d=dialog({
		id:'133',
		align:'bottom',
		title:'下载${flow.flowName}安装包',
		content:'检测到您的电脑没有安装该项目软件，请<a style="color:#0093c8;" href="${pageContext.request.contextPath}${flow.filePath}">下载安装</a>'
	});
	d.show();
}
</script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span><a href="index.do?page=1&fcAutoid=${flow.fcAutoid}">${flow.flowcls.fcName}</a></span><span>&gt; ${flow.flowName}</span></p>
</div>
<!--内容-->
<div style="width:1120px; margin:0 auto; min-height:650px;overflow:hidden;">
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
		<div class="title"><span><b></b></span> <b>申报材料</b></div>
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
		<h2 class="h2"><span id="dc">${flow.flowName}</span></h2>
		<p><img width="420" height="300" src="${pageContext.request.contextPath}${flow.imageUrl}"/></p>    	
    	<ul class="mm">
    		<li class="current2">实验介绍</li>
    		<li>实验项目</li>
    		<li>实验帮助</li>
    	</ul>
    	<div class="hxx">
    	<div class="cnt">
    		${flow.content}
    	</div>
    	<div class="cnt hide">
    		<ul class="item">
    			<li><a href="${pageContext.request.contextPath}${flow.filePath}">下载软件</a></li>
    		<c:forEach var="item" items="${itemList}">
    			<li><a href="javascript:statSoft('${flow.itemID}',${item.subID},${personAutoid},${flow.flowAutoid},0);">${item.itemName}</a></li>
    		</c:forEach>
    		</ul>
    	</div>
    	<div class="cnt hide">
    		<a href="${pageContext.request.contextPath}${flow.docPath}">${flow.docName}</a>
    	</div>
    	</div>
    </div>
</div>

</div>
<%@ include file="../pagelet/footer.jsp" %>
<iframe id="ifm" frameborder="0" scrolling="no" src="" style="width:0px; height:0px"></iframe>
<OBJECT CLASSID="CLSID:B60F66F0-9F96-4D5E-B03D-CC4DBB3DEA61"
			CODEBASE="${pageContext.request.contextPath}/activex/runmod.cab#version=1,0,0,1"
			WIDTH="0" HEIGHT="0" ID="runmod2"></OBJECT>
</body>
</html>