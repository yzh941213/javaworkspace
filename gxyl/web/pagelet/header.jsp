<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--logo-->
<div class="top" style="width:1120px; height:150px; margin:0 auto; background:url(${pageContext.request.contextPath}/images/banner.png);">
	<img src="${pageContext.request.contextPath}/images/btop.png">
</div>
<!--菜单导航栏-->
<div class="nav" style="background:url(${pageContext.request.contextPath}/images/background.png) repeat; width:1120px; height:36px; margin:0 auto; clear:both;">
	<ul>
		<li><a href="${pageContext.request.contextPath}/index.do">首&nbsp;&nbsp;页</a></li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=center">中心概况</a></div>
			<ul class="nav_ul" id="center">        		
        	</ul>
        </li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=teacher">师资队伍</a></div>
			<ul class="nav_ul" id="teacher"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=resource">实验教学</a></div>
			<ul class="nav_ul" id="resource"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=laboratory">实验室</a></div>
			<ul class="nav_ul" id="laboratory"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=share">教学成果</a></div>
			<ul class="nav_ul" id="share"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=run">管理制度</a></div>
			<ul class="nav_ul" id="run"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/center/info.do?clsName=down">下载专区</a></div>
			<ul class="nav_ul" id="down"></ul>
		</li>
		<li class="center"><div><a href="${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid=0">教学资源</a></div>
			<ul class="nav_ul" id="flowcls"></ul>
		</li>
		<li class="center nobg"><div><a href="/qdkj/login.jsp" target="_blank">虚拟仿真平台</a></div>
			<ul class="nav_ul" id="visplat"></ul>
		</li>
	</ul>
</div>
<script type="text/javascript">
$(document).ready(function(){
	
	$(function(){
		getNewsCls("#center","center");
		getNewsCls("#teacher","teacher");
		getNewsCls("#run","run");
		getNewsCls("#resource","resource");
		getNewsCls("#laboratory","laboratory");
		getNewsCls("#share","share");
		getNewsCls("#down","down");
		getNewsCls("#visplat","visplat");
		getflowcls();
		footer();
	})
	//导航下拉菜单
	$('.center').mouseover(function(e) {
        $(this).children('.txt').css('background','#fff');
		$(this).children('.nav_ul').stop().show();

    });
	$('.center').mouseout(function(e) {
        $(this).children('.txt').css('background','');
		$(this).children('.nav_ul').stop().hide();
    });
	$('.nav_li').mouseover(function(e) {
        $(this).children().css('color','#fff');
    });
	$('.nav_li').mouseout(function(e) {
        $(this).children().css('color','#666');
    });
});
function getNewsCls(id, cls){
	$.post("${pageContext.request.contextPath}/getNewsCls.do",{clsName:cls},function(data){
		$.each(data,function(index,demo){
			$(id).append("<li class='nav_li'><a href='${pageContext.request.contextPath}/center/index.do?newsClsAutoid="+demo.newsClsAutoid+"&clsName="+demo.clsName+"'>"+demo.name+"</a></li>");
		});
	},"json");
}
function footer(){
	$.post("${pageContext.request.contextPath}/getFooter.do",function(data){
		$(".footer").html(data);
	});
}
function getflowcls(){
	$.post("${pageContext.request.contextPath}/getFlowcls.do",function(data){
		$.each(data,function(index, demo){
			$("#flowcls").append("<li class='nav_li'><a href='${pageContext.request.contextPath}/course/index.do?page=1&fcAutoid="+demo.fcAutoid+"'>"+demo.fcName+"</a></li>");
		});
		//$("#flowcls").append("<li class='nav_li'><a href='${pageContext.request.contextPath}/course/soft.do?page=1&clsID=1'>理论计算</a></li>");
		//$("#flowcls").append("<li class='nav_li'><a href='${pageContext.request.contextPath}/course/soft.do?page=1&clsID=2'>高危高害</a></li>");
	},"json");
}
</script>

          	