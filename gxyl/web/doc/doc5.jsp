<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安装证书和插件</title>
<link rel="stylesheet" href="../css/doc.css"  type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
</head>
<body>
<%@ include file="../pagelet/header.jsp" %>
<!--当前位置-->
<div class="login">
	<p class="current">当前位置 &gt; <span>首页 &gt; 网站帮助 &gt; 安装证书和插件</span></p>
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
		<h2>安装证书和插件</h2>
		<b><a href="${pageContext.request.contextPath}/activex/runmod.cer">下载证书</a></b>
    	<h3>【通过浏览器安装证书和插件，请使用32位的IE浏览器，启动实验的时候也要使用32位的IE浏览器。】</h3>
    	<h3>1、【第一步】：在浏览器工具栏中选择【工具】，然后单击“Internet选项”，如下图</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-1.png"  />
    	<h3>2、【第二步】：在【Internet选项】对话框中选择“内容”选项卡，然后单击“证书”，打开“证书对话框”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-2.png"  />
    	<h3>3、【第三步】：在“证书对话框”中选择“受信任的证书颁发机构”选项卡，然后单击“导入”，打开“证书导入向导对话框”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-3.png"  />
    	<h3>4、【第四步】：单击“下一步”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-4.png"  />
    	<h3>5、【第五步】：单击“浏览”，在浏览文件对话框中找到下载的证书文件runmod.cer。然后单击“下一步”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-5.png"  />
    	<h3>6、【第六步】：单击“下一步”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-6.png"  />
    	<h3>7、【第七步】：单击“完成”</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-7.png"  />
    	<h3>8、【第八步】：导入成功</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-8.png"  />
    	<h3>9、【第九步】：进入“仿真实验”页面，页面加载完成后会在顶部弹出加载启动项工具条，单击工具条，选择“为此计算机上的所有用户安装此加载项”。</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-9.png"  />
    	<h3>10、【第十步】：单击“安装”完成插件安装。</h3>
        <img src="${pageContext.request.contextPath}/images/cert2-10.png"  />
        </div>
    </div>
</div>
<%@ include file="../pagelet/footer.jsp" %>
</body>
</html>