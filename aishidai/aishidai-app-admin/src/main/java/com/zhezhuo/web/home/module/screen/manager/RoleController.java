package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.RoleManager;
import com.zhezhuo.biz.util.EnvConfig;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RoleDO;
import com.zhezhuo.zz.facegen.api.JniInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
@Controller
@RequestMapping("/manager/role")
public class RoleController {

    @Autowired
    RoleManager roleManager;
    
    
    public static JniInterface jniInterface = new JniInterface();
    public static String model = "model1";
    public static boolean isStart = false;
    static{
  	  if (EnvConfig.isDevelop())
  	    {
  		    jniInterface.Init();
  		    jniInterface.LoadFaceModel("/usr/local/share/terminfo/"+model);
  		    jniInterface.InitModelFace("/usr/local/share/terminfo/"+model);
  	    }
    }
    

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public String addRoleDO(@RequestParam(value = "name", defaultValue = "")String name,
                            @RequestParam(value = "description", defaultValue = "")String description,
                            @RequestParam(value = "createrId", defaultValue = "0")long createrId,
                            @RequestParam(value = "nick", defaultValue = "admin")String nick,
                            @RequestParam(value = "feature", defaultValue = "")String feature) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        RoleDO roleDO = new RoleDO();
        roleDO.setName(name);
        roleDO.setNick(nick);
        roleDO.setDescription(description);
        roleDO.setCreaterId(createrId);
        roleDO.setFeature(feature);

        Result<Long> result = roleManager.addRoleDO(roleDO);
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }

    @RequestMapping(value = {"/update.do","/del.do"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateRoleDO( @RequestParam(value = "id", defaultValue = "0")long id,
                                @RequestParam(value = "name", defaultValue = "")String name,
                                @RequestParam(value = "description", defaultValue = "")String description,
                                @RequestParam(value = "createrId", defaultValue = "0")long createrId,
                                @RequestParam(value = "feature", defaultValue = "")String feature,
                                @RequestParam(value = "nick", defaultValue = "")String nick,
                                @RequestParam(value = "isDeleted", defaultValue = "0")int isDeleted) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        RoleDO roleDO = new RoleDO();
        roleDO.setId(id);
        roleDO.setName(name);
        roleDO.setDescription(description);
        roleDO.setNick(nick);
        roleDO.setCreaterId(createrId);
        roleDO.setFeature(feature);
        roleDO.setIsDeleted(isDeleted);

        Result<Long> result = roleManager.updateRoleDO(roleDO);
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }

    @RequestMapping(value = "/query.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryRoleDO() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<List<RoleDO>> result = roleManager.queryAllRole();
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }
    
    @RequestMapping(value="/model/path", method= RequestMethod.GET)
    @ResponseBody
    public synchronized String execute(@RequestParam("path") String path,
							    		@RequestParam("type") String type,
							    		@RequestParam("colourNumber") int colourNumber,
							    		@RequestParam("number") int number)
    {
       JSONObject jsonObject = new JSONObject();
  	   if(isStart){
  		   System.out.println("进线程了");
  		    try
  		      {
  		        wait();
  		        System.out.println("已有人在使用，请稍后");
  		      }
  		      catch (InterruptedException e)
  		      {
  		        e.printStackTrace();
  		      }
  	    }
  	    isStart = true;
  	    if (type.equals(model)) {
  	    	System.out.println("直接计算图片");
  	    	notifyAll();
  	    	isStart = false;
  	    	jsonObject.put("success", true);
            jsonObject.put("map", getMap(path,colourNumber,number));
  	    	return jsonObject.toString();
  	    }else{
  	    	jniInterface.Destory();
  	 	    if (EnvConfig.isDevelop())
  	 	    {
  	 		      jniInterface.Init();
  	 		      jniInterface.LoadFaceModel("/usr/local/share/terminfo/"+type);
  	 		      jniInterface.InitModelFace("/usr/local/share/terminfo/"+type);
  	 	    }
  	 	    model = type;
  	 	    System.out.println("=============================="+path);
  	 	    Map<String, Object> map = new HashMap<String, Object>();
  	 	    map= jniInterface.FaceGenerate(path,colourNumber,number);
  	 	    System.out.println("11111111111111111111111111111111"+path);
  	 	    isStart = false;
  	 	    System.out.println("2222222222222222222222222222222222"+path);
  	 	    notifyAll();
  	 	    System.out.println("3333333333333333333333333333333333333"+path);
  	 	    jsonObject.put("success", true);
  	 	    jsonObject.put("map", map);
	    	return jsonObject.toString();
  	    }
    }
    
    public Map<String, Object> getMap(String path,int colourNumber, int number){
  	 Map<String, Object> map = new HashMap<String, Object>();
  	 map = jniInterface.FaceGenerate(path,colourNumber,number);
  	 return map;
    }
}
