package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Person;

public interface IPersonDao {
	Person getAccount(String account);
	Person getPersonByID(Integer personAutoid);
	List<Person> getPersonByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	int create(Person person);
	int modify(Person person);
	int delete(int[] autoids);
	
	int setPassword(Map<String, Object> map);
	int importPerson(List<Person> list);
}
