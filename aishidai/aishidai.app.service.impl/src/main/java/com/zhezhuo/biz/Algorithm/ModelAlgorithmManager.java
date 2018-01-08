package com.zhezhuo.biz.Algorithm;

import com.zhezhuo.biz.util.EnvConfig;

/**
 * Created by Shaka on 15/6/12.
 */
public class ModelAlgorithmManager {

    static {
        if (EnvConfig.isDevelop()) {
           // System.load("/usr/lib/libFaceGen.so");
        }
    }

    /**
     *
     * @param img_data 用户拍摄的图片byte
     * @param paras 脸部参数
     * @return 换好的头像
     */
    public int[] process(byte[] img_data, int[] paras){
        return Func(img_data, paras);
    }

    public byte[] processSetModel(int[] img_data, int modelId, int[] params){
        return SetModel(img_data, modelId, params);
    }


    public native int[] Func(byte[] a, int[] b);

    /**
     *
     * @param img_data 换脸之后
     * @param modelId 原始的模特id
     * @param params 宽度＋高度
     * @return
     */
    public native byte[] SetModel(int[] img_data, int modelId, int[] params);

}
