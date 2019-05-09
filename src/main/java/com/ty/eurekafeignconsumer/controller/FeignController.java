package com.ty.eurekafeignconsumer.controller;

import com.ty.eurekafeignconsumer.service.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    //这个地方有点坑，因为EurekaClientFeign已经有另外一个实现类就是BaseHystrix，使用@Autowired会报错
    //不过暂时不清楚@Resource会注入正确的bean，后续待研究。。。
    @Resource
    private EurekaClientFeign eurekaClientFeign;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "马云", required = false) String name) {

        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
