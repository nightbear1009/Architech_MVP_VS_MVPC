package com.myapplication.Presenter;

import com.myapplication.Controller.IController;
import com.myapplication.Module.DataSource;
import com.myapplication.Module.IDataSource;
import com.myapplication.View.IView;
import com.myapplication.View.MyView;

/**
 * Created by tedliang on 2017/1/3.
 */

public class MyViewPresenter implements IMyViewPresenter{
    IView mView;
    IDataSource mModel;
    public MyViewPresenter(IView view, IDataSource model){
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
}
