package com.jk.service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("order")
public interface OrderServer2 {
    @GetMapping("queryRest")
    Map<String, String> testGetRest();
    /*void testRest(String orderId);*/




    /*   Map<String, String> testGetRest();*/

    /*void testRest(String orderId);*/

}
