package com.ty.eurekafeignconsumer.hystrix;

import com.ty.eurekafeignconsumer.service.EurekaClientFeign;
import org.springframework.stereotype.Component;

//熔断处理类需要实现调用远程服务的service，例如本案例在EurekaClientFeign类中调用远程服务，就需要实现此接口，
//然后相同名字的方法就可以一一对应
@Component(value = "baseHystrix")
public class BaseHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return name + "访问的远程服务被熔断";
    }
}
