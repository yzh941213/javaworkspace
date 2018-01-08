package com.zhezhuo.biz.Algorithm;

import com.zhezhuo.biz.util.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shaka on 15/6/18.
 */
public class FaceOffManager {

    static Logger logger = LoggerFactory.getLogger(FaceOffManager.class);

    @Resource
    ModelAlgorithmManager modelAlgorithmManager;


    public synchronized byte[] process(String path, String desc, int modelId, int imgWidth, int imgHeight) {
        try {
            byte[] img_data = null;

            Path img_path = Paths.get(EnvConfig.storeFolder + path);
            logger.info("path = " + (EnvConfig.storeFolder + path));
            img_data = Files.readAllBytes(img_path);

            int[] params = new int[desc.split(",").length];
            int i = 0;
            for (String sub : desc.split(",")) {
                params[i++] = (int) (Double.parseDouble(sub));
            }

            int[] faceResult = modelAlgorithmManager.process(img_data, params);

            logger.info("FaceOffManager.faceResult.length = " + faceResult.length);

            //把这个处理好的数据保存。
            File file = new File((EnvConfig.storeFolder + path).replaceAll("face_", "faceOff_"));  //存放数组数据的文件
            FileWriter out = new FileWriter(file);  //文件写入流
            //将数组中的数据写入到文件中。每行各数据之间TAB间隔
            for (i = 0; i < faceResult.length; i++) {
                out.write(faceResult[i] + "\t");
            }
            out.close();
            logger.info("换脸之后的图片+参数数据 path = " + ((EnvConfig.storeFolder + path).replaceAll("face_", "faceOff_")));

            params = new int[2];
            params[0] = imgWidth;
            params[1] = imgHeight;
            byte[] result = modelAlgorithmManager.processSetModel(faceResult, modelId, params);
            return result;
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }


    private void createFile(String path, byte[] content) throws IOException {
        logger.error("createFile, path = " + path);
        FileOutputStream fos = new FileOutputStream(path);

        fos.write(content);
        fos.close();
    }
}
