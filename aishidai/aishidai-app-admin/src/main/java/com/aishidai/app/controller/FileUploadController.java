package com.aishidai.app.controller;

import com.aishidai.app.config.EnvConfig;
import com.aishidai.app.config.UniqId;
import com.aishidai.app.service.UploadManager;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 蝈蝈 on 2016/8/30.
 */
@Controller
@RequestMapping("/manage-server/manager")
public class FileUploadController {

    @Resource
    private UploadManager uploadManager;

    private static Logger logger = LoggerFactory
            .getLogger(FileUploadController.class);
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
    }

    @RequestMapping("/upload.do")
    @ResponseBody
    public String uploadFile(
            @RequestParam(value = "type", defaultValue = "undefined") final String type,
            MultipartHttpServletRequest request) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        jsonObject.put("picUrl", "没有路径");

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            jsonObject.put("message", "请求不包含文件");
            return jsonObject.toString();
        }

        MultipartFile file = null;
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()) {
            file = request.getFile(fileNames.next());
        }

        if (file == null) {
            jsonObject.put("message", "未获取到文件");
            return jsonObject.toString();
        }

        final String path = type + "_" + UniqId.getInstance().getUniqID();
        final byte[] fileByte;
        try {
            fileByte = file.getBytes();
            logger.info("fileByte.length = " + fileByte.length);
            Thread thread = new Thread() {
                public void run() {
                    if (type.equalsIgnoreCase("tryi")) {
                        logger.warn(EnvConfig.storeFolder + path);
                        writeIntoFile(EnvConfig.storeFolder + path, fileByte);
                    }
                    uploadManager.putFile(path, fileByte, typeMap.get(type));
                }
            };
            thread.start();
            Thread.sleep(300);
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("message", "文件上传失败");
            return jsonObject.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jsonObject.put("message", "文件上传成功");
        jsonObject.put("success", true);
        jsonObject.put("imgUrl", path);
        jsonObject.put("picUrl",
                EnvConfig.IMAGE_SERVER_SPACE.get(typeMap.get(type)) + path);
        jsonObject.put("file_path",
                EnvConfig.IMAGE_SERVER_SPACE.get(typeMap.get(type)) + path);
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
