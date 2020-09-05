package com.itcast.springcloud.dao;

import com.itcast.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-08-06 20:57
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentByid(@Param("id") Long id);
}
