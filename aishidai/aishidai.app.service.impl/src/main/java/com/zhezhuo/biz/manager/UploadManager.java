package com.zhezhuo.biz.manager;

/**
 * Created by Shaka on 15/4/23.
 */
public interface UploadManager {

    public String putFile(String savedFileName, byte[] bytes, int i);

    public String putFileAsync(String savedFileName, byte[] bytes, int i);

}
