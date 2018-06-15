<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script>
$(document).ready(function(){
	$(function(){
		var itemID="<%=request.getParameter("itemID")%>";
		var subID=<%=request.getParameter("subID")%>;
		var personAutoid=<%=request.getParameter("personAutoid")%>;
		var courseAutoid=<%=request.getParameter("courseAutoid")%>
		var learnrecAutoid=<%=request.getParameter("learnrecAutoid")%>;
		runmod(itemID,subID,personAutoid,courseAutoid,learnrecAutoid);
	});
});
//启动软件
function runmod(itemID,subID,personAutoid,courseAutoid,learnrecAutoid){
	var nvae=navigator.userAgent;
	var epl=navigator;
	if (navigator.userAgent.indexOf("Trident") <= 0) {
		alert("请使用IE浏览器查看");
		return;
	}
	var tgame=document.getElementById("runmod2");
	try{
		tgame.serviceName="ITrainService";
		tgame.portName="ITrainServiceHttpPort";
		tgame.webServiceURL=webService;//变量webServcie在/include/easyui.jsp中定义
	   	var flag=tgame.RunModelByID(itemID, subID, personAutoid, courseAutoid, learnrecAutoid);
	   	if(flag==1){
	    		top.window.alert("您的电脑没有安装运行环境，请先下载安装运行环境。");
	    		top.window.location.href='${pageContext.request.contextPath}/doc/doc.do?d=1';
	    }
	    if(flag==2){    		
	    		parent.window.down();
	    }
	    if(flag==3){
	    	alert("没有找到该培训项目。");
	    }
	}catch(e){
		alert(e.message+"。请先安装插件！");
	}
}
</script>
</head>
<body>
<OBJECT CLASSID="CLSID:B60F66F0-9F96-4D5E-B03D-CC4DBB3DEA61"
			CODEBASE="${pageContext.request.contextPath}/activex/runmod.cab#version=1,0,0,1"
			WIDTH="0" HEIGHT="0" ID="runmod2"></OBJECT>
</body>
</html>