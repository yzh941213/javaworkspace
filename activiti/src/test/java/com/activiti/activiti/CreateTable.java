package com.activiti.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateTable {


    @Test
    public void create(){

        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();

        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC  ");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");

        pec.setDatabaseSchema(pec.getDatabaseSchemaUpdate());

        ProcessEngine processEngine = pec.buildProcessEngine();

        System.out.println("SUCCESS!");

    }

    @Test
    public void test4() {
        // 获得一个部署构建器对象，用于加载流程定义文件（test1.bpmn,test.png）完成流程定义的部署
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        DeploymentBuilder builder= processEngine.getRepositoryService().createDeployment();
        // 加载流程定义文件
        builder.addClasspathResource("demo.bpmn");
        // 部署流程定义
        Deployment deployment = builder.deploy();
        System.out.println(deployment.getId());
    }

    @Test
    public void test5() {
        //流程定义查询对象，用于查询act_re_procdef表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
        //添加查询条件
        query.processDefinitionKey("bxlc");
        query.orderByDeploymentId().desc();
        //分页查询
        query.listPage(0, 10);
        List<ProcessDefinition> list = query.list();
        for (ProcessDefinition item : list) {
            System.out.print(item.getId());
        }
    }
}
