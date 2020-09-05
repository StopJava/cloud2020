package com.itcast.springcloud.service;

import com.itcast.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-08-06 22:43
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentByid(@Param("id") Long id);


}
