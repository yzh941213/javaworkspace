<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/eltag" prefix="el" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>玉林师范学院虚拟仿真实验中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tools.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.Xslider.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Xslider.css" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	
  </head>
<script type="text/javascript">
$(document).ready(function(){
//图片轮播
	$(function(){
    	$("#slider3").Xslider({
			affect: 'fade',
    		conbox: '.conbox',
			ctag: 'li',
			switcher: '.switcher', //切换触发器id或class
			stag: 'a', //切换器标签 默认为a
			//speed: 800, //动画速度
			space: 3000 //时间间隔
		});
	});
	//更换验证码
	$("#imgCode").click(function(){
		var t=new Date().getTime();
		$(this).attr("src", "${pageContext.request.contextPath}/pagelet/imgCode.jsp?t="+t);
	});
});
//图片无缝滚动
$(function(){
	
});
var tipstate="hide";
function openTip(){
	if(tipstate=="hide"){
		$("#tip").fadeIn('fast');
		tipstate="show";
	}else{
		$("#tip").fadeOut('fast');
		tipstate="hide";
	}
}
function closeTip(){
	$("#tip").fadeOut('fast');
	tipstate="hide";
}

//登录
function login(){
	var par={account:$.trim($("#account").val()), password:$.trim($("#password").val())};
	if(par.account==""||par.password==""){
		alert("请输入用户名和密码！");
		return;
	}
	var code = $.trim($("#code").val());
	var veri = SendAction("${pageContext.request.contextPath}/getCode.do","","");
	if(veri=="-1"){
		alert("验证码失效，请更换一张！");
		return;
	}
	if(code == "" || code != veri){
		alert("请输入正确的验证码！");
		return;
	}
	$("#lgbtn").text("正在登陆");
	$("#lgbtn").attr("disabled","disabled");
	$.post("${pageContext.request.contextPath}/login.do", par, function(data){
		if(data.flag=="ok"){
			if(data.personType=="admin"){
				window.location.href=data.url;
				return;
			}else{
				$("#code").val("");
				if(getCookie("nowUrl")==null){
					$("#cur").hide();
					$("#acp").show();
					$("#acc").text(par.account);
					$("#account").val("");
					$("#password").val("");
				}else{
					window.location.href=getCookie("nowUrl");
					setCookie("nowUrl", "", '1');
				}
			}
		}else{
			alert(data.msg);
		}
		$("#lgbtn").text("登陆");
		$("#lgbtn").removeAttr("disabled");
	},"json");
}
function exit(){
	$.post("${pageContext.request.contextPath}/exit.do",function(data){
		if(data!=""){
			$("#cur").show();
			$("#acp").hide();
		}
		var t=new Date().getTime();
		$("#imgCode").attr("src", "${pageContext.request.contextPath}/pagelet/imgCode.jsp?t="+t);		
	});
}
</script>
<style type="text/css"> 
#goleft {width: 827px;line-height:220px;height: 220px;overflow: hidden;} 
 #gols {width: 33100px;} 
#goleft1, #goleft2 {width: auto;float: left;line-height:220px;height: 220px;padding-top:10px;}
</style>
  <body>
  <%@ include file="pagelet/header.jsp" %>
    <!--内容-->
<div class="con_t">
	<div class="cen">
	  <div id="slider3" class="slider">
    	<ul class="conbox">
    		<c:forEach items="${schoolList}" var="school">
    		<li><a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${school.newsAutoid}"><img src="${pageContext.request.contextPath}${school.image}" width="455" height="334"/></a></li>
    		</c:forEach>
    	</ul>
      <ol class="switcher">
        <c:forEach items="${schoolList}" var="school" varStatus="status">
    		<li <c:if test="${status.count eq 1 }">class="current"</c:if>><a></a></li>
    		</c:forEach>
    	</ol>
    </div>
      <p>第五届“欧倍尔杯“大学生化工实验技能竞赛</p>
  </div>
	<div class="news">
    	<div class="title"><b><span><a href="${pageContext.request.contextPath}/news/news.do?page=1&clsName=centernews">more</a></span></b><b>新闻资讯</b></div>
        <div class="con">
        	<c:forEach items="${centerNewsList}" var="centerNews">
    		<p><a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${centerNews.newsAutoid}" title="${centerNews.title}">${el:subString(centerNews.title, 19, '...')}</a><span><fmt:formatDate value="${centerNews.date}" pattern="yyyy.MM.dd"/></span></p>
    		</c:forEach>           
        </div>    
    </div>
	<div class="left">
    	<div id="cur" class="exit <c:if test="${state eq 1}">hide</c:if>">
    		<table border="0">
    			<tr>
    				<td height="25">用户名：</td><td colspan="2"><input type="text" id="account"/></td>
    			</tr>
    			<tr>
    				<td height="25">密&nbsp;码：</td><td colspan="2"><input type="password" id="password"/></td>
    			</tr>
    			<tr>
    				<td height="25">验证码：</td><td><input type="text" id="code" class="yzm" style="width:53px;"/></td><td><a href="javascript:;"><img id="imgCode" src="${pageContext.request.contextPath}/pagelet/imgCode.jsp" /></a></td>
    			</tr>
    			<tr>
    				<td height="25"></td><td><a id="lgbtn" href="javascript:login();" class="landing col">登录</a></td><td><a href="javascript:;" class="find">找回密码</a></td>
    			</tr>
    		</table>
        </div>
        <div id="acp" class="exit <c:if test="${state eq 0}">hide</c:if>">
        	<div class="intBox"><span>用户名：</span><span id="acc">${person.account }</span></div>
    		<div class="box1"><a href="javascript:exit();" class="landing col">退出</a></div>
        </div>
    	<div class="material">
        	<div class="title"><b>申报材料</b></div>
            <ul>
            	<li><img src="images/dot2.png" /><a href="ware/index.do?type=book">申报书</a></li>
            	<li><img src="images/dot2.png" /><a href="ware/index.do?type=material">支撑材料</a></li>
            	<li><img src="images/dot2.png" /><a href="ware/index.do?type=video">视频介绍</a></li>
            </ul>
        </div>
    	<div class="plat">
        	<div class="title"><b>虚拟仿真实验平台</b></div>
			<p><a href="doc/doc.do?d=1"><img src="images/download.png" /></a></p>
        </div>
    </div>
