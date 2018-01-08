package com.zhezhuo.web.home.module.screen.manager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.UploadManager;
import com.zhezhuo.biz.util.EnvConfig;
import com.zhezhuo.biz.util.UniqId;
import com.zhezhuo.web.util.ImageCut;

/**
 * Created by 蝈蝈 on 2016/8/30.
 */
@Controller
@RequestMapping("/manager")
public class CropFileUploadController {

	@Resource
	private UploadManager uploadManager;

	private static Logger logger = LoggerFactory.getLogger(CropFileUploadController.class);
	static final Map<String, Integer> typeMap = new HashMap<String, Integer>();

	static {
		typeMap.put("item", 1);
		typeMap.put("avatar", 2);
		typeMap.put("model", 3);
		typeMap.put("spu", 3);
		typeMap.put("sku", 3);
		typeMap.put("file", 3);
		typeMap.put("tryi", 3);
		typeMap.put("undefined", 3);
		typeMap.put("shop", 4);
		typeMap.put("craftsman", 5);
	}

	// 图片裁剪功能
	@RequestMapping(value = "/cropupload.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String profile_imgCut(MultipartFile avatar_file, String avatar_src, String avatar_data) {
		// String name = avatar_file.getOriginalFilename();
		JSONObject jsonObject = new JSONObject();
		// 判断文件的MIMEtype
		String type = avatar_file.getContentType();
		if (type == null || !type.toLowerCase().startsWith("image/")) {
			jsonObject.put("message", "不支持的文件类型，仅支持图片！");
			jsonObject.put("state", 500);
			jsonObject.put("result", "");
			return jsonObject.toString();
		}
		final String path = type + "_" + UniqId.getInstance().getUniqID();
		JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
		// 用户经过剪辑后的图片的大小
		float x = joData.getFloatValue("x");
		float y = joData.getFloatValue("y");
		float w = joData.getFloatValue("width");
		float h = joData.getFloatValue("height");
		// 保存
		try {
			InputStream is = avatar_file.getInputStream();
			final byte[] fileByte;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ImageCut.cut(is, bout, (int) x, (int) y, (int) w, (int) h);// 可以放到网页端进行裁剪
			fileByte = bout.toByteArray();
			logger.info("fileByte.length = " + fileByte.length);
			Thread thread = new Thread() {
				public void run() {
					if (type.equalsIgnoreCase("tryi")) {
						logger.warn(EnvConfig.storeFolder + path);
						writeIntoFile(EnvConfig.storeFolder + path, fileByte);
					}
					uploadManager.putFile(path, fileByte, 2);// TODO type
				}
			};
			thread.start();
			Thread.sleep(300);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("message", "文件上传失败");
			jsonObject.put("state", 500);
			jsonObject.put("result", "");
			return jsonObject.toString();
		}
		jsonObject.put("message", "文件上传成功");
		jsonObject.put("state", 200);
		jsonObject.put("result", EnvConfig.IMAGE_SERVER_SPACE.get(2) + path);// TODO
																				// type
		return jsonObject.toString();
	}

	private void writeIntoFile(String path, byte[] content) {
		logger.error("createFile, path = " + path);

		if (isExists(path)) {
			logger.error("文件已经存在, return....");
			return;
		}

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(content);
		} catch (FileNotFoundException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					logger.error("", e);
				}
		}
	}

	private boolean isExists(String path) {
		File file = new File(path);

		return file.exists();
	}
}
