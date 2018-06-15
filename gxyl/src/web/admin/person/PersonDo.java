package web.admin.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.HttpServletBase;

import com.common.Json;
import com.common.Model;
import com.common.Pager;
import com.common.Tools;
import com.google.gson.reflect.TypeToken;
import com.web.entity.Person;
import com.web.service.IPersonService;

@Controller("persondo")
@RequestMapping("admin/person/")
public class PersonDo extends HttpServletBase {
	@Autowired
	private IPersonService personService;

	@RequestMapping(value = "person.do", method = RequestMethod.GET)
	public ModelAndView person(int page, String personType) {
		int pagesize = 20;
		Model<Person> model = personService.getPersonByPage(page, pagesize,
				personType);
		List<Person> list = model.getList();
		int count = model.getCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		Pager pager = Pager.Init(page, pagesize, count);
		Map<String, Object> map2 = pager.getPagerMap(request);
		map.put("pager", map2);
		return new ModelAndView("admin/person/person", map);
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public ModelAndView edit(Integer personAutoid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Person person = personService.getPersonByID(personAutoid);
		map.put("person", person);
		map.put("action", "modify.do");
		return new ModelAndView("admin/person/edit", map);
	}

	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public ModelAndView add() {
		Map<String, Object> map = new HashMap<String, Object>();
		Person person = new Person();
		map.put("person", person);
		map.put("action", "create.do");
		return new ModelAndView("admin/person/edit", map);
	}

	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public ModelAndView modify(Person person) {
		String view = "admin/common/result";
		Map<String, Object> map = new HashMap<String, Object>();
		int result = personService.modify(person);
		if (result > 0) {
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()
					+ "/admin/person/person.do?page=1&personType=");
		} else {
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		return new ModelAndView(view, map);
	}

	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	public ModelAndView create(Person person) {
		String view = "admin/common/result";
		Map<String, Object> map = new HashMap<String, Object>();
		Person p=personService.getAccount(person.getAccount());
		if(p!=null){
			map.put("message", "用户名"+person.getAccount()+"已存在，请更改！");
			map.put("url", "javascript:history.back();");
		}else{
		String password = Tools.MD5("123456");
		person.setPassword(password);
		Person newPerson = personService.create(person);
		if (newPerson != null) {
			map.put("message", "保存成功！");
			map.put("url", request.getContextPath()
					+ "/admin/person/person.do?page=1&personType=");
		} else {
			map.put("message", "保存失败！");
			map.put("url", "javascript:history.back();");
		}
		}
		return new ModelAndView(view, map);
	}

	@ResponseBody
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(String autoids) {
		int result = personService.delete(autoids);
		return String.valueOf(result);
	}

	@ResponseBody
	@RequestMapping(value = "setPassword.do", method = RequestMethod.POST)
	public String setPassword(String autoids, String password) {
		String pwd = Tools.MD5(password);
		int result = personService.setPassword(autoids, pwd);
		return String.valueOf(result);
	}

	
	@ResponseBody
	@RequestMapping(value="check.do", method=RequestMethod.POST, produces={"text/html;charset=UTF8"})
	public String check(String account){
		Person person=personService.getAccount(account);
		if(person!=null){
			return "1";
		}else {
			return "0";
		}
	}

	@RequestMapping(value = "getPersonsFromExcel.do", method = RequestMethod.GET)
	public ModelAndView getPersonsFromExcel(String filePath) {
		String path = this.request.getSession().getServletContext()
				.getRealPath("/");
		String realPath = path + filePath;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Person> list = personService.getPersonFromExcel(realPath);
		map.put("list", list);
		String persons = Json.getGson().toJson(list);
		map.put("persons", persons);
		return new ModelAndView("admin/person/import", map);
	}

	@ResponseBody
	@RequestMapping(value = "importPerson.do", method = RequestMethod.POST)
	public String importPerson(String persons) {
		List<Person> list = Json.getGson().fromJson(persons,new TypeToken<List<Person>>() {}.getType());
		int result=personService.importPerson(list);
		return String.valueOf(result);
	}


}
