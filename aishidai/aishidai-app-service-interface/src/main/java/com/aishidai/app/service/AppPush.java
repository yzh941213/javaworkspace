package com.aishidai.app.service;

import java.util.List;


public interface AppPush {


    void pushToSingleAndroid(String title,String text,String url,String CID);

    void pushToSingleISO(String title,String body,String devicetoken);

    void pushToAppIOS(String title,String body,List<String> dtl);
}
