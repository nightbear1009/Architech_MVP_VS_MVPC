package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myapplication.Module.DataSource;
import com.myapplication.Presenter.IPresenter;
import com.myapplication.Presenter.Presenter;
import com.myapplication.View.IView;

public class MainActivity extends AppCompatActivity implements IView {
    IPresenter mPresenter;
    private EditText mEditText;
    private TextView mTextView;
    private Button mBtn;
    private Button mBottomBtn;
    private View mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new Presenter(this, Injection.provideDataSource());
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.text_view);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPresenter.checkTextValidation(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.sendText(mEditText.getText());
            }
        });

        mBottomBtn = (Button)findViewById(R.id.mybtn);
        mBottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.checkData(mEditText.getText());
            }
        });
        mProgress = findViewById(R.id.progress);
    }

    @Override
    public void showCorrect() {
        mTextView.setText("correct");
    }

    @Override
    public void showError() {
        mTextView.setText("error");
    }

    @Override
    public void showApiSuccess() {
        mTextView.setText("api success");
    }

    @Override
    public void showApiFailed() {
        mTextView.setText("api failed");
    }

    @Override
    public void hideprogress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showFailed() {
    }

    @Override
    public void showSuccess() {
        mTextView.setText("reset");
    }

    @Override
    public void showprogress() {
        mProgress.setVisibility(View.VISIBLE);
    }
}
