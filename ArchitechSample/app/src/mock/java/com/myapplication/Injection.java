package com.myapplication;

import com.myapplication.Module.IDataSource;

/**
 * Created by tedliang on 2017/1/3.
 */

public class Injection {

    private static boolean mIsSuccess;
    public static void init(boolean isSuccess){
        mIsSuccess = isSuccess;
    }

    public static IDataSource provideDataSource(){
        if(mIsSuccess) {
            return new FakeSuccessDataSource();
        } else {
            return new FakeErrorDataSource();
        }
    }
}
