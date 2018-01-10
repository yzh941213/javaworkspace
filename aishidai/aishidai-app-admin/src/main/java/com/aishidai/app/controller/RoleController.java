package com.aishidai.app.controller;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.RoleDO;
import com.aishidai.app.service.RoleService;
import com.aishidai.app.utils.EnvConfig;
import com.aishidai.app.utils.JniInterface;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/manager/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    
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
    public String addRoleDO(@RequestParam(value = "name", required = true)String name,
                            @RequestParam(value = "description", defaultValue = "")String description,
                            @RequestParam(value = "userId", required = true)long userId,
                            @RequestParam(value = "nick", defaultValue = "admin")String nick,
                            @RequestParam(value = "feature", defaultValue = "")String feature) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        
		try {
			RoleDO roleDO = new RoleDO();
	        
	        roleDO.setName(name);
	        roleDO.setNick(nick);
	        roleDO.setDescription(description);
	        roleDO.setCreaterid(userId);
	        roleDO.setFeature(feature);
	        roleDO.setIsdeleted((byte)0);
	        roleDO.setUpdated(System.currentTimeMillis());
	        roleDO.setCreated(System.currentTimeMillis());
	        
	        long result = roleService.addRoleDO(roleDO);
			if (result >= 0) {
	            jsonObject.put("success", true);
	            jsonObject.put("message", "添加成功");
	            return jsonObject.toString();
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        jsonObject.put("message", "添加失败");
        return jsonObject.toString();
    }
    
    
    
    @RequestMapping(value = {"/update.do"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateRoleDO( @RequestParam(value = "id",required = true)long id,
                                @RequestParam(value = "name")String name,
                                @RequestParam(value = "userId", required = true)long userId,
                                @RequestParam(value = "description")String description,
                                @RequestParam(value = "feature")String feature,
                                @RequestParam(value = "nick")String nick) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<Long> result;
		try {
			RoleDO roleDO = new RoleDO();
	        roleDO.setId(id);
	        roleDO.setName(name);
	        roleDO.setDescription(description);
	        roleDO.setNick(nick);
	        roleDO.setCreaterid(userId);
	        roleDO.setFeature(feature);
	        roleDO.setUpdated(System.currentTimeMillis());
			result = roleService.updateRoleDO(roleDO);
			 if (result != null && result.isSuccess()) {
		            jsonObject.put("success", true);
		            jsonObject.put("data", result.getResult());
		            jsonObject.put("message", result.getSuccessInfo());
		            return jsonObject.toString();
		        }
			 jsonObject.put("data", result.getResult());
		     jsonObject.put("message", result.getErrorInfo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        return jsonObject.toString();
    }
    
    @RequestMapping(value = {"/remove.do"})
    @ResponseBody
    public String remove(@RequestParam(value = "id",required = true)long id){
		
    	 JSONObject jsonObject = new JSONObject();
         jsonObject.put("success", false);
         try {
			RoleDO roleDO = roleService.queryByPrimaryKey(id);
			if (roleDO != null) {
				
				roleDO.setIsdeleted((byte)1);
				roleDO.setUpdated(System.currentTimeMillis());
				Result<Long> result = roleService.updateRoleDO(roleDO);
				
				if (result.getResult() != null) {
					 jsonObject.put("message", "删除成功");
					 jsonObject.put("success", true);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return jsonObject.toString();
    	
    }
    
    @RequestMapping(value = "/queryList.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryRoleDO() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        
        List<RoleDO> list = null;
		try {
			list = roleService.queryAllRole();
	        jsonObject.put("data", list);
	        jsonObject.put("success", true);
	        jsonObject.put("message", "查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
