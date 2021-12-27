package com.tianqi.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 管理服务应用
 *
 * @Program: tq-spring-boot-admin
 * @Author: ytq
 * @Date: 2021/12/18 14:50:03
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class,args);
    }
}
