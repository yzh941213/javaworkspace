package com.admin;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Key;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShiroBase64 {


    @Test
    public void test(){



    }


    public static void main(String[] args) {
        //salt();
        //simpleHash();
        aes();
    }



    public static void base64(){
        String str = "hello";
        String baseDecode = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(baseDecode);

        Assert.assertEquals(str,str2);
    }


    public static void salt(){
        String str = "hello";
        String salt = "123";

        //String md5 = new Md5Hash(str,salt).toString();
       String md5 = new Sha256Hash(str,salt).toString();

        System.out.println(md5);
    }



    public static void simpleHash(){
        String str = "hello";
        String salt = "456";
        String md5 = new SimpleHash("md5",str,salt).toString();
        String sha256 = new SimpleHash("SHA-1",str,salt).toString();
        System.out.println(md5);
        System.out.println(sha256);
    }



    public void hashService(){
        DefaultHashService hashService = new DefaultHashService();

    }



    public static void aes(){
        AesCipherService aes = new AesCipherService();
        aes.setKeySize(128);
        Key key = aes.generateNewKey();
        String text = "hello";
        String encryptText = aes.encrypt(text.getBytes(),key.getEncoded()).toHex();
        String text2 = new String(aes.decrypt(Hex.decode(encryptText),key.getEncoded()).getBytes());

        Assert.assertEquals(text,text2);

    }

}