</div>
<div class="con_m">
		<div class="company">
			<div class="title"><span><a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${introde.newsAutoid}">more</a></span><b>中心简介</b></div>
        	<p>${el:subString(el:Html2Text(introde.content), 150, '......')}</p>
       </div>
		<div class="system">
			<div class="title"><span><a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${experiment.newsAutoid}">more</a></span><b>虚拟仿真化工实验及过程仿真系统</b></div>
        	<p>${el:subString(el:Html2Text(experiment.content), 150, '......')}</p>
       </div>
		<div class="resource">
			<div class="title"><b><span><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=0">more</a></span>仿真实验教学资源</b></div>
			<ul>
				<c:forEach var="flow" items="${flowList}">
			  	<li><img src="images/dot.png" />
			  	<c:choose>
			  		<c:when test="${flow.flowType eq 'soft'}">
			  			<a href="course/flowinfo.do?flowAutoid=${flow.flowAutoid}" title="${flow.flowName}">${flow.flowName}</a>
			  		</c:when>
			  		<c:otherwise>
			  			<a href="course/view.do?flowAutoid=${flow.flowAutoid}" title="${flow.flowName}">${flow.flowName}</a>
			  		</c:otherwise>
			  	</c:choose>
			  	</li>
			  </c:forEach>
			</ul>
       </div>
		<div class="notice">
			<div class="title"><b><span><a href="${pageContext.request.contextPath}/news/news.do?page=1&clsName=notice">more</a></span></b><b>通知公告</b></div>
        	<div class="con">
        		<c:forEach items="${noticeList}" var="notice">
    			<p><a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${notice.newsAutoid}" title="${notice.title}">${el:subString(notice.title, 12, '...')}</a><span><fmt:formatDate value="${notice.date}" pattern="yyyy.MM.dd"/></span></p>
    			</c:forEach>
        	</div>
       </div>
</div>
<div class="con_b">
	<div class="pic">
		<div class="title"><b>成果展示</b></div>
    		<div id="goleft"> 
			<div id="gols"> 
			<div id="goleft1">
    		<c:forEach items="${resultsList}" var="results">
    			<a href="${pageContext.request.contextPath}/news/content.do?newsAutoid=${results.newsAutoid}"><img src="${pageContext.request.contextPath}${results.image}" width="250" height="190"/></a>
    		</c:forEach>
    		</div> 
			<div id="goleft2"></div> 
			</div> 
			</div>
    </div>
    <div class="link">
    	<div class="title"><b>相关链接</b></div>
        <ul>
        	<c:forEach items="${friendList}" var="friend">
        	<li><a href="${friend.url}" target="_blank">${friend.name}</a></li>
        	</c:forEach>
        </ul>
    </div>
</div>
<script type="text/javascript">
//图片滚动JS代码 
	var speed2=20; 
	var FGgoleft=document.getElementById('goleft'); 
	var FGgoleft1=document.getElementById('goleft1'); 
	var FGgoleft2=document.getElementById('goleft2'); 
	FGgoleft2.innerHTML=FGgoleft1.innerHTML 
	function Marquee2(){ 
		if(FGgoleft2.offsetWidth-FGgoleft.scrollLeft<=0) 
		{ 
			FGgoleft.scrollLeft-=FGgoleft1.offsetWidth 
		} 
		else{ 
			FGgoleft.scrollLeft++; 
		} 
	} 
	var MyMar2=setInterval(Marquee2,speed2) 
	FGgoleft.onmouseover=function() { clearInterval(MyMar2) } 
	FGgoleft.onmouseout=function() { MyMar2=setInterval(Marquee2,speed2) } 
</script>
<%@ include file="pagelet/footer.jsp" %>
  </body>
</html>
