package web.news;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.web.entity.Person;

public class SpringDao extends Lsds {

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		System.out.println("hello "+string);
		scanner=new Scanner(System.in);
		System.out.println("你好 "+scanner.nextLine());
		JSONArray ja=new JSONArray();
		JSONObject jObject=new JSONObject();
		Person person=new Person();
		jObject.put("a", 1);
		jObject.put("b", 2);
		jObject.put("p", person);
		ja.add(jObject);
		System.out.println(jObject.toJSONString());
		System.out.println(ja.toJSONString());
		JSONParser jp=new JSONParser();
		
		char c='c';
		int d;
		Character chars=new Character(c);
		Collection<String> coll=new ArrayList<String>();
		Set<Object> set=new HashSet<Object>();
		TreeSet<Object> treeSet=new TreeSet<Object>();
		Set<Object> obeset=new TreeSet<Object>();
		HashMap<Object, String> hashMap=new HashMap<Object, String>();
		java.lang.String.class.getClass().getClass().getClass();
		try{
			Context von=new InitialContext();
			DataSource dSource=(DataSource)von.lookup("");
			dSource.getConnection();
		}catch (Exception e) {
			// TODO: handle exception
		
		}
		Map<String, Object> lMap=new LinkedHashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		lMap.put("a", 1);
		lMap.put("b", 2);
		lMap.put("c", 3);
		map.put("x", 1);
		map.put("y", 2);
		map.put("z", 3);
		String lstr=JSONValue.toJSONString(lMap);
		String mstr=JSONValue.toJSONString(map);
		System.out.println("LinkedHashMap="+lstr);
		System.out.println("HashMap="+mstr);
		List<Object> lo=new LinkedList<Object>();
		List<Object> led=new ArrayList<Object>();
		Integer[] ints={};
		
	}
	
	/**
	 * @param config
	 */
	public void getsd(ServletConfig config){
		try{
			Socket socket=new Socket("", 21);
		}catch (IOException e) {
			
		}
	}
	@Override
	public String toString(){
		Calendar calendar=Calendar.getInstance();
		calendar.getTime();
		return "";
	}

	@Override
	public void toDo() {
		// TODO Auto-generated method stub
		
	}
}
abstract class Lsds{
	public abstract void toDo();
	public void put(){
		Computer computer=Computer.getComputer();
		Sinlg.INSTS.doSomeThing();
		Sinlg.BOOK.doSomeThing();
	}
}
class Computer{
	private Computer(){}
	private static Computer computer;
	public static synchronized Computer getComputer(){
		if(computer==null){
			return new Computer();
		}else{
			return computer;
		}
	}
	public static Computer initComputer(){
		if(computer==null){
			synchronized (Computer.class) {
				if(computer==null){
					computer=new Computer();
				}
			}
		}
		return computer;
	}
}
enum Sinlg{
	INSTS,BOOK;
	public void doSomeThing(){}
}