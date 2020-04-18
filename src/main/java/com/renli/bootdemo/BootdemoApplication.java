package com.renli.bootdemo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * exclude的原因是Druid内部也定义了一个datasource 同名了
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
//@MapperScan("com.renli.bootdemo.dao")
public class BootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }
}
