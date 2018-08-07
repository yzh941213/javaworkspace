package com.spring.init_bean._4_xml;

import java.net.URL;

public class ResourceLoader {


    public Resource getResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);
        return new URLResource(url);
    }
}
