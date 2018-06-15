$(document).ready(function(){
	$(function(){});
	
});
//打开上传文件对话框
function openUp(id, path){
	var t=new Date().getTime();
	var url=urlRoot+"/common/uploadone.jsp?ext="+id+"&path="+path+"&id="+id+"&t="+t;
	$("#ifmUp").attr("src", url);
	$("#diaUp").window({title:'上传文件',width:380,height:150});
	$("#diaUp").window("open");
	/*
	var pah=true;//$("#pah").attr("checked");
		if(pah){
			
		}else{
			parent.window.openFlowDia("exe", id);
		}
		*/
}
//上传一个文件完成后调用的函数
var complete=function(response, id){
	var obj=$.parseJSON(response);
	var filePath=obj.filePath+obj.newName;
	$("#diaUp").window("close");
	
	if(id!="image"){//上传的文件
		$("#spFile").text("文件：【"+obj.oldName+"】；路径：【"+filePath+"】");
		$("#dnexe").attr("href",urlRoot+filePath);
		$("#dnexe").show();
		$("input[name=fileName]").val(obj.oldName);
		$("input[name=filePath]").val(filePath);
		$("input[name=fileSize]").val(obj.fileSize);
		return;
	}
	if(id=="image"){
		$("#img").attr("src",urlRoot+filePath);
		$("input[name=imageUrl]").val(filePath);
		return;
	}
}
function check(){
	if($("input[name=flowName]").val()==""){
		alert("填写资源名称");
		return false;
	}
	if($("input[name=fileName]").val()==""){
		alert("请添加资源文件");
		return false;
	}
	var content="";
	try{
		content=editor.html();
	}catch(e){
		conten=$("#content").val();
	}
	$("#content").val(content);
	
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