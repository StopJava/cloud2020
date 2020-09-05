package com.itcast.springcloud.controller;

import com.itcast.springcloud.service.PaymentServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-03 14:21
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentServcie paymentServcie;
    @Value("${server.port}")
    private String serverport;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentServcie.PaymentInfo_OK(id);
        log.info("*****result"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/TimeOut/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentServcie.PaymentInfo_TimeOut(id);
        log.info("*****result"+result);
        return result;
    }
    @GetMapping("/payment/circuit/{id}")
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id){
        String result =  paymentServcie.PaymentCircuitBreaker(id);
        log.info("*****result"+result);
        return result;
    }
}
