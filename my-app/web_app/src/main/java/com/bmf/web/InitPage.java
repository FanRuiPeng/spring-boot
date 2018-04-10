package com.bmf.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/4/10 0010.
 */
@RestController
@RequestMapping("/")
public class InitPage {

    @RequestMapping("/")
    public String index() {
        return "Hello World! : " + System.currentTimeMillis();
    }
}