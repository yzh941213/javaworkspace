package com.aishidai.app.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaka on 16/8/4.
 */
public class EnvConfig {

    private static boolean localhost = true;//是否本机测试

    private static boolean develop = false;//是否开发环境
    //7xiq6p.com1.z0.glb.clouddn.com
    private static boolean product = false;//是否生产环境
    public static final Map<Integer, String> IMAGE_SERVER_SPACE = new HashMap<Integer, String>();

    static {
    	IMAGE_SERVER_SPACE.put(1, "http://ocpmlwhfw.bkt.clouddn.com/");
        IMAGE_SERVER_SPACE.put(2, "http://ocpmydaq3.bkt.clouddn.com/");
        IMAGE_SERVER_SPACE.put(3, "http://ocppszmy3.bkt.clouddn.com/");
    }
    
    public final static String IMAGE_SERVER_DOMAIN_NAME = "http://7xiq6p.com1.z0.glb.clouddn.com/%s"; //七牛CDN的空间域名
    public final static String IMAGE_SERVER_DOMAIN_NAME_NEW = "http://7xiq6p.com2.z0.glb.clouddn.com/%s"; //七牛CDN的空间域名

    public static double percentage = 0.1;
    public static String storeFolder = null;//本地存储的文件夹路径

    static Logger logger = LoggerFactory.getLogger(EnvConfig.class);

    static {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();

            //服务器的主机名
            System.out.println("主机名：-------------"+hostName);
            if("izbp12pnmdcpr5rkbph7vsz".equalsIgnoreCase(hostName) || "izbp12pnmdcpr5rkbph7vsz".equalsIgnoreCase(hostName)){
            	System.out.println("进来了主机");
                develop = true;
                localhost = false;
            }

        } catch (UnknownHostException e) {
            logger.error("", e);
        }

        if (!EnvConfig.isLocalhost()) {
            storeFolder = "/root/static/upload/";//服务器的存储路径/root/static/upload
        } else {
//            storeFolder = "/Volumes/Documents/workspace/project_output/zhezhuo/upload/";//本机测试的存储路径
            storeFolder = "/root/static/upload/";//服务器的存储路径
        }
    }

    public static boolean isLocalhost() {
        return localhost;
    }

    public static void setLocalhost(boolean localhost) {
        EnvConfig.localhost = localhost;
    }

    public static boolean isDevelop() {
        return develop;
    }

    public static void setDevelop(boolean develop) {
        EnvConfig.develop = develop;
    }

    public static boolean isProduct() {
        return product;
    }

    public static void setProduct(boolean product) {
        EnvConfig.product = product;
    }
}
