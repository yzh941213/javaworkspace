package com.common;

import java.util.List;

public class Model<T> {
	public Model(){
		
	}
	public Model(List<T> list, int count){
		this.list=list;
		this.count=count;
	}
	private List<T> list;
	private int count;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}