package com.zhezhuo.biz.manager;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/27.
 */
public interface AppPushManager {


    void pushToSingleAndroid(String title,String text,String url,String CID);

    void pushToSingleISO(String title,String body,String devicetoken);

    void pushToAppIOS(String title,String body,List<String> dtl);
}
