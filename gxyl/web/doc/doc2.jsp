<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本地授权</title>
<link rel="stylesheet" href="../css/doc.css"  type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>首页 &gt; 网站帮助 &gt; 安装授权-本地授权</span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; margin:0px auto; min-height:650px; overflow:hidden;" >
	<div class="left">
		<div class="cai">
			<div class="title"><span><b></b></span> <b>帮助</b></div>
			<div class="shen">
				<ul class="ziyuan">
					<li><a href="doc.do?d=1">1、安装驱动</a></li>
	    			<li><a href="doc.do?d=2">2.1、安装授权-本地授权</a></li>
	    			<li><a href="doc.do?d=3">2.2、安装授权-远程授权</a></li>
	    			<li><a href="doc.do?d=4">3、安装仿真运行平台</a></li>
	    			<li><a href="doc.do?d=5">4、安装证书和插件</a></li>
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
		<h2>安装授权-本地授权</h2>
        <p>注意：安装授权时，只需实施<span>本地授权</span>或<span>远程授权</span>其中一个即可。本地授权文件有：许可文件、授权激活文件，两个文件图标如下图从左到右所示。</p>
    	<b><a href="../activex/cm.zip">下载本地授权文件</a></b>
		<img src="${pageContext.request.contextPath}/images/1.png" />
    	<h3>1、导入许可</h3>
        <p>1）鼠标左键打开托盘区，鼠标右键点击<img src="${pageContext.request.contextPath}/images/2.png"  />图标，在弹出菜单中选择“显示”。</p>
        <img src="${pageContext.request.contextPath}/images/2.1-1.png"  /><img src="${pageContext.request.contextPath}/images/2.1-2.png"  />
        <p>2）在弹出如下界面中，选择“许可”列表框，将DPSPNoBind.wbb文件拖入“许可”列表框中（软授权加密方式不同时，该文件名称略有不同）。</p>
        <img src="${pageContext.request.contextPath}/images/2.1-3.png"  />
        <img src="${pageContext.request.contextPath}/images/2.1-4.png"  /><br />
        <img src="${pageContext.request.contextPath}/images/2.1-5.png"  />
    	<h3>2、激活授权请求文件</h3>
		<p>1）点击运行128-7836903.WibuCmRaU文件。（软授权加密方式不同时，该文件名称略有不同）</p>
        <img src="${pageContext.request.contextPath}/images/2.1-6.png"  />
        <p>选择“是”。</p>
        <img src="${pageContext.request.contextPath}/images/2.1-7.png"  />
        <p>点击“确定”，托盘区CodeMeter控制中心图标由<img src="${pageContext.request.contextPath}/images/3.png"  />变成<img src="${pageContext.request.contextPath}/images/4.png"  />。</p>
        <img src="${pageContext.request.contextPath}/images/2.1-8.png"  />
        <p>2）如上述步骤成功，CodeMeter控制中心状态如下图所示。</p>
        <img src="${pageContext.request.contextPath}/images/2.1-9.png"  />
        </div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>