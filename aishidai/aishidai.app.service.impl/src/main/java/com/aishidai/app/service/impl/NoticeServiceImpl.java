package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.NoticeDAO;
import com.zhezhuo.biz.dao.NoticeTypeDAO;
import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.AppPushManager;
import com.zhezhuo.biz.manager.NoticeManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.NoticeDO;
import com.zhezhuo.model.entity.NoticeTypeDO;
import com.zhezhuo.model.query.NoticeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public class NoticeServiceImpl implements NoticeManager {

    @Autowired
    NoticeDAO noticeDAO;

    @Autowired
    NoticeTypeDAO typeDAO;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    AppPushManager appPushManager;

    private Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    
    public Result<List<NoticeDO>> queryNoticeList(NoticeQuery query) {
        Result<List<NoticeDO>> result = new Result<List<NoticeDO>>();
        try {
            query.setTotalItem(noticeDAO.queryNoticeDOListCount(query));
            List<NoticeDO> noticeDOs = noticeDAO.queryNoticeDOList(query);
            for (NoticeDO n : noticeDOs) {
                String typeName = typeDAO.queryNoticeTypeName(n.getNoticeType());
                n.setTypeName(typeName == null ? "":typeName);
            }
            result.setResult(noticeDOs);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(""+e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<NoticeDO> queryNoticeDOById(long noId) {
        Result<NoticeDO> result = new Result<NoticeDO>();
        try {
            NoticeDO noticeDO = noticeDAO.queryNoticeDOById(noId);
            String typeName = typeDAO.queryNoticeTypeName(noticeDO.getNoticeType());
            noticeDO.setTypeName(typeName == null ? "":typeName);
            result.setResult(noticeDO);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("" + e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<Long> delNoticeDOById(long noId) {
        Result<Long> result = new Result<Long>();
        try {
            long row =  noticeDAO.delNoticeDOById(noId);
            if (row > 0) {
                result.setSuccess(true);
                result.setResult(row);
                return result;
            }
            result.setSuccess(false);
            result.setResult(-1l);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(""+e.getMessage());
            result.setSuccess(false);
            result.setResult(-1l);
            return result;
        }
    }

    
    public Result<Long> addNoticeDO(final NoticeDO noticeDO) {
        Result<Long> result = new Result<Long>();
        try {
            // TODO: 2016/9/26 推送通知
            /*final List<String> iosClientIds = usersDAO.queryIOSClientId();
            if (!iosClientIds.isEmpty()) {
                Thread thread = new Thread(){
                    
                    public void run() {
                        appPushManager.pushToAppIOS(noticeDO.getTitle(),noticeDO.getContent(),iosClientIds);
                    }
                };
                thread.start();
            }*/
            long row = noticeDAO.addNoticeDO(noticeDO);
            if (row > 0) {
                result.setSuccess(true);
                result.setResult(noticeDO.getNoId());
                return result;
            }
            result.setSuccess(false);
            result.setResult(-1l);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(""+e.getMessage());
            result.setSuccess(false);
            result.setResult(-1l);
            return result;
        }
    }

    
    public Result<List<NoticeTypeDO>> queryNoticeTypeList() {
        Result<List<NoticeTypeDO>> result = new Result<List<NoticeTypeDO>>();
        try {
            List<NoticeTypeDO> typeDOs = typeDAO.queryNoticeDOList();
            result.setResult(typeDOs);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(""+e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

}
