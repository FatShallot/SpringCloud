package com.lpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableCircuitBreaker声明启用数据监控
//@EnableHystrixDashboard声明启用可视化的数据监控
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    //启动以后，访问http://localhost:33000/actuator/hystrix.stream进入监控

    //访问http://localhost:33000/hystrix进入可视化监控，可视化监控需要一个url，就是上面的http://localhost:33000/actuator/hystrix.stream，然后随便取一个title
}
