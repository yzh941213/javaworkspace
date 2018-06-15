package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		int port=8899;
		ServerSocket server=new ServerSocket(port);
		while(true){
			Socket socket=server.accept();
			new Thread(new Task(socket)).start(); 
		}
	}
}

class Task implements Runnable{
	private Socket socket;
	public Task(Socket socket){
		this.socket=socket;
	}
	public void run(){
		try{
			handleSocket();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
     * 跟客户端Socket进行通信 
    * @throws Exception 
     */  
    private void handleSocket() throws Exception {  
       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));  
       StringBuilder sb = new StringBuilder();  
       String temp;  
       int index;  
       while ((temp=br.readLine()) != null) {  
          System.out.println(temp);  
          if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
           sb.append(temp.substring(0, index));  
              break;  
          }  
          sb.append(temp);  
       }  
       System.out.println("客户端: " + sb);  
       //读完后写一句  
     Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");  
       writer.write("你好，客户端。");  
       writer.write("eof\n");  
       writer.flush();  
       writer.close();  
       br.close();  
       socket.close();  
    }  
}
