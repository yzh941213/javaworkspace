$(document).ready(function(){
	$(function(){});
	$("input[name=itemChkall]").click(function(){
		$("input[name=itemChk]").prop("checked",$(this).prop("checked"));
	});
});
//打开上传文件对话框
function openUp(id){
	var t=new Date().getTime();
	var url="";
	var pah=true;//$("#pah").attr("checked");
	if(id=="pz"){
		if(pah){
			url=urlRoot+"/common/uploadone.jsp?ext=ini&path=temp&id="+id+"&t="+t;
			$("#ifmUp").attr("src", url);
			$("#diaUp").window({title:'上传配置文件',width:380,height:150});
			$("#diaUp").window("open");
		}else{
			parent.window.openFlowDia("exe", id);
		}
	}
	if(id=="az"){
		if(pah){
			url=urlRoot+"/common/uploadone.jsp?ext=exe&path=file&id="+id+"&t="+t;
			$("#ifmUp").attr("src", url);
			$("#diaUp").window({title:'上传项目安装包',width:380,height:150});
			$("#diaUp").window("open");
		}else{
			parent.window.openFlowDia("exe", id);
		}
	}
	if(id=="img"){
		url=urlRoot+"/common/uploadone.jsp?ext=image&path=image&id="+id+"&t="+t;
		$("#ifmUp").attr("src", url);
		$("#diaUp").window({title:'上传图片',width:380,height:150});
		$("#diaUp").window("open");
	}
	if(id=="doc"){
		if(pah){
			url=urlRoot+"/common/uploadone.jsp?ext=doc&path=file&id="+id+"&t="+t;
			$("#ifmUp").attr("src", url);
			$("#diaUp").window({title:'上传操作手册',width:380,height:150});
			$("#diaUp").window("open");
		}else{
			parent.window.openFlowDia("exe", id);
		}
	}
}
//上传一个文件完成后调用的函数
var complete=function(response, id){
	var obj=$.parseJSON(response);
	var filePath=obj.filePath+obj.newName;
	$("#diaUp").window("close");
	if(id=="pz"){
		var par={filePath:filePath};
		$.post("readini.do", par, function(data){
			if(data.flag!=undefined){
				alert(data.flag+data.action);
				return;
			}
			$("#dvName").text(data.appName);
			$("#dvID").text(data.itemID);
			$("#dvCompany").text(data.appAuth);
			$("input[name=flowName]").val(data.appName);
			$("input[name=itemID]").val(data.itemID);
			$("input[name=companyID]").val(data.appAuth);
			try{
				editor.html(data.appDesc);
			}catch(e){
				$("#content").val(data.appDesc);
			}
			itemBind(data.grid);
		},"json");
		return;
	}
	if(id=="az"){//上传的exe文件
		$("#spFile").text("文件：【"+obj.oldName+"】；路径：【"+filePath+"】");
		$("#dnexe").attr("href",urlRoot+filePath);
		$("#dnexe").show();
		$("input[name=fileName]").val(obj.oldName);
		$("input[name=filePath]").val(filePath);
		$("input[name=fileSize]").val(obj.fileSize);
		return;
	}
	if(id=="img"){
		$("#img").attr("src",urlRoot+filePath);
		$("input[name=imageUrl]").val(filePath);
		return;
	}
	if(id=="doc"){
		$("#spDoc").text("路径：【"+filePath+"】");
		$("#dnDoc").attr("href", urlRoot+filePath);
		$("#dnDoc").show();
		$("input[name=docName]").show();
		$("input[name=docName]").val(obj.oldName);
		$("input[name=docPath]").val(filePath);
	}
}
function itemBind(grid){
	if(grid!=null){
		$.each(grid.rows, function(index, row){
			var bg="";
			if(row.alr=="y"){
				bg="style='background:#cccccc'";
			}
			var tr="<tr><td height='26' align='center' "+bg+"><input type='checkbox' name='itemChk' value='0'></td>";
			tr+="<td align='center' "+bg+">"+row.subID+"</td>";
			tr+="<td align='center' "+bg+">"+row.itemName+"</td></tr>";
			$("#tabItem").append(tr);
		});
	}
}
function check(){
	if($("input[name=flowName]").val()==""){
		alert("请添加配置文件");
		return false;
	}
	if($("input[name=fileName]").val()==""){
		alert("请添加软件");
		return false;
	}
	var content="";
	try{
		content=editor.html();
	}catch(e){
		conten=$("#content").val();
	}
	$("#content").val(content);
	var arrItem=new Array();
	//将培训项目封装成对象
	$("#tabItem tr:gt(0)").each(function(index, demo){
		var it=null,ck="true";
		var itemChk=$(demo).find("input[name=itemChk]");
		var itemAutoid=itemChk.val();
		var subID=$(demo).find("td:eq(1)").text();
		var itemName=$(demo).find("td").last().text();
		if(itemChk.prop("checked")){
			ck="false";
		}
		it={"itemAutoid":itemAutoid,"subID":subID,"itemName":itemName,del:ck}
		arrItem.push(JSON2.stringify(it));
	});
	var str="["+arrItem.join(",")+"]";
	
	$("input[name=items]").val(str);
	$("input[type=submit]").attr("disabled","disabled");
	return true;
}
var editor;
KindEditor.ready(function (K) {
	      editor = K.create('#content', {
	    	 minWidth:'310px',width:'660px',height:'250px',
	    	items: ['source', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', '|', 
	    	        'subscript', 'superscript', 'fontname', 'fontsize', 'forecolor', 'hilitecolor', '|', 
	    	        'bold', 'italic', 'underline', '|', 'insertorderedlist', 'preview', 'fullscreen', '|', 
	    	        'cut', 'copy', 'paste', '|', 'image','lineheight','table', 'link'],
	        resizeType:0,
	        cssPath: '../../kindeditor-4.1.10/plugins/code/prettify.css',
	        uploadJson: '../../kindeditor-4.1.10/jsp/upload_json.jsp',
	        fileManagerJson: '../../kindeditor-4.1.10/jsp/file_manager_json.jsp',
	        allowFileManager: true,
	        afterCreate: function () {
	    	    editor=this;
	            var self = this;
	            K.ctrl(document, 13, function () {
	                self.sync();                
	            });
	            K.ctrl(self.edit.doc, 13, function () {
	                self.sync();               
	            });
	        }
	    });
	    prettyPrint();
	    
	    K('#imgmanage').click(function() {
			editor.loadPlugin('filemanager', function() {
				editor.plugin.filemanagerDialog({							
					viewType : 'VIEW',
					dirName : 'image',
					clickFn : function(url, title) {
						$("#img").attr("src", url);
						var _url=url.replace(urlRoot, "");								
						K('#imageUrl').val(_url);
						editor.hideDialog();
					}
				});
			});
		});
});