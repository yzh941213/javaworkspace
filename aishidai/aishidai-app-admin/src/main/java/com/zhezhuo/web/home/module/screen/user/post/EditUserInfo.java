package com.zhezhuo.web.home.module.screen.user.post;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.UserManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;
import com.zhezhuo.web.home.module.screen.BaseScreen;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Shaka on 15/4/5.
 */
@Controller
public class EditUserInfo extends BaseScreen {

    @Resource
    UserManager userManager;

    public void execute(@RequestParam("data") String json,
                        @RequestParam(value = "callback", defaultValue = "callback") String callback,
                        @RequestParam("actionType") int actionType,
                        @RequestParam(value = "fmt", defaultValue = "json") String fmt) {
        JSONObject jsonObject = new JSONObject();

//        if (false && CsrfToken.check(request) == false) {
//            jsonObject.put("success", false);
//            jsonObject.put("message", "token校验出错");
//            jsonObject.put("userId", -1);
//        }

        UserDO userDO = JSONObject.parseObject(json, com.zhezhuo.model.UserDO.class);
        if (userDO == null) {
            jsonObject.put("success", false);
            jsonObject.put("message", "提交的数据为空, 或者格式不正确");
            jsonObject.put("userId", -1);
            jsonObject.put("avatarURL", "");
            super.convertJsonP(jsonObject.toJSONString(), "json".equalsIgnoreCase(fmt) ? null : callback);
            return;
        }

//        if (StringUtil.isBlank(userDO.getName())) {
//            jsonObject.put("success", false);
//            jsonObject.put("message", "提交的数据中用户名为空");
//            jsonObject.put("userId", -1);
//            jsonObject.put("avatarURL", "");
//            return;
//        }

        //TODO: upload avatar file to server
        if (!StringUtils.isBlank(userDO.getAvatar())) {

        }

        Result result = null;
        if (StringUtils.isBlank(userDO.getNewpasswd())) {
            result = userManager.editUserInfo(userDO);
        } else {
            result = userManager.resetPassword(userDO);
        }

        if (result != null && result.isSuccess()) {
            jsonObject.put("success", result.isSuccess());
            jsonObject.put("message", "OK");
            jsonObject.put("userId", userDO.getId());
            jsonObject.put("avatarURL", "");
        } else {
            jsonObject.put("success", false);
            jsonObject.put("message", "操作失败");
            jsonObject.put("userId", -1);
            jsonObject.put("avatarURL", "");
        }
        super.convertJsonP(jsonObject.toJSONString(), "json".equalsIgnoreCase(fmt) ? null : callback);

    }

}
