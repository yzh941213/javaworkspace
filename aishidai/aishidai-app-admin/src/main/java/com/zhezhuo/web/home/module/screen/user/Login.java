package com.zhezhuo.web.home.module.screen.user;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.UserDAO;
import com.zhezhuo.biz.manager.UserManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.UserDO;
import com.zhezhuo.web.home.module.screen.BaseScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Shaka on 15/6/8.
 */
@Controller
public class Login extends BaseScreen {

    @Resource
    UserDAO userDAO;

    @Autowired
    private UserManager userManager;

    @RequestMapping("/login.do")
    @ResponseBody
    public String execute(@RequestParam("userId") long userId,
                        @RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session) {
    	
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginSuccess", true);
        jsonObject.put("success", false);
        jsonObject.put("message", "");
        jsonObject.put("msg", "");
        jsonObject.put("userId", -1);
        jsonObject.put("userNick", "");
        jsonObject.put("errorCode", "-3");
        jsonObject.put("usertype", -1);

        Result<UserDO> result = userDAO.queryUserInfo(userName, password);

        if (result != null && result.isSuccess() && result.getResult() != null) {
            UserDO user = result.getResult();
            if(password != null && password.equals(user.getPassword())){
                session.setAttribute("admin"+user.getId(), user);
                jsonObject.put("loginSuccess", true);
                jsonObject.put("userId", user.getId());
                jsonObject.put("userNick", user.getNick());
                jsonObject.put("usertype", user.getSocialUserEnumId());
                jsonObject.put("success", true);
                jsonObject.put("message", "OK");
                jsonObject.put("msg", "OK");
                jsonObject.put("errorCode", 1);
            }else{
                jsonObject.put("loginSuccess", false);
                jsonObject.put("success", true);
                jsonObject.put("message", "用户名或者密码错误");
                jsonObject.put("msg", "用户名或者密码错误");
                jsonObject.put("errorCode", -1);
            }
        } else{
            jsonObject.put("loginSuccess", false);
            jsonObject.put("success", true);
            jsonObject.put("message", "用户未注册");
            jsonObject.put("msg", "用户未注册");
            jsonObject.put("errorCode", -2);
        }
       return jsonObject.toString();
    }
}
