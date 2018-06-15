package system.uitls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径如：f:/fqf.txt
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				// 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024 * 5];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数文件大小
					// System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				fs.close();
				inStream.close();
			}

		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");

			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			// filePath = filePath.toString();
			File myDelFile = new File(filePath);
			boolean bl = myDelFile.delete();
			System.out.println("删除文件操作" + bl);

		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	public static String[] split(String str) {
		char[] ss = str.toCharArray();
		String res = "";
		String footer = "";
		int i = 0;
		for (i = ss.length - 1; i >= 0; i--) {
			int ascValue = (int) ss[i];
			if (ascValue >= 48 && ascValue <= 57) {
				res = String.valueOf(ss[i]);// 将char类型转换成String

				footer = res + footer;
			} else {
				break;
			}

		}
		String header = str.substring(0, i + 1);
		String[] arr = { header, footer };
		return arr;
	}

	/**
	 * 将字符串用chars分隔，并转换到int数组中
	 * 
	 * @param str
	 * @param chars
	 *            分隔符
	 * @return 整数型数组
	 * */
	public static int[] toArray(String str, String chars) {
		if (str != null){
			if (!str.equals("")) {
				String[] arrStr = str.split(chars);
				int[] arrInt = new int[arrStr.length];
				for (int i = 0; i < arrStr.length; i++) {
					int number = Integer.parseInt(arrStr[i]);
					arrInt[i] = number;
				}
				return arrInt;
			}
		}
		return null;
	}

	public static int sum(int[] arr) {
		int sums = 0;
		if (arr != null) {
			for (int i : arr) {
				sums += i;
			}
		}
		return sums;
	}

	/**
	 * 截取字符串指定的长度
	 * 
	 * @param str
	 *            字符串
	 * @param length
	 *            长度
	 * @return 字符串
	 * */
	public static String subString(String str, int length) {
		if (str == null) {
			return "";
		}
		if (str.length() <= length) {
			return str;
		} else {
			return str.substring(0, length);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param fileSize
	 *            文件大小，字节
	 * @param filePath
	 *            在服务器上的相对路径
	 * @return
	 * */
	public static String download(HttpServletRequest request,
			HttpServletResponse response, int fileSize, String filePath) {
		try {
			String realPath = request.getRealPath("");
			String contextPath = request.getContextPath();
			filePath = filePath.replace(contextPath, "");
			filePath = filePath.replace("/", "\\");
			String fileName = filePath
					.substring(filePath.lastIndexOf("\\") + 1);
			realPath = (realPath + filePath);
			OutputStream out = response.getOutputStream();
			byte by[] = new byte[fileSize];
			File fileLoad = new File(realPath);
			response.reset();
			response.setContentType("application/x-download");
			response.setHeader("content-disposition", "attachment; filename="
					+ fileName);
			long fileLength = fileLoad.length();
			String length1 = String.valueOf(fileLength);
			response.setHeader("Content_Length", length1);

			FileInputStream in = new FileInputStream(fileLoad);
			int n;
			while ((n = in.read(by)) != -1) {
				out.write(by, 0, n);
			}

			in.close();
			out.flush();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 过滤掉html标签
	 * */
	public static String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;

		Pattern p_html1;
		Matcher m_html1;

		try {
			String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>
			String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	/**
	 * 创建Cookie
	 * @param name
	 * @param value
	 * @param minutes cookie保存的时间长度（分钟） 
	 * */
	public static void setCookie(String name, Object value, int minutes, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, String.valueOf(value));
		cookie.setMaxAge(60 * minutes);// Cookie的有效期是以秒为单位
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * 获取Cookie
	 * 
	 * @param name
	 * @return
	 * */
	public static Cookie getCookie(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cna = c.getName();
				if (c.getName().equals(name)) {
					cookie = c;
					break;
				}
			}
		}
		return cookie;
	}

	/**
	 * 写日志到文本文件，生成的是HTML文件
	 * */
	public static void writeLog(String txt, HttpServletRequest request)
			throws IOException {
		String realPath = request.getRealPath("/").replace("\\", "/");
		realPath += "logs/";
		File direct = new File(realPath);
		if (!direct.exists()) {
			direct.mkdir();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String fileName = sdf.format(date) + ".txt";
		File file = new File(realPath + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(realPath + fileName, true);
		txt += "\r\n";
		fw.write(txt);
		fw.flush();
		fw.close();

	}

	public String readLog() {
		return null;
	}

	/**
	 * 正则校验电话号
	 * 
	 * @param mobileNumber
	 *            String类型的电话号字符串
	 * @return 返回一个boolean型标记
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Pattern regex = Pattern
					.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
			Matcher matcher = regex.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 正则校验邮箱
	 * 
	 * @param email
	 *            String类型的邮箱字符串
	 * @return 返回一个boolean型标记
	 */
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 对list中的元素倒排
	 * */
	public static List sortOrder(List list){
		List<Object> list2=new ArrayList<Object>();
		for(Object object: list){
			list2.add(0, object);
		}
		return list2;
	}
	/**
	 * 对集合进行Grid转换，适用于easyui-grid数据格式
	 * */
	public static <T>Map<String, Object> convertGridData(List<T> list, int count){		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		return map;
	}
	
	public static Map<String, Object> parseMap(Object obj){
		Map<String, Object> map=new HashMap<String, Object>();
		Class clazz=obj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		try{
			for(Field f:fields){
				PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);  
				Method getMethod = pd.getReadMethod();//获得get方法  
				Object o = getMethod.invoke(obj);//执行get方法返回一个Object
				map.put(f.getName(), o);
			}
		}catch (IntrospectionException  e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {  
	        e.printStackTrace();  
	    }catch (InvocationTargetException e) {  
	        e.printStackTrace();  
	    }
	    return map;
	}
	
	public static List<Map<String, String>> getFilePath(String pathName){
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();		
		File[] fileList=null;
		if(pathName==null){
			fileList=File.listRoots();			
		}else {
			File file=new File(pathName);
			fileList=file.listFiles();			
		}
		for(File f: fileList){
			String Name=f.getPath();
			System.out.println("Name的值是"+Name);
			if(pathName==null){
				if(!Name.equals("/")){
					Name=Name.substring(0,Name.indexOf("\\")-1);
				}
			}else{
				if(Name.indexOf("/")<0){
					Name=Name.substring(Name.lastIndexOf("\\")+1);
				}else{
					Name=Name.substring(Name.lastIndexOf("/")+1);
				}
			}
			Map<String, String> fileMap=new HashMap<String, String>();
			fileMap.put("id",f.getPath());
			fileMap.put("text",Name);
			if(f.isDirectory() && f.listFiles()!=null && f.listFiles().length>0){
				fileMap.put("state","closed");
			}else {
				fileMap.put("state","open");
			}
			list.add(fileMap);
		}
		return list;
	}
	
	/**生成随机id字符串*/
	public static String randID(){
		String str=UUID.randomUUID().toString();
		String id=str.substring(0,8);
		return id;
	}
	
	public static String numberFormat(int num){
		String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
		char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		return sb.toString();

	}
}