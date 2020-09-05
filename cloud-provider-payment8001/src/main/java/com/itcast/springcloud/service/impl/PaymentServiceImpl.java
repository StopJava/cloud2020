package com.itcast.springcloud.service.impl;

import com.itcast.springcloud.dao.PaymentDao;
import com.itcast.springcloud.entities.Payment;
import com.itcast.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-08-06 22:44
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentByid(Long id) {
        return paymentDao.getPaymentByid(id);
    }
}
