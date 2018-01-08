package com.zhezhuo.biz.Algorithm;

import com.zhezhuo.biz.util.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zshuang on 15-5-18.
 */
public class CppApiTest {

    static Logger logger = LoggerFactory.getLogger(CppApiTest.class);

    static {
        if (EnvConfig.isDevelop()) {
           // System.load("/usr/lib/libHelloOpencv.so");
        } else {
//            System.load("/Volumes/Ents/desktop/libHelloOpencv.so");
        }
    }

    public int SetModel(int[] img_data, int modelId, int[] face_paras) {
        int ks = -1;
        try {
            //int[] test = {1,2,3,4,5};
            ks = SoLib_SetModel_Standard(img_data, modelId, face_paras);//0 --- 第几个模特

        } catch (Exception e) {
            logger.error("SoLib_SetModel_Standard: ", e);
        }

        return ks;
    }

    public int LoadSource(byte[] img_data, int layer, int[] face_paras) {
        int ks = -1;
        try {
            //int[] test = {1,2,3,4,5};
            ks = SoLib_LoadSource(img_data, layer, face_paras);
        } catch (Exception e) {
            logger.error("SoLib_LoadSource: ", e);
        }

        return ks;
    }

    public byte[] GetResult(int[] layer_state, int[] style, int[] result_setting) {
        byte[] ks = {1, 2, 3};
        try {
            //int[] test = {1,2,3,4,5};
            ks = SoLib_GetResult(layer_state, style, result_setting);
        } catch (Exception e) {
            logger.error("SoLib_GetResult: ", e);
        }

        return ks;
    }

    public int InitModel(String ppath) {
        int init_result = -1;

        try {
            init_result = SoLib_Init(ppath);
        } catch (Exception e) {
            logger.error("SoLib_Init: ", e);
        }

        return init_result;
    }

    /**
     *
     * @param img_data 原始的脸部图片还是换好了脸的模特的图片？
     * @param body_num 原始的模特id？
     * @param paras
     * @return
     */
    private native int SoLib_SetModel_Standard(int[] img_data, int body_num, int[] paras);

    private native int SoLib_LoadSource(byte[] img_data, int layer, int[] paras);

    private native int SoLib_Init(String model_path);

    private native byte[] SoLib_GetResult(int[] layer_state, int[] style, int[] result_setting);


}
