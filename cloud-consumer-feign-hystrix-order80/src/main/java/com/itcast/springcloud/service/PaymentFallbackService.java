package com.itcast.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-04 18:48
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String PaymentInfo_OK(Integer id) {
        return "对方服务器已经宕机";
    }

    @Override
    public String PaymentInfo_TimeOut(Integer id) {
        return "对方服务器已经宕机";
    }
}
