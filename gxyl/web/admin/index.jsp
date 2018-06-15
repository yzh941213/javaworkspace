<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
$(document).ready(function(){
	$("#menu>li").click(function(){
		$("#menu>li").removeClass("current");
		$(this).addClass("current");
	});
	$(function(){
		var c=new Clock();
		c.showDate(document.getElementById("clock"));
	});
});
</script>
<style type="text/css">
<!--
body {height:100%; margin:0px; padding:0px;}
.main{position:absolute;width:100%;min-height:631px;top:0;bottom:0;}
.header{height:61px;position:absolute;background:#ccc;width:100%;}
.left{width:177px;min-height:546px;left:2px;top:61px;bottom:24px;position:absolute;height:90%;border-left:solid 1px #9ad452;border-right:solid 1px #9ad452;}
.right{left:181px;position:absolute;top:61px;bottom:24px;right:0;height:90%;}
.footer{height:24px;bottom:0;position:absolute;background:#330000;z-index:15;width:100%;}
.STYLE1 {
	color: #43860c;
	font-size: 12px;
}
.STYLE2 {color: #43860c; font-size: 12px; }

a:link {font-size:12px; text-decoration:none; color:#43860c;}
a:visited {font-size:12px; text-decoration:none; color:#43860c;}
a:hover{font-size:12px; text-decoration:none; color:#FF0000;}
.current{background:#f3ffe3;}
.current a{color:blue}
-->
</style>
</head>
<body>
<div class="main">
	<div class="header">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td height="9" style="line-height:9px; background-image:url(${pageContext.request.contextPath}/themes/main_04.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="97" height="9" background="${pageContext.request.contextPath}/themes/main_01.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="47" background="${pageContext.request.contextPath}/themes/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38" height="47" background="${pageContext.request.contextPath}/themes/main_06.gif">&nbsp;</td>
        <td width="59"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="29" background="${pageContext.request.contextPath}/themes/main_07.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="18" background="${pageContext.request.contextPath}/themes/main_14.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
              <tr>
                <td  style="width:1px;">&nbsp;</td>
                <td ><span class="STYLE1">${person.account }</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="155" background="${pageContext.request.contextPath}/themes/main_08.gif">&nbsp;</td>
        <td><table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" valign="bottom"><img src="${pageContext.request.contextPath}/themes/main_12.gif" width="367" height="23" border="0" usemap="#Map" /></td>
          </tr>
        </table></td>
        <td width="200" background="${pageContext.request.contextPath}/themes/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11%" height="23">&nbsp;</td>
            <td width="89%" valign="bottom"><span class="STYLE1">日期：<span id="clock"></span></span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="5" style="line-height:5px; background-image:url(${pageContext.request.contextPath}/themes/main_18.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" background="${pageContext.request.contextPath}/themes/main_16.gif"  style="line-height:5px;">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
	</div>
		<div class="left">
			<table width="177" height="100%" border="0" cellpadding="0" cellspacing="0">
  			<tr>
    			<td valign="top">
    			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed">
      			<tr>
        			<td height="26" background="${pageContext.request.contextPath}/themes/main_21.gif">&nbsp;</td>
      			</tr>
      			<tr>
        			<td height="80" style="background-image:url(${pageContext.request.contextPath}/themes/main_23.gif); background-repeat:repeat-x;">
        				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          				<tr>
            				<td height="45"><div align="center"><a href="#"><img src="${pageContext.request.contextPath}/themes/main_26.gif" name="Image1" width="40" height="40" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','${pageContext.request.contextPath}/themes/main_26_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div></td>
            				<td><div align="center"><a href="#"><img src="${pageContext.request.contextPath}/themes/main_28.gif" name="Image2" width="40" height="40" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','${pageContext.request.contextPath}/themes/main_29_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div></td>
            				<td><div align="center"><a href="#"><img src="${pageContext.request.contextPath}/themes/main_31.gif" name="Image3" width="40" height="40" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','${pageContext.request.contextPath}/themes/main_31_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></div></td>
          				</tr>
          				<tr>
            				<td height="25"><div align="center" class="STYLE2"><a href="#">系统管理</a></div></td>
            				<td><div align="center" class="STYLE2"><a href="#">日志管理</a></div></td>
            				<td><div align="center" class="STYLE2"><a href="#">数据分析</a></div></td>
          				</tr>
        				</table>
        			</td>
      			</tr>
      			<tr>
        			<td style="line-height:4px; background:url(${pageContext.request.contextPath}/themes/main_38.gif)">&nbsp;</td>
      			</tr>
      			<tr>
        			<td>
        				<ul id="menu">
        					<c:forEach items="${menuList}" var="menu">
        					<li><a href="${pageContext.request.contextPath}/${menu.navigateUrl}&model=${menu.model}" target="ifmcenter">${menu.title}</a></li>
        					</c:forEach>
        				</ul>
        			</td>
      			</tr>
    		</table>
    		</td>
  			</tr>
			</table>
		</div>
		<div class="right"><iframe name="ifmcenter" id="ifmcenter" style="width:100%;height:98%;min-width:600px;" src="" frameborder="0"></iframe></div>
	<div class="footer">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  			<tr>
    			<td height="24" background="${pageContext.request.contextPath}/themes/main_47.gif">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td width="29" height="24"><img src="${pageContext.request.contextPath}/themes/main_45.gif" width="29" height="24" /></td>
        				<td>
        					<table width="100%" border="0" cellspacing="0" cellpadding="0">
          						<tr>
            						<td width="369"><span class="STYLE1">版本 2015V1.0 </span></td>
            						<td width="814" class="STYLE1">&nbsp;</td>
            						<td width="185" nowrap="nowrap" class="STYLE1"><div align="center"><img src="${pageContext.request.contextPath}/themes/main_51.gif" width="12" height="12" /> 如有疑问请与技术人员联系</div></td>
          						</tr>
        					</table>
        				</td>
        				<td width="14"><img src="${pageContext.request.contextPath}/themes/main_49.gif" width="14" height="24" /></td>
     				 </tr>
    				</table>
    			</td>
  			</tr>
		</table>
	</div>
</div>
<map name="Map" id="Map">
<area shape="rect" coords="3,1,49,22" href="../index.do" target="_blank" />
<area shape="rect" coords="52,2,95,21" href="javascript:document.getElementById('ifmcenter').contentWindow.history.back();" />
<area shape="rect" coords="102,2,144,21" href="javascript:document.getElementById('ifmcenter').contentWindow.history.forward();" />
<area shape="rect" coords="150,1,197,22" href="javascript:document.getElementById('ifmcenter').contentWindow.location.reload();" />
<area shape="rect" coords="210,2,304,20" href="#" />
<area shape="rect" coords="314,1,361,23" href="exit.do" /></map>
</body>
</html>