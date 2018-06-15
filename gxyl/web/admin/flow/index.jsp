<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<script type="text/javascript">
var fcAutoid=0;
$(document).ready(function(){
	$(".ucs>li").click(function(){
		$(".ucs>li").css("border","1px solid #f3ffe3");
		$(this).css("border","1px solid #ccc");
		fcAutoid=$(this).attr("id");
	});
});
function editcls(){
	if(fcAutoid==0){
		alert("请选择要编辑的分类");
		return;
	}
	var url="../flowcls/addedit.do?fcAutoid="+fcAutoid;
	location.href=url;
	//$("#ifmmain").attr("src", url);
}

function delcls(){
	if(fcAutoid==0){
		alert("请选择要删除的分类");
		return;
	}
	if(confirm("您确定要删除分类吗？")){
	$.post("../flowcls/delete.do",{fcAutoid:fcAutoid},function(data){
		if(data!="0"){
			alert("删除成功！");
			$("li[id="+fcAutoid+"]").remove();
		}else{
			alert("删除失败");
		}
	});
	}
}
</script>
<style>
body {height:100%; margin:0px; padding:0px;}
.left{width:177px;left:2px;top:0;bottom:0;position:absolute;}
.right{left:179px;position:absolute;top:0;bottom:0;right:2px;height:100%;}
.ucs{min-height:200px;list-style:none;margin:0 auto;padding:0;width:100px;}
.ucs li{line-height:20px;border:1px solid #f3ffe3}
</style>
</head>
<body>
	<div class="left">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" /></td>
        <td width="78" background="${pageContext.request.contextPath}/themes/tab_05.gif"></td>
        <td width="78" background="${pageContext.request.contextPath}/themes/tab_05.gif" valign="bottom" align="right">
        	<a href="../flowcls/addedit.do" title="新建分类"><img src="${pageContext.request.contextPath}/themes/001.gif" border="0"/></a>
        	<a href="javascript:editcls();" title="编辑分类"><img src="${pageContext.request.contextPath}/themes/114.gif" border="0"/></a>
        	<a href="javascript:delcls();" title="删除分类"><img src="${pageContext.request.contextPath}/themes/083.gif" border="0"/></a>
        </td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3" style="height:100%">
          <ul class="ucs">
          	<c:forEach items="${list}" var="flowcls">
          	<li id="${flowcls.fcAutoid}"><a href="flow.do?page=1&fcAutoid=${flowcls.fcAutoid}" target="ifmmain">${flowcls.fcName}</a></li>
          	</c:forEach>
          	</ul>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/themes/tab_20.gif" width="15" height="29" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_21.gif">
          &nbsp;</td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
	</div>
	<div class="right">
		<iframe name="ifmmain" id="ifmmain" frameborder="0" src="flow.do?page=1&fcAutoid=0&flowName=" scrolling="auto" style="width:100%;height:99%;overflow:scroll"></iframe>
	</div>
</body>
</html>