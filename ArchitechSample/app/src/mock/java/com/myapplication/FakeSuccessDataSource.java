package com.myapplication;

import com.myapplication.Module.DataSource;
import com.myapplication.Module.IDataSource;

/**
 * Created by tedliang on 2017/1/3.
 */
public class FakeSuccessDataSource implements IDataSource {
    @Override
    public void sendText(CharSequence charSequence, DataSource.Callback callback) {
        callback.onSuccess();
    }
}
