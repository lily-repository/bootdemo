package com.renli.bootdemo.jvm;

        import java.util.ArrayList;
        import java.util.List;

/**
 * * 模拟百万数据处理导致的问题 加载大量对象并长时间处理
 *
 * @author: Lily
 * @date: 2020/2/20 10:18
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        List<Data> datas = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data {

    }
}
