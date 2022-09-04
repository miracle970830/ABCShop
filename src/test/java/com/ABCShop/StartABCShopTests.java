package com.ABCShop;

import com.ABCShop.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartABCShopTests {
    @Autowired
    private GoodsService goodsService;
    @Test
    public void contextLoads() {
      /*  String md5DigestAsHex = DigestUtils.md5DigestAsHex("123123".getBytes());
        System.out.println("md5DigestAsHex = " + md5DigestAsHex);*/
    }

}
