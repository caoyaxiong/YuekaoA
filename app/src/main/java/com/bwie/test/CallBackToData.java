package com.bwie.test;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 19:05
 */

public interface CallBackToData <T>{
    void listener(int type);
        void jsonData(T json);
}
