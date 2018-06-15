<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String host="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath(); %>
<script>
	var urlRoot='${pageContext.request.contextPath}';//全局变量，引用了easyui.jsp的页面，都能使用该变量
	var webService="<%=host%>/services/ITrainService?wsdl";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/easyui-1.4.3/jquery.easyui.min.js"></script>	
<link id="themes" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/easyui-1.4.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/comjs/com.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/scripts/datepicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/tab.css"/>