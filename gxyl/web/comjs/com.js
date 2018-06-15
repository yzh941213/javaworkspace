$(document).ready(function(){
$(".grid tr").mouseover(function(){
		$(this).find("td").css("background","#eafcd5");
	}).mouseout(function(){
		$(this).find("td").css("background","#fff");
	}).click(function(){
		$(this).find("td").css("background","#51b2f6");
	});
});
/**
 * 展开树形控件已选中的菜单项
 * @param tree 树控件
 * @param node 当前节点
 * */
function expandTree(tree, node){
	var parentNode=tree.tree("getParent", node.target);
	if(parentNode){
		tree.tree("expand", parentNode.target);
		expandTree(tree, parentNode);
	}
}
/**
 * 返回当前节点和子节点id串
 * @param children 子节点
 * @param id 当前节点id
 * */
function getIDchildrenID(children, id){
	var ids;
	var arr = new Array();
	arr.push(id);
	if(children.length>0){
		for(var i=0;i<children.length;i++){
			arr.push(children[i].id);
		}
	}
	ids=arr.join(",");
	return ids;
}
/**返回顶级节点*/
function getTopNode(tree, node){
	var parentNode=$(tree).tree("getParent", node.target);
	if(parentNode){
		if(parentNode.attributes.parentID==0){
			return parentNode;
		}
		else{
			return getTopNode(tree, parentNode);
		}
	}
}
/**
 * 添加完成后调用的函数，用来刷新easyui-grid
 * @param grid gridID
 * @param url 分页的controller路径
 * @param params 除pageindex和pagesize外其它的查询参数json对象
 * */
function onSaveComp(grid, url, params){
	$(grid).datagrid("loading");
	var data=$(grid).datagrid("getData");
	var total=data.total+1;
	var opt=$(grid).datagrid("options");
	var pageSize=opt.pageSize;
	var pageNum=Math.ceil(total/pageSize);
	var QueryObj = {pageindex: pageNum, pagesize: pageSize};
	if(params!=null){
		for(var item in params){
			QueryObj[item]=params[item];
		}
	}
	var das = SendAction(url, "", QueryObj);
	var list=$.parseJSON(das);
	$(grid).datagrid('loadData', list);
	opt.pageNumber=pageNum;
	var pager=$(grid).datagrid("getPager");
	var pagerOpt=pager.pagination("options");
	pagerOpt.pageNumber=pageNum;
	pager.pagination("select", pageNum);
	$(grid).datagrid("loaded");
}
/**
 * 删除完成后执行的函数，用来刷新easyui-grid
 * @param grid gridID
 * @param url 分页的controller路径
 * @param params 除pageindex和pagesize外其它的查询参数json对象
 * */
function onDeleteComp(grid, url, params){
	var opt=$(grid).datagrid('options');
    var pageindex=opt.pageNumber;
    var pagesize=opt.pageSize;
	$(grid).datagrid('loading');
	var QueryObj={pageindex: pageindex, pagesize: pagesize};
	if(params!=null){
		for(var item in params){
			QueryObj[item]=params[item];
		}
	}
	var list=SendAction(url, "", QueryObj);
	var data=$.parseJSON(list);
	if(data.rows.length==0){
		if(pageindex>1){
			QueryObj.pageindex=pageindex-1;
			list=SendAction(url, "", QueryObj);
			data=$.parseJSON(list);
		}
	}
	$(grid).datagrid("loadData",data);
	var pager=$(grid).datagrid("getPager");
	var pagerOpt=pager.pagination("options");
	pagerOpt.pageNumber=QueryObj.pageindex;
	pager.pagination("select", QueryObj.pageindex);
	$(grid).datagrid("loaded");
}

/**
 * 返回试题难度option项
 * */
function getDifficulty(){
	var sysPar=getSysParam("Difficulty");
	var opts="";
	if(sysPar!=null){
		var array=sysPar.value.split(',');
		$(array).each(function(index,demo){
			opts+="<option value='"+demo+"'>"+demo+"</option>";
		});
	}
	return opts;
}
/**
 * 返回基本题型option项
 * */
function getQuesTypeBase(){
	var sysPar=getSysParam("QuesTypeBase");
	var opts="";
	if(sysPar!=null){
		var array=sysPar.value.split(',');
		$(array).each(function(index,demo){
			opts+="<option value='"+demo+"'>"+demo+"</option>";
		});
	}
	return opts;
}
function getSysParam(param){
	var obj={"params": param};
	var result=SendAction(urlRoot+"/admin/sysparam/Sysparam/getSysparam.do","",obj);
	var sysPar=$.parseJSON(result);
	return sysPar;
}