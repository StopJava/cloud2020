package com.itcast.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-03 21:16
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/TimeOut/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id);
}
