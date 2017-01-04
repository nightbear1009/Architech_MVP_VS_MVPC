package com.myapplication.View;

/**
 * Created by tedliang on 2017/1/3.
 */

public interface IView {
    void showCorrect();

    void showError();

    void showApiSuccess();

    void showApiFailed();

    void reset();
}
