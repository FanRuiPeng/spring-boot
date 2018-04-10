package com.bmf;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该文件默认扫描包下面所有文件 但是不能在工程默认文件夹下（java），需建子文件夹才可以
 * Created by Administrator on 2018/4/10 0010.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//        SpringApplication.run(Application.class, args);
    }
}