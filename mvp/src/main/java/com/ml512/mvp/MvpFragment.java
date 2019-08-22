package com.ml512.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ml512.base.BaseFragment;


/**
 * MVP Fragment
 * Created by malong on 2017/7/31 11:42.
 */
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter> extends BaseFragment implements MvpView {
    protected P presenter;

    @Override
    public void onStart() {
        if (presenter == null) {
            presenter = createPresenter();
        }
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (presenter == null) {
            presenter = createPresenter();
        }
        presenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView(getRetainInstance());
    }

    /**
     * 创建presenter
     * create by malong at 2017/7/31 12:01
     */
    protected abstract P createPresenter();
}