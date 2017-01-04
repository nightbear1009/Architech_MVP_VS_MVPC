package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myapplication.Presenter.IPresenter;
import com.myapplication.Presenter.Presenter;
import com.myapplication.Controller.IController;
import com.myapplication.View.MyView;

public class MainActivity extends AppCompatActivity implements IController {
    private MyView mMyView;
    private Presenter mPresenter;
    private View mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new Presenter(this, Injection.provideDataSource());
        setContentView(R.layout.activity_main);
        mProgress = findViewById(R.id.progress);
        mMyView = (MyView)findViewById(R.id.myview);
        Button button = (Button) findViewById(R.id.mybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.checkData(mMyView.getText());
            }
        });

    }


    @Override
    public void showSuccess() {
        mMyView.reset();
    }

    @Override
    public void showFailed() {

    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideprogress() {
        mProgress.setVisibility(View.GONE);
    }
}
