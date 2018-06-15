<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.common.Json"%>
<%!
	String PATH = "/uploads/";
	public void upload(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String path=request.getParameter("fileFolder");
		
		String savePath = this.getServletConfig().getServletContext().getRealPath("/");
		if(path.equals("image")){
			Date date1=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String spath=savePath+PATH+"attach/image/"+sdf.format(date1);
			File files=new File(spath);
			if(!files.exists()){
				files.mkdirs();
			}
			path="attach/image/"+sdf.format(date1);
		}
		savePath = savePath + PATH+path + "/";
		File f1 = new File(savePath);
		//System.out.println(savePath);
		//这里接收了fileFolder的值
		String folder = "/uploads/"+ path +"/";
		//System.out.println(folder);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		Random rnd=new Random();
		int ssd=Math.abs(rnd.nextInt())%100;
		ssd=ssd<10?ssd+10:ssd;
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		String newName=sdf.format(now)+String.valueOf(ssd);
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}
		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String oldName="";
		String extName = "";
		double fileSize = 0;
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				name = item.getName();
				long size = item.getSize();
				fileSize = size/1024;
				String type = item.getContentType();
				System.out.println(size + " " + type);///////////////////////
				if (name == null || name.trim().equals("")) {
					continue;
				}
				oldName=name;
				// 扩展名格式：
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf("."));
					oldName = name.substring(0,name.lastIndexOf("."));
				}
				/*
				File file = null;
				do {
					// 生成文件名：
					name = UUID.randomUUID().toString();
					
					file = new File(savePath + newName + extName);
				} while (file.exists());
				*/
				File saveFile = new File(savePath + newName + extName);
				try {
					item.write(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("newName", newName+extName);
		map.put("oldName", oldName+extName);
		map.put("fileSize", fileSize);
		map.put("filePath", folder);
		map.put("name",oldName);
		String jsonString= Json.getJson().toJson(map);
		response.getWriter().print(jsonString);
		System.out.println(jsonString);
	}
%>
<%
	upload(request, response);
%>