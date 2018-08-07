package com.admin;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniFactorySupport;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroRoleTest {


    @Test
    public void test(){
       Subject subject = login("yzh","123");

       Assert.assertTrue(subject.hasRole("role1"));

       Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1","role2")));

        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);

    }

    @Test
    public void test1(){
        Subject subject = login("yzh","123");

        subject.isPermitted("user:create");

        subject.isPermitted("yzh:create","yzh:update");

        System.out.println(subject.isPermitted("test:delete:delete"));

    }



    public Subject login(String username,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Assert.assertEquals(true,subject.isAuthenticated());
        return subject;
    }
}
