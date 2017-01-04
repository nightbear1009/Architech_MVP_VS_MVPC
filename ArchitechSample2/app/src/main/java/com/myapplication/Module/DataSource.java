package com.myapplication.Module;

/**
 * Created by tedliang on 2017/1/3.
 */
public class DataSource implements IDataSource {
    public interface Callback{
        void onSuccess();
        void onError();
    }
    @Override
    public void sendText(CharSequence charSequence, Callback callback) {
        if(charSequence.toString().isEmpty()){
            callback.onError();
        } else {
            callback.onSuccess();
        }
    }

    @Override
    public void checkData(CharSequence charSequence, Callback callback) {
        if(charSequence.toString().isEmpty()){
            callback.onError();
        } else {
            callback.onSuccess();
        }
    }
}
