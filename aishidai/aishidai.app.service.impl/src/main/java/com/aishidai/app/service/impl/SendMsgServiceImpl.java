package com.aishidai.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;

/**
 * Created by 蝈蝈 on 2016/10/14.
 */
@Component("sendMsgManager")
public class SendMsgServiceImpl {



    Logger logger = LoggerFactory.getLogger(SendMsgServiceImpl.class);

    public void sendSms(int type, String phone,String trueName, String inviter) {
        String url = "https://www.stongnet.com/sdkhttp/sendsms.aspx";
        String regCode = "101100-WEB-HUAX-078254"; // 华兴软通注册码，请在这里填写您从客服那得到的注册码
        String regPasswod = "FSNMMJVV"; // 华兴软通注册码对应的密码，请在这里填写您从客服那得到的密码
        String sourceAdd = null;		//子通道号（最长10位，可为空
//        String phone = "15167141601";		//手机号码（最多1000个），多个用英文逗号(,)隔开，不可为空
//        Random random = new Random(1000);

//        String content = "尊敬的用户，"+ inviter+ "推荐您使用服饰电商平台，您可以浏览到男女老少各类超值服饰商品，您的初始账号："+ phone +"，初始密码："+123456+"。下载APP或者关注公众号yixuejiafushi，欢迎登录了解，谢谢！";	//短信内容(含有中文，特殊符号等非ASCII码的内容，用户必须保证其为UTF-8编码格式)
        String content =  trueName+ "您好！"+inviter+"推荐您使用“衣学家”服饰电商平台，您可以浏览到男女老少各类超值服饰商品，您的初始账号："+ phone +"，初始密码："+888888+"。下载“衣学家”APP或者关注公众号（yixuejiafushi），欢迎登录了解，谢谢！";
        try {
            content = URLEncoder.encode(content,"UTF-8");		//content中含有空格，换行，中文等非ascii字符时，需要进行url编码，否则无法正确传输到服务器
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

        }

        String param = "reg=" + regCode + "&pwd=" + regPasswod + "&sourceadd=" + sourceAdd + "&phone=" + phone + "&content=" + content;
        JSONObject jsonObject = null;
        if (type == 1) {
            jsonObject = requestGet(url, param);
        } else if (type == 2) {
            jsonObject = requestPost(url, param);
        }

    }


    /**
     *
     * @param strUrl
     *            请求地址
     * @param param
     *            参数字符串
     * @return 返回字符串
     * @throws Exception
     */
    public static JSONObject requestGet(String strUrl, String param) {
        String returnStr = null; // 返回结果定义
        URL url = null;
        HttpsURLConnection httpsURLConnection = null;

        try {
            url = new URL(strUrl + "?" + param);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(SendMsgServiceImpl.initSSLSocketFactory(1)); // 设置套接工厂
            httpsURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestMethod("GET"); // get方式
            httpsURLConnection.setUseCaches(false); // 不用缓存
            httpsURLConnection.connect();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpsURLConnection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reader.close();
            returnStr = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }
        JSONObject jsonObject = new JSONObject();

        String [] returnStrs = returnStr.split("&");
        for (int i = 0; i < returnStr.length(); i++) {
            if (i == 3) {
                break;
            }
            String[] strs = returnStrs[i].split("=");
            jsonObject.put(strs[0], strs[1]);
        }
        return jsonObject;
    }

    public static JSONObject requestPost(String strUrl, String param) {
        String returnStr = null; // 返回结果定义
        URL url = null;
        HttpsURLConnection httpsURLConnection = null;

        try {
            url = new URL(strUrl);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(SendMsgServiceImpl.initSSLSocketFactory(1)); // 设置套接工厂
            httpsURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestMethod("POST"); // post方式
            httpsURLConnection.connect();

            //POST方法时使用
            byte[] byteParam = param.getBytes("UTF-8");		//得到utf-8编码的字节组
            DataOutputStream out = new DataOutputStream(httpsURLConnection.getOutputStream());
            out.write(byteParam);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpsURLConnection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reader.close();
            returnStr = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }

        JSONObject jsonObject = new JSONObject();

        String [] returnStrs = returnStr.split("&");
        for (int i = 0; i < returnStr.length(); i++) {
            if (i == 3) {
                break;
            }
            String[] strs = returnStrs[i].split("=");
            jsonObject.put(strs[0], String.valueOf(strs[1]));
        }
        return jsonObject;
    }

//    public static JSONObject analysisStr(String returnStr) {
//        JSONObject jsonObject = new JSONObject();
//
//        String [] returnStrs = returnStr.split("&");
//        for (int i = 0; i < returnStr.length(); i++) {
//            String[] strs = returnStrs[i].split("=");
//            jsonObject.put(strs[0], strs[1]);
//        }
//        return jsonObject;
//    }

    /**
     *
     * @param method 两种方法生成,第一种方法载入信任库文件(推荐),第二种方法载入信任证书pem文件
     * @return
     */
    public static SSLSocketFactory initSSLSocketFactory(int method) throws Exception {
        SSLSocketFactory returnSSLSocketFactory = null;
        if(method == 1){
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            KeyStore keyStore = KeyStore.getInstance("jks");
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/stongnet.jks");
            String fileTruseStore = "";//SendMsgManagerImpl.class.getClassLoader().getResource("/stongnet.jks").getPath();
//            String fileTruseStore = "C:\\Users\\蝈蝈\\Desktop\\JAVA\\stongnet.jks";		//信任库文件，发布项目时打包到resource路径,可以用相对路径
            String pwTruseStore = "hxrt_sms_demo";		//默认密码，和库文件绑定的，不需要改，如果一定要改请和客服联系
            FileInputStream f_trustStore=new FileInputStream(resources[0].getFile().getAbsolutePath());
            keyStore.load(f_trustStore, pwTruseStore.toCharArray());
            String alg = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmFact = TrustManagerFactory.getInstance(alg);
            tmFact.init(keyStore);
            TrustManager[] tms = tmFact.getTrustManagers();
            sslcontext.init(null, tms, new java.security.SecureRandom());
            returnSSLSocketFactory = sslcontext.getSocketFactory();
        }else{
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            KeyStore keyStore = KeyStore.getInstance("jks");
            keyStore.load(null, null);		//设置一个空密匙库
//            String trustCertPath = "F:/cacert.pem";		//证书文件路径，发布项目时打包到resource路径
//            String trustCertPath = SendMsgManagerImpl.class.getClassLoader().getResource("/stongnet.jks").getPath();
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/cacert.pem");
            FileInputStream trustCertStream = new FileInputStream(resources[0].getFile().getAbsolutePath());
            CertificateFactory cerFactory = CertificateFactory.getInstance("X.509");
            Collection<? extends Certificate> certs = cerFactory.generateCertificates(trustCertStream);		//读取多份证书(如果文件流中存在的话)
            for (Certificate certificate : certs) {
                keyStore.setCertificateEntry("" + ((X509Certificate)certificate).getSubjectDN(), certificate);		//遍历集合把证书添加到keystore里，每个证书都必须用不同的唯一别名，否则会被覆盖
            }

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
            tmf.init(keyStore);
            TrustManager tms[] = tmf.getTrustManagers();
            sslcontext.init(null, tms, new java.security.SecureRandom());
            returnSSLSocketFactory = sslcontext.getSocketFactory();
        }

        return returnSSLSocketFactory;
    }


}
