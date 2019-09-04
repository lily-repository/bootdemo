package com.renli.bootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: RenLiLi
 * @Date: 2018/8/30 12:03
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String demo(){
        return "hello,SpringBoot!";
    }
}
