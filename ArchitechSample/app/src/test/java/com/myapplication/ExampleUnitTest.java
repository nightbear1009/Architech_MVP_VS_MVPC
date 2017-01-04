package com.myapplication;

import com.myapplication.Module.DataSource;
import com.myapplication.Presenter.Presenter;
import com.myapplication.View.IView;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Mock
    private DataSource mDataSource;

    @Mock
    private IView mView;

    @Captor
    private ArgumentCaptor<DataSource.Callback> mGetTaskCallbackCaptor;

    @Test
    public void testApiSuccess() throws Exception {
        MockitoAnnotations.initMocks(this);

        Presenter presenter = new Presenter(mView, mDataSource);
        presenter.sendText("1");

        verify(mDataSource).sendText(eq("1"), mGetTaskCallbackCaptor.capture());
        mGetTaskCallbackCaptor.getValue().onSuccess();
        verify(mView).showApiSuccess();
    }
}