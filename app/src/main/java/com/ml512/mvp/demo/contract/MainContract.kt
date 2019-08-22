package com.ml512.mvp.demo.contract

import com.ml512.mvp.MvpBasePresenter
import com.ml512.mvp.MvpContract
import com.ml512.mvp.MvpPresenter
import com.ml512.mvp.MvpView

/**
 * 功能描述:MainContract
 * Created by MaLong on 2019-08-21 19:55.
 */
interface MainContract : MvpContract {
    interface MainView : MvpView {
        fun showDialog()
    }

    interface MainPresenter : MvpPresenter<MainView> {
        fun showDialog()
    }
}