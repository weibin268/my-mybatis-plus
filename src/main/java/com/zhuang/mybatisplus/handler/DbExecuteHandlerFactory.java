package com.zhuang.mybatisplus.handler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuang on 3/23/2018.
 */
public class DbExecuteHandlerFactory {

    private static List<DbExecutionHandler> dbExecutionHandlers;

    static {
        dbExecutionHandlers = new ArrayList<>();
    }

    public static List<DbExecutionHandler> getDbExecuteHandlers() {
        return dbExecutionHandlers;
    }

    public static void addDbExecutionHandler(DbExecutionHandler dbExecutionHandler) {
        dbExecutionHandlers.add(dbExecutionHandler);
    }

}
