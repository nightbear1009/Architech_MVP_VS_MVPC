package com.myapplication.Presenter;

import android.text.Editable;

/**
 * Created by tedliang on 2017/1/3.
 */
public interface IPresenter {
    void checkTextValidation(CharSequence charSequence);

    void sendText(CharSequence charSequence);

    void checkData(CharSequence text);
}
