package com.aishidai.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${alishidai}")
    public  String testStr;

    @GetMapping("aaa")
    public String holleWord() {
        return testStr;
    }
}
