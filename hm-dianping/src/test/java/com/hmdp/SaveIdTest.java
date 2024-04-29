package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SaveIdTest {
    @Autowired
    private ShopServiceImpl shopService;
    @Test
    public void testSave2(){
        shopService.saveShop2Redis(1l,30l);
    }
}
