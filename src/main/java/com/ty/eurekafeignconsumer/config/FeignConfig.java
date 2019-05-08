package com.ty.eurekafeignconsumer.config;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        //调用远程服务失败后，会进行重试。重试间隔为1s，最大尝试次数为5
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}
