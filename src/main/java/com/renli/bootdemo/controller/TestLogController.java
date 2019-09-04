package com.renli.bootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lily
 * @date: 2019/8/13 20:13
 * @description:
 */
@RestController
public class TestLogController {
    Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/testLog")
    public Object testLog() {
        logger.trace("【TestController.class】trace level log input");
        logger.debug("【TestController.class】debug level log input");
        logger.info("【TestController.class】info level log input");
        logger.warn("【TestController.class】warn level log input");
        logger.error("【TestController.class】error level log input");
        return "hello world";
    }
}
