package com.itcast.springcloud.controller;

import com.itcast.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-03 21:39
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "Payment_Global_FallbackMethod")
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.PaymentInfo_OK(id);
        log.info("********result:"+result);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/TimeOut/{id}")
    @HystrixCommand
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a=10/0;
        String result = paymentHystrixService.PaymentInfo_TimeOut(id);
        log.info("********result:"+result);
        return result;
    }
    public String PaymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒后尝试或者自己运行出错检查自己";
    }
    public String Payment_Global_FallbackMethod(){
        return "Global异常处理请稍后再试！";
    }
}
