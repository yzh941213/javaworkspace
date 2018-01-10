package com.aishidai.app.utils;


import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JniInterface
{
  static Logger logger = LoggerFactory.getLogger(JniInterface.class);
  
  static
  {
    if (EnvConfig.isDevelop()) {
      System.load("/usr/local/lib/libFace3DGen.so");
    }
  }
  
  public native boolean Init();
  
  public native boolean LoadFaceModel(String paramString);
  
  public native boolean InitModelFace(String paramString);
  
  public native Map<String, Object> FaceGenerate(String paramString,int color,int val);
  
  public native void Destory();
}
