package com.aishidai.app.service.impl;
import com.aishidai.app.service.UploadManager;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Shaka on 15/4/23.
 */
@Service
public class UploadManagerImpl implements UploadManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String ACCSESS_KEY = "zOP_Y78Hajk0W5KN9fWLGDHH_tf59-RGfqBwGpe_";
    private static String SECRET_KEY = "Qlxjts7woO_qVOdZPTner4FqIVLhKbI1-qVFqGVk";



    com.qiniu.storage.UploadManager qiniuUploadManager=new com.qiniu.storage.UploadManager();




    Auth auth   = Auth.create(ACCSESS_KEY, SECRET_KEY);

    private String getUpToken0(int i) {
        String qiniuSpace = "yixuejia-item";
        switch (i){
            case 1:
                qiniuSpace = "yixuejia-item";
                break;
            case 2:
                qiniuSpace = "yixuejia-avatar";
                break;
            case 3:
                qiniuSpace = "yixuejia-item";
                break;
            case 4:
                qiniuSpace = "yixuejia-item";
                break;
        }
        return auth.uploadToken(qiniuSpace);
    }

    public String putFile(String savedFileName, byte[] bytes, int i) {
//        String fileName = null;

        String server = null;
        String filePath = "";
        String qiniuSpace = "yixuejia-item";
        switch (i){
            case 1:
                qiniuSpace = "yixuejia-item";
                break;
            case 2:
                qiniuSpace = "yixuejia-avatar";
                break;
            case 3:
                qiniuSpace = "yixuejia-set";
                break;
        }
        try {
            Response res = qiniuUploadManager.put(bytes, savedFileName, auth.uploadToken(qiniuSpace));
            ResponseResult ret = res.jsonToObject(ResponseResult.class);
//            fileName = ret.key;
            server = ret.address;
        } catch (QiniuException e) {
            Response r = e.response;
            logger.error(r.toString());
            try {
                // 响应的文本信息
                logger.error(r.bodyString());
            } catch (QiniuException e1) {
            }
        }

        return server;
    }

    public String putFileAsync(final String savedFileName, final byte[] bytes, final int i) {
        if(bytes == null || bytes.length == 0){
            return savedFileName;
        }

        Thread thread = new Thread() {
            public void run() {
                putFile(savedFileName, bytes, i);
            }
        };
        thread.start();

        return savedFileName;
    }

    class ResponseResult {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
        public String address;
    }

}
