package com.renli.bootdemo.jvm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * * 模拟堆内存溢出   Caused by: java.lang.OutOfMemoryError: GC overhead limit exceeded
 *   系统负载过高、并发量大、数据量过大或者内存泄漏 很容易导致JVM内存不够
 *   设置JVM的堆内存总共为10M
 * 启动命令  java  -Xms10m -Xmx10m -jar bootdemo-0.0.1-SNAPSHOT.jar                                                                                                                                HOT.jar
 *
 * @author: Lily
 * @date: 2020/2/20 10:18
 */
//@SpringBootApplication
public class Demo4 {
    public static void main(String[] args) throws Exception {
        long counter = 0;
        List<Object> list = new ArrayList<Object>();
        while(true){
            list.add(new Object());
            System.out.println("目前是第" + (++counter) + "个对象");
        }
    }
}
