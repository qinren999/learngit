package com.jk.service;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("error")//防止和原有request冲突
@Component//注入spring容器 通过spring创建具体的实例对象
public class OrderServiceError implements OrderServiceFeign{
    @Override
    public Map<String, String> testGetRest() {
        return null;
    }


   /* @Override
    public Map<String, String> testGetRest() {
        return null;
    }*/

    /*@Override
    public void testRest(String s) {

    }*/

    /*@Override
    public void testRest(String s) {

    }*/
}
