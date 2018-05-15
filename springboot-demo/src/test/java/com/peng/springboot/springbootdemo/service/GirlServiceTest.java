package com.peng.springboot.springbootdemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;
    @Test
    public void getAgeById() throws Exception {
        Assert.assertEquals(new Integer(18),girlService.getAgeById(new Integer(14)));
    }
}