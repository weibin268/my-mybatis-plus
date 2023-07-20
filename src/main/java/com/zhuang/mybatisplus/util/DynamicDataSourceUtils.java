package com.zhuang.mybatisplus.util;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

import java.util.function.Supplier;

public class DynamicDataSourceUtils {

    public static  <T> T execute(String ds, Supplier<T> func) {
        DynamicDataSourceContextHolder.push(ds);
        try {
            return func.get();
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }
}
