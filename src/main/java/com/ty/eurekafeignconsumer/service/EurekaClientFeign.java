package com.ty.eurekafeignconsumer.service;

import com.ty.eurekafeignconsumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-provider", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    //只需要在接口中定义方法即可。调用eureka-provider服务的firstCall方法，并且feign集成了Ribbon
    @GetMapping(value = "/firstCall")
    String sayHiFromClientEureka(@RequestParam("name") String name);
}
