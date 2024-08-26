package com.bjb.lease.web.app.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 上午11:07
 */
@SpringBootTest
class SmsServiceImplTest
{
    @Autowired
    private SmsServiceImpl service;

    @Test
    void sendCode()
    {
        service.sendCode("18093984137", "1234");
    }
}