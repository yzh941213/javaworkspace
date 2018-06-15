package com.dao;

import com.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yzh on 2017/9/1.
 */
public interface TestDao {


    List<Test>list();

    void add();

    void update();

}
