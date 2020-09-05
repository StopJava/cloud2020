package com.itcast.springcloud.controller;

import com.itcast.springcloud.entities.CommonResult;
import com.itcast.springcloud.entities.Payment;
import com.itcast.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-02 18:47
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment>getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentByid(id);
    }
}
