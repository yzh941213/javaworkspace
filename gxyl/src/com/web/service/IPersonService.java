package com.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.common.Model;
import com.web.entity.Person;

public interface IPersonService {
	Integer getPersonAutoid(HttpServletRequest request);
	Person getPerson(HttpServletRequest request);
	Person getAccount(String account);
	Person getPersonByID(Integer personAutoid);
	void signOut(HttpServletRequest request);
	
	Model<Person> getPersonByPage(int pageindex, int pagesize, String personType);
	
	Person create(Person person);
	
	int modify(Person person);
	
	int delete(String autoids);
	
	int setPassword(String autoids, String password);
	List<Person> getPersonFromExcel(String realPath);
	int importPerson(List<Person> list);
}
