package com.myapplication.Presenter;

import android.os.Handler;

import com.myapplication.Module.DataSource;
import com.myapplication.Module.IDataSource;
import com.myapplication.View.IView;

/**
 * Created by tedliang on 2017/1/3.
 */

public class Presenter implements IPresenter {
    IView mView;
    IDataSource mModel;
    public Presenter(IView view, IDataSource model){
        mView = view;
        mModel = model;
    }


    @Override
    public void checkTextValidation(CharSequence charSequence) {
        if(charSequence.toString().contains("1")){
            mView.showCorrect();
        }
        else {
            mView.showError();
        }
    }

    @Override
    public void sendText(CharSequence charSequence) {
        mModel.sendText(charSequence, new DataSource.Callback() {
            @Override
            public void onSuccess() {
                mView.showApiSuccess();
            }

            @Override
            public void onError() {
                mView.showApiFailed();
            }
        });
    }

    @Override
    public void checkData(CharSequence text) {
        mView.showprogress();
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
