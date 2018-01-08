package com.zhezhuo.model;

import java.util.Date;

/**
 * Created by Shaka on 15/11/14.
 */
public class UserNotifyMessage {

    private long id;

    //接收者的用户ID
    private long userId;

    //消息发送的userId
    //系统消息的sendUserId=
    private long sendUserId;

    private String content;

    //通知类型
    //1: 评论；2:点赞；3:关注；4:系统
    private int type;

    //1:未读；2:已读；-1:删除
    private int status;

    private Date gmtCreate;

    private Date gmtModified;

    //查看通知的时间
    private Date gmtRead;

}
