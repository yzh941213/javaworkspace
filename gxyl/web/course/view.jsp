<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String hurl="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath(); %>
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
<c:if test="${flow.flowType eq 'unity3d'}">
<script type="text/javascript">
		<!--
		var unityObjectUrl = "http://webplayer.unity3d.com/download_webplayer-3.x/3.0/uo/UnityObject2.js";
		if (document.location.protocol == 'https:')
			unityObjectUrl = unityObjectUrl.replace("http://", "https://ssl-");
		document.write('<script type="text\/javascript" src="' + unityObjectUrl + '"><\/script>');
		-->
</script>
<script type="text/javascript">
		var config = {
				width: 750, 
				height: 600,
				params: { enableDebugging:"0" }
				
			};
			var u = new UnityObject2(config);

			jQuery(function() {
				var $missingScreen = jQuery("#unityPlayer").find(".missing");
				var $brokenScreen = jQuery("#unityPlayer").find(".broken");
				$missingScreen.hide();
				$brokenScreen.hide();
				
				u.observeProgress(function (progress) {
					switch(progress.pluginStatus) {
						case "broken":
							$brokenScreen.find("a").click(function (e) {
								e.stopPropagation();
								e.preventDefault();
								u.installPlugin();
								return false;
							});
							$brokenScreen.show();
						break;
						case "missing":
							$missingScreen.find("a").click(function (e) {
								e.stopPropagation();
								e.preventDefault();
								u.installPlugin();
								return false;
							});
							$missingScreen.show();
						break;
						case "installed":
							$missingScreen.remove();
						break;
						case "first":
						break;
					}
				});				
					u.initPlugin(jQuery('#unityPlayer')[0], '${pageContext.request.contextPath}${flow.filePath}');				
			});
</script>
</c:if>
<style>
	.item {margin-top:10px;overflow:hidden;}
	.item li{float:left;margin-left:5px;}
</style>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span><a href="index.do?page=1&fcAutoid=${flow.fcAutoid}">${flow.flowcls.fcName}</a></span><span>&gt; ${flow.flowName}</span></p>
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
    	<h2 class="h2">${flow.flowName}</h2>
    	
    	<p style="">
    		<div style="width:750px;margin:20px auto; border:0px solid #36F;">
        	<c:if test="${flow.flowType eq 'flash'}">
						<embed src="${pageContext.request.contextPath}${flow.filePath}" type='application/x-shockwave-flash' width='750' height='600' quality='high' />
					</c:if>
					<c:if test="${flow.flowType eq 'video'}">
						<embed src='${pageContext.request.contextPath}/ckplayer/ckplayer.swf' flashvars='f=<%=hurl %>${flow.filePath}&p=0' quality='high' width='750' height='600' align='middle' allowScriptAccess='always' allowFullscreen='true' type='application/x-shockwave-flash'></embed>
					</c:if>
					<c:if test="${flow.flowType eq 'unity3d'}">
						<div id='unityPlayer' style="border:0px solid #000;margin:0 auto;">
						<div class='missing'>
						<a href='http://unity3d.com/webplayer/' title='Unity Web Player. Install now!'>
						<img alt='Unity Web Player. Install now!' src='http://webplayer.unity3d.com/installation/getunity.png' width='193' height='63' />
						</a>
						</div>
						<div class='broken'>
						<a href='http://unity3d.com/webplayer/' title='Unity Web Player. Install now! Restart your browser after install.'>
						<img alt='Unity Web Player. Install now! Restart your browser after install.' src='http://webplayer.unity3d.com/installation/getunityrestart.png' width='193' height='63' />
						</a>
						</div>
						</div>
					</c:if>
        
        </div>
    	</p> 
    	</div>   	
    	<div>
        	${flow.content }
        </div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>

</body>
</html>