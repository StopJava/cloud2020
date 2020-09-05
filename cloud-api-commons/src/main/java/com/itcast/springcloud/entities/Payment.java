package com.itcast.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:cloud2020
 * @description:
 * @autor:dpf
 * @create:2020-08-08 23:31
 **/
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Payment implements Serializable {
        private Long id;
        private String serial;
    }

