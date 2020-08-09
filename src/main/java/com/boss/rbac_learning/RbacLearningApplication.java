package com.boss.rbac_learning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.boss.rbac_learning.filter")
public class RbacLearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbacLearningApplication.class, args);
    }
}
