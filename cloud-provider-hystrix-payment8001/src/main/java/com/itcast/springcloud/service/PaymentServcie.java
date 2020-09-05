package com.itcast.springcloud.service;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-03 11:37
 **/
public interface PaymentServcie {
    public String PaymentInfo_OK(Integer id);

    public String PaymentInfo_TimeOut(Integer id);

    public String PaymentCircuitBreaker(Integer id);
}
