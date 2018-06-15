var categoryAutoid=0;
$(document).ready(function(){
	$(function(){
		category();
	});
});

function category(){
	$.post("getCategoryTree.do",function(result){
		var data=$.parseJSON(result);
		if(data.flag!=undefined){
			alert(data.flag+data.action);
			return;
		}
		data=[{id:0,text:"全部分类",attributes:{parentID:-1},children:data}];
		$("#category").tree({
			url: '',
			data:data,
			animate: true,
			lines: true,
			dnd: true,
			onClick: function (node) {
				var parentID=node.attributes.parentID;
				categoryAutoid=0;
				var children=$("#category").tree("getChildren",node.target);
				cateAutoids=getIDchildrenID(children, node.id);
				$("#ifmmain").attr("src","resource.do?page=1&cateAutoids="+cateAutoids);
				//courseBind(1, 20, cateAutoids, '', 'false');
				if(parentID>0){
					categoryAutoid = node.id;
				}
        	},
        	onContextMenu: function (e, node) {        	
        		e.preventDefault();
        		$(this).tree("select", node.target);
        		Node=node;
            //if(node.attributes.parentID==0){
            	//categoryAutoid=0;
            //}else{
            	categoryAutoid=node.id;
            //}
            	cateAutoids=node.id;
            	if(node.id==0){
            		$("#firMenu").menu("show", {
            			left: e.pageX,
            			top: e.pageY
            		});
            	}else{
            		var itemEL=$("#sec-add")[0];
            		var item=$("#secMenu").menu("getItem",itemEL);
            		$("#secMenu").menu("enableItem", item.target);//启用“添加”菜单项
            		var parent=$("#category").tree("getParent", node.target);
            		if(parent){
            			if(parent.attributes.parentID==0){//这样写是二级以下菜单禁用“添加”菜单项            			
            				$("#secMenu").menu("disableItem", item.target);
            			}
            		}
            		$("#secMenu").menu("show", {
            			left: e.pageX,
            			top: e.pageY
            		});
            	}
        	},
        	onDrop: function (target, source, point) {
        		if(point=="append"){
        			alert("不支持追加操作");
        			return;
        		}
        		var node = $(this).tree("getNode", target);
        		var nosu = { "tarID": node.id, "sourID": source.id, "point": point };
        		$.post("index/drop.do", nosu, function(result){
        			if(result.flag!=undefined){
        				alert(result.flag+result.action);
        			}
        		},"json");
        	}
		});
	});
}

//添加分类菜单
function append(){
	cateAction="add";
	var t=new Date().getTime();
	var url="editcate.jsp?action="+cateAction+"&categoryAutoid="+categoryAutoid+"&t="+t;
	$("#ifmCate").attr("src",url);
	$("#diaCate").window({title:'新建分类'});
	$("#diaCate").window("open");
}
//修改分类菜单
function modify(){
	cateAction="edit";
	var t=new Date().getTime();
	var url="editcate.jsp?action="+cateAction+"&categoryAutoid="+categoryAutoid+"&t="+t;
	$("#ifmCate").attr("src",url);
	$("#diaCate").window({title:'编辑分类'});
	$("#diaCate").window("open");
}
//删除分类菜单
function remove(){
	var children=$("#category").tree("getChildren", Node.target);
	var ids=getIDchildrenID(children, Node.id);
	$.messager.confirm('提示', '您确定要删除该分类及其子类吗？', function(s){
		if(s){
			var para={autoids:ids};
			$.post("delete.do", para, function(result){
				if(result.flag!=undefined){
					alert(result.flag+result.action);
					return;
				}
				if(result!=0){
					$.messager.alert('提示', '删除成功', 'info', function(){
						$("#category").tree("remove", Node.target);
					});
				}
			},"json");
		}
	});
}
//展开
function expandall(){
	$("#category").tree("expandAll",Node.target);
}
function saveCate(){
	document.getElementById("ifmCate").contentWindow.save();
}
//保存分类菜单，由editcate.js调用
var saveCateOK=function(result){
	var obj=result;
	if(obj!=null){
		$.messager.alert('提示','保存成功','info',function(){
			if(cateAction=="add"){
				$("#category").tree("append",{
					parent:Node.target,
					data:[obj]
				});
			}else{
				$("#category").tree("update",{
					target:Node.target,
					text:obj.text,
					iconCls:obj.iconCls,
					attributes:obj.attributes
				});
			}
			$("#diaCate").window("close");
		});
	}else{
		$.messager.alert('提示','保存失败','info');
	}
}