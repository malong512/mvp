package com.ml512.mvp;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.ml512.base.BaseActivity;


/**
 * MVP Activity
 * Created by malong on 2017/7/31 12:03.
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter> extends BaseActivity implements MvpView {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (presenter == null) {
            presenter = createPresenter();
        }
        presenter.attachView(this);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    /**
     * create presenter
     * create by malong at 2017/7/31 14:26
     */
    protected abstract P createPresenter();
}
