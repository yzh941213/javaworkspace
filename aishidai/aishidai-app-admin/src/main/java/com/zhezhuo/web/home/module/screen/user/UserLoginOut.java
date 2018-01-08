package com.zhezhuo.web.home.module.screen.user;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.model.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 蝈蝈 on 2016/10/8.
 */
@Controller
public class UserLoginOut {

    @RequestMapping("/out.do")
    @ResponseBody
    public String loginOut(@RequestParam("userId") long userId,
                           HttpSession session){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        UserDO userDO = (UserDO) session.getAttribute("user"+userId);
        if (userDO == null) {
            jsonObject.put("success", true);
            jsonObject.put("message", "success");
            return jsonObject.toString();
        }

        try {
            session.removeAttribute("admin"+userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "success");
        return jsonObject.toString();
    }
}
