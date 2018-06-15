package com.web.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.common.Model;
import com.common.Tools;
import com.web.dao.IPersonDao;
import com.web.entity.Person;
import com.web.service.IPersonService;

public class PersonServiceImpl implements IPersonService {

	private IPersonDao personDao;

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	public Integer getPersonAutoid(HttpServletRequest request){
		return getPerson(request).getPersonAutoid();
	}
	public Person getPerson(HttpServletRequest request){
		return (Person)request.getSession().getAttribute("person");
	}
	public Person getAccount(String account) {
		return personDao.getAccount(account);
	}

	public Person getPersonByID(Integer personAutoid){
		return personDao.getPersonByID(personAutoid);
	}
	/**
	 * 注销登陆，清空session
	 * */
	public void signOut(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	public Model<Person> getPersonByPage(int pageindex, int pagesize, String personType) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("personType", personType);
		List<Person> list=personDao.getPersonByPage(map);
		int count=personDao.getCount(map);
		Model<Person> model=new Model<Person>(list, count);
		return model;
	}
	
	public Person create(Person person){
		int result=personDao.create(person);
		return personDao.getPersonByID(person.getPersonAutoid());
	}
	
	public int modify(Person person){
		return personDao.modify(person);
	}

	public int delete(String autoids) {
		int[] ids=Tools.toArray(autoids, ",");
		return personDao.delete(ids);
	}

	public int setPassword(String autoids, String password) {
		int[] ids=Tools.toArray(autoids, ",");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("autoids", ids);
		map.put("password", password);
		return personDao.setPassword(map);
	}

	public List<Person> getPersonFromExcel(String realPath) {
		List<Person>persons=new ArrayList<Person>();
		File file = new File(realPath);
		// 获取excel文件
		Workbook workbook=null;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int i = 2; i < sheet.getRows(); i++) {
				String account=sheet.getCell(0, i).getContents();
				Person person=personDao.getAccount(account);
				//判断数据库中是否有该账号
				//如果没有则新建实例
				if(person==null){
					person=new Person();
				}
				person.setAccount(account);
				person.setName(sheet.getCell(1, i).getContents());
				person.setTelphone(sheet.getCell(2, i).getContents());
				person.setPassword(Tools.MD5("123456"));
				persons.add(person);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(workbook!=null){
				workbook.close();
			}
		}
		// 获取文件的指定工作表 默认的第一个
		return persons;
	}

	public int importPerson(List<Person> list) {
		
		return personDao.importPerson(list);
	}
}
