package com.boss.rbac_learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class RbacLearningApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }

}
