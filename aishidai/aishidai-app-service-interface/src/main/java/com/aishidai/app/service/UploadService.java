package com.aishidai.app.service;

/**
 * Created by Shaka on 15/4/23.
 */
public interface UploadService {

    public String putFile(String savedFileName, byte[] bytes, int i);

    public String putFileAsync(String savedFileName, byte[] bytes, int i);

}
