package com.jk.controller;

import com.jk.service.OrderServer2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
/*@RequestMapping("order")//。。删除*/
public class OrderController implements OrderServer2 {
    @Override
    public Map<String, String> testGetRest() {
        System.out.println("111111111111111");
        return null;
    }


    /*@DeleteMapping("rest")//。。删除*/
   /* public void testRest(){
        System.out.println("成功接收到删除请求");
    }

    *//*@GetMapping("rest")//。。删除*//*
    public Map<String,String> testGetRest(){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("message","成功接收到查询请求");
        return paramMap;
    }*/






}
