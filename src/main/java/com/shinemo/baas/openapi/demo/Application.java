package com.shinemo.baas.openapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动类
 *
 * @author dongzj
 * @date 2020/8/28 14:26
 */
@SpringBootApplication
@ImportResource(locations = "classpath:application-spring.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
