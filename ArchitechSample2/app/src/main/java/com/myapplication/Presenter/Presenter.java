package com.myapplication.Presenter;

import android.os.Handler;

import com.myapplication.Module.DataSource;
import com.myapplication.Module.IDataSource;
import com.myapplication.Controller.IController;

/**
 * Created by tedliang on 2017/1/3.
 */

public class Presenter implements IPresenter {
    IController mView;
    IDataSource mModel;
    public Presenter(IController view, IDataSource model){
        mView = view;
        mModel = model;
    }

    @Override
    public void checkData(CharSequence text) {
        mView.showProgress();
        mModel.checkData(text, new DataSource.Callback() {
            @Override
            public void onSuccess() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView.showSuccess();
                        mView.hideprogress();
                    }
                }, 3000);
            }

            @Override
            public void onError() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView.showFailed();
                        mView.hideprogress();
                    }
                }, 3000);

            }
        });
    }
}
