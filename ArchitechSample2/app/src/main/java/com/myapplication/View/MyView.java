package com.myapplication.View;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapplication.Injection;
import com.myapplication.Presenter.IMyViewPresenter;
import com.myapplication.Presenter.IPresenter;
import com.myapplication.Presenter.MyViewPresenter;
import com.myapplication.R;

/**
 * Created by tedliang on 2017/1/3.
 */

public class MyView extends LinearLayout implements IView {
    private EditText mEditText;
    private TextView mTextView;
    private Button mBtn;
    private IMyViewPresenter mPresenter;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.myview, this, true);
        mPresenter = new MyViewPresenter(this, Injection.provideDataSource());
        mTextView = (TextView) findViewById(R.id.text_view);
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
    public void reset() {
        mTextView.setText("reset");
    }

    public CharSequence getText() {
        return mEditText.getText();
    }
}