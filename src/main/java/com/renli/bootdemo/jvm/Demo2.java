package com.renli.bootdemo.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

/**
 * * 模拟metaspace内存溢出   Caused by: java.lang.OutOfMemoryError: Metaspace
 *   设置metaspace 最大10m
 *  启动命令  java  -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -jar bootdemo-0.0.1-SNAPSHOT.jar                                                                                                                                HOT.jar
 *   -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
 *
 * @author: Lily
 * @date: 2020/2/20 10:18
 */
//@SpringBootApplication
public class Demo2 {
    public static void main(String[] args) throws Exception {
        long counter = 0;
        while (true) {
            System.out.println("目前创建了" + (++counter) + "个Car类的子类了");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("启动汽车之前，先进行自动的安全检查。。。。");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });
            Car car = (Car) enhancer.create();
            car.run();
        }

    }

    static class Car {

        public void run() {
            System.out.println("汽车启动，开始行驶......");
        }

    }
}
