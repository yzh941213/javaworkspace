package com.zhezhuo.biz.manager.impl;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.APNTemplate;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.zhezhuo.biz.manager.AppPushManager;

import java.util.ArrayList;
import java.util.List;



public class AppPush implements AppPushManager{

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "mL96svZGpj8nvpDZPr02O7";
    private static String appKey = "5EScN6PfBd6X7SJ3ZsEf93";
    private static String masterSecret = "oe50TZe0vE7902NHfmjUCA";
    private static String host  = "http://sdk.open.api.igexin.com/apiex.htm";


    public void pushToSingleAndroid(String title,String text,String url,String CID){
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        LinkTemplate template = linkTemplateDemo(title,text,url);
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(CID);
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }

    }

    public void pushToSingleISO(String title,String body,String devicetoken){
        IGtPush push = new IGtPush(host, appKey, masterSecret);

        APNTemplate t = new APNTemplate();
        APNPayload apnpayload = new APNPayload();
        apnpayload.setSound("");
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        //通知文本消息标题
        alertMsg.setTitle(title);
        //通知文本消息字符串
        alertMsg.setBody(body);
        //对于标题指定执行按钮所使用的Localizable.strings,仅支持IOS8.2以上版本
        alertMsg.setTitleLocKey("查看");
        //指定执行按钮所使用的Localizable.strings
        alertMsg.setActionLocKey("查看");
        apnpayload.setAlertMsg(alertMsg);

        t.setAPNInfo(apnpayload);
        ListMessage message = new ListMessage();
        message.setData(t);
        String contentId = push.getAPNContentId(appId, message);
        System.out.println(contentId);
        List<String> dtl = new ArrayList<String>();
        dtl.add(devicetoken);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        IPushResult ret = push.pushAPNMessageToList(appId, contentId, dtl);
        System.out.println(ret.getResponse());
    }

    public void pushToAppIOS(String title,String body,List<String> dtl){
        IGtPush push = new IGtPush(host, appKey, masterSecret);

        APNTemplate t = new APNTemplate();
        APNPayload apnpayload = new APNPayload();
        apnpayload.setSound("");
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        //通知文本消息标题
        alertMsg.setTitle(title);
        //通知文本消息字符串
        alertMsg.setBody(body);
        //对于标题指定执行按钮所使用的Localizable.strings,仅支持IOS8.2以上版本
        alertMsg.setTitleLocKey("查看");
        //指定执行按钮所使用的Localizable.strings
        alertMsg.setActionLocKey("查看");
        apnpayload.setAlertMsg(alertMsg);

        t.setAPNInfo(apnpayload);
        ListMessage message = new ListMessage();
        message.setData(t);
        String contentId = push.getAPNContentId(appId, message);
        System.out.println(contentId);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        IPushResult ret = push.pushAPNMessageToList(appId, contentId, dtl);
        System.out.println(ret.getResponse());
    }

    public  LinkTemplate linkTemplateDemo(String title,String text,String url) {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 设置通知栏标题与内容
        template.setTitle(title);
        template.setText(text);
        // 配置通知栏图标
        template.setLogo("icon.png");
        // 配置通知栏网络图标，填写图标URL地址
        template.setLogoUrl(url);
        // 设置通知是否响铃，震动，或者可清除
        template.setIsRing(true);
        template.setIsVibrate(true);
        template.setIsClearable(true);
        // 设置打开的网址地址
        template.setUrl(url);
        return template;
    }
}

