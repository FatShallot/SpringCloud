package com.lpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableZuulProxy说明该类是网关的启动类。视频里说包含里@EnableZuulServer，但我点进去并没有发现
@EnableZuulProxy
@EnableAutoConfiguration
//注意不需要加@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
