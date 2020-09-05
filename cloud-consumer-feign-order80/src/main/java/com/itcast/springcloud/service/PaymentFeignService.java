package com.itcast.springcloud.service;

import com.itcast.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-02 18:39
 **/
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id);
}
