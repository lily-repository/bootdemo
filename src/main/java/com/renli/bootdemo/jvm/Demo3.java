package com.renli.bootdemo.jvm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * * 模拟栈内存溢出   Caused by: java.lang.StackOverflowError
 *   设置JVM的栈内存为1MB
 * 启动命令  java  -XX:ThreadStackSize=1m -jar bootdemo-0.0.1-SNAPSHOT.jar                                                                                                                                HOT.jar
 *
 * @author: Lily
 * @date: 2020/2/20 10:18
 */
//@SpringBootApplication
public class Demo3 {
    public static long counter = 0;

    public static void main(String[] args) throws Exception {
        work();
    }

    public static void work() {
        System.out.println("目前是第" + (++counter) + "次调用方法");
        work();
    }
}
