package com.myapplication;

import com.myapplication.Module.DataSource;
import com.myapplication.Module.IDataSource;
import com.myapplication.Presenter.IPresenter;
import com.myapplication.Presenter.Presenter;
import com.myapplication.View.IView;

/**
 * Created by tedliang on 2017/1/3.
 */

public class Injection {
    public static IDataSource provideDataSource(){
        return new DataSource();
    }
}
