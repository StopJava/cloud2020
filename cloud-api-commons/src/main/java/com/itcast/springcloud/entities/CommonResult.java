package com.itcast.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-08-08 23:32
 **/
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CommonResult<T>{
        private Integer code;
        private String message;
        private T   data;
        public CommonResult(Integer code, String message){
            this(code,message,null);
        }
    }

