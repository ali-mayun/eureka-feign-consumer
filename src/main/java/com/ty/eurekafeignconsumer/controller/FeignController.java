package com.ty.eurekafeignconsumer.controller;

import com.ty.eurekafeignconsumer.service.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "马云", required = false) String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
