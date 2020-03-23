package com.lpc.service;

import com.lpc.entity.Student;
import com.lpc.service.impl.StudentError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//value里的值是服务提供者的名字
//fallback的值是这个接口的实现类，用于在出错时返回友好的信息
@FeignClient(value = "provider", fallback = StudentError.class)
public interface StudentFeignClient {
    //各个@RequestMapping注解里的值，就是服务提供者里的url除了ip和端口号的那些

    @GetMapping("/provider/students")
    public List<Student> getStudents();

    //像这个请求里带PathVariable的，在方法的参数里也要加上@PathVariable注解
    @GetMapping("/provider/student/{id}")
    public Student getStudentById(@PathVariable("id") int id);

    @GetMapping("/provider/port")
    public String getPort();
}
