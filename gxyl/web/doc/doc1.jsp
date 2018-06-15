<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安装驱动</title>
<link rel="stylesheet" href="../css/doc.css"  type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>首页 &gt; 网站帮助 &gt; 安装驱动</span></p>
</div>
<!--内容-->
<div style="width:1120px; min-height:650px; margin:0px auto; overflow:hidden;" >
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
		<h2>安装驱动</h2>
    	<p>前言：在开始学习虚拟仿真实验课程前，必须先安装加密锁驱动、部署授权<span>（本地或远程部署一个即可）</span>、安装仿真运行平台、安装证书和插件；在实验课程中，初次进入时会提示下载安装仿真软件，选择运行安装后再次可直接进入。</p>
    	<b><a href="${pageContext.request.contextPath}/activex/CodeMeterRuntime.exe">下载驱动程序</a></b>
    	<h3>1、运行下载的驱动程序CodeMeterRuntime.exe点击“下一步”。</h3>
        <img src="${pageContext.request.contextPath}/images/1-1.png"  />
    	<h3>2、勾选中“我接受许可协议中的条款(A)”，点击“下一步”。</h3>
        <img src="${pageContext.request.contextPath}/images/1-2.png"  />
    	<h3>3、选择“为此计算机的所有用户安装(M)”，点击“下一步”。</h3>
        <img src="${pageContext.request.contextPath}/images/1-3.png"  />
    	<h3>4、点击“下一步”。</h3>
        <img src="${pageContext.request.contextPath}/images/1-4.png"  />
    	<h3>5、点击“安装”。</h3>
        <img src="${pageContext.request.contextPath}/images/1-5.png"  />
    	<h3>6、安装完成。</h3>
        <img src="${pageContext.request.contextPath}/images/1-6.png"  />
        </div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>