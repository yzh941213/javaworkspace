package com.aishidai.app.service;

public interface UploadManager {

    public String putFile(String savedFileName, byte[] bytes, int i);

    public String putFileAsync(String savedFileName, byte[] bytes, int i);

}
