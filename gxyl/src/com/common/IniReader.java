package com.common;
import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException; 
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Properties; 


public class IniReader {
	protected HashMap sections = new HashMap(); 
	private transient String currentSecion; 
	private transient Properties current; 

	public IniReader(String filename) {
		BufferedReader reader=null;
		try{
			reader= new BufferedReader(new FileReader(filename));			
			read(reader);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}catch (IOException e) {

			}
		}
		
	} 

	protected void read(BufferedReader reader){ 
		String line;
		try{
		while ((line = reader.readLine()) != null) { 
			parseLine(line); 
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
	} 

	protected void parseLine(String line) { 
		HashMap<String, String> chl=new HashMap<String, String>();///
		line = line.trim(); 
		if (line.matches("\\[.*\\]")) { 
			currentSecion = line.replaceFirst("\\[(.*)\\]", "$1"); 
			current = new Properties(); 
			sections.put(currentSecion, current); 
			hl.put(currentSecion, chl);///
		} else if (line.matches(".*=.*")) { 
			if (current != null) { 
				int i = line.indexOf('='); 
				String name = line.substring(0, i); 
				String value = line.substring(i + 1); 
				current.setProperty(name, value);
				hl.get(currentSecion).put(name, value);///
			} 
		} 
	} 

	public String getValue(String section, String name) { 
		Properties p = (Properties) sections.get(section);
		if (p == null) { 
			return ""; 
		}
		String value = p.getProperty(name); 
		return value; 
	}
	private Map<String, HashMap<String, String>> hl= new HashMap<String, HashMap<String, String>>();
	public Map<String, String> getValue(String section){
		return hl.get(section);
	}
}
