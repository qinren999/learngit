package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "cloud-provider",fallback = OrderServiceError.class)//封装了ribbon的功能//..删除
/*@RequestMapping("order")//..删除
@Service*/
@Service
public interface OrderServiceFeign extends OrderServer2{



}
