package com.myapplication.Module;

/**
 * Created by tedliang on 2017/1/3.
 */
public interface IDataSource {
    void sendText(CharSequence charSequence, DataSource.Callback callback);

    void checkData(CharSequence charSequence, DataSource.Callback callback);

}
