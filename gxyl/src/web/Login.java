package web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Json;
import com.common.Tools;
import com.web.entity.Person;
import com.web.service.IPersonService;

import base.HttpServletBase;
@Controller("login")
@RequestMapping("/")
public class Login extends HttpServletBase {
	@Autowired
	private IPersonService personService;
	@ResponseBody
	@RequestMapping(value="login.do",method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String login(String account, String password){
		password = Tools.MD5(password);
		Map<String, Object> map=new HashMap<String, Object>();
		Person person = personService.getAccount(account);
		if (person == null) {
			map.put("flag", "bad");
			map.put("msg", "账号错误");
		} else if (!password.equals(person.getPassword())) {
			map.put("flag", "bad");
			map.put("msg", "密码错误");
		} else {
			map.put("flag", "ok");
			map.put("msg", "登陆成功");
			map.put("personType", person.getPersonType());
			map.put("person", person);
			
			request.getSession().setAttribute("person", person);
			if(person.getPersonType().equals("admin")) {
				map.put("url", "admin/index.do");
			}else if(person.getPersonType().equals("teacher")) {
				map.put("url", "teacher/resourcemanager/ResourceManager/index.do?menuid=19");
			}else{
				map.put("url", "index.do");
			}
		}
		String result=Json.getJson().toJson(map);
		return result;
	}
	@ResponseBody
	@RequestMapping(value="getCode.do", method=RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public String getCode(){
		if(request.getSession().getAttribute("rand")==null){
			return "-1";
		}
		String code=request.getSession().getAttribute("rand").toString();
		return code;
	}
	@ResponseBody
	@RequestMapping(value="exit.do", method=RequestMethod.POST)
	public String exit(){
		personService.signOut(request);
		return "1";
	}
}
