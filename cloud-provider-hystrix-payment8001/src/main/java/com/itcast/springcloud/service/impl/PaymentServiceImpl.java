package com.itcast.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.itcast.springcloud.service.PaymentServcie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-09-03 11:39
 **/
@Service
public class PaymentServiceImpl implements PaymentServcie {
    @Override
    public String PaymentInfo_OK(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"o(n_n)o哈哈~";
    }

    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String PaymentInfo_TimeOut(Integer id) {
        int Timenumber = 3;
        try{ TimeUnit.SECONDS.sleep(Timenumber); }catch(InterruptedException e){e.printStackTrace();}
        //int a=10/0;
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"o(n_n)o哈哈~"+"  耗时（）:"+Timenumber;
    }
    public String PaymentInfo_TimeOutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"o(3__3)o 8001系统繁忙,请稍后尝试!";
    }
    //<----------服务熔断---------->
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "调用成功! "+Thread.currentThread().getName()+"\t"+"流水号: "+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数o(T o T)o"+"\t"+"id: "+id;
    }

}
