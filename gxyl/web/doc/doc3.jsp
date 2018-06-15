<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>远程授权</title>
<link rel="stylesheet" href="../css/doc.css"  type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>首页 &gt; 网站帮助 &gt; 安装授权-远程授权</span></p>
</div>
<!--内容-->
<div class="content" style="width:1120px; min-height:650px; margin:0px auto; overflow:hidden;" >
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
		<h2>安装授权-远程授权</h2>
        <p>注意：安装授权时，只需实施<span>本地授权</span>或<span>远程授权</span>其中一个即可。</p>
        <h3>1、在IE中输入http://localhost:22350/，选择“配置/服务器设置”，勾选“运行网络服务器”，操作后界面如下图所示：</h3>
        <img src="${pageContext.request.contextPath}/images/2.2-1.png" width="900" />
        <h3>2、选择“配置/网络设置”，点击“添加”按钮，在弹出的窗口中输入服务器的IP地址，然后点击确定，操作后界面如下所示：</h3>
        <img src="${pageContext.request.contextPath}/images/2.2-2.png" width="900" />
        <p>注意：公网IP如果为动态IP，当IP发生改变时，客户端需在网络设置端添加新的服务器IP地址到服务器列表框中。</p>
        </div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>