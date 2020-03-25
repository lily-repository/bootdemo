package com.renli.bootdemo.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于 JDK 的 LinkedHashMap 实现的LRU算法
 *
 * @author: Lily
 * @date: 2020/3/25 14:26
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * 这里就是传递进来最多能缓存多少数据
     */
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        //这块就是设置一个hashmap的初始大小，同时最后一个true指的是让linkedhashmap按照访问顺序来进行排序，最近访问的放在头，最老访问的就在尾
        //Math.ceil()  “向上取整”， 即小数部分直接舍去，并向正数部分进1
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        this.cacheSize = cacheSize;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        //这个意思就是说当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(4);
        for (int i =0 ; i < 10; i++) {
            lru.put("str"+i, i);
        }
        System.out.println(lru);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cacheSize=" + cacheSize +
                '}';
    }
}
