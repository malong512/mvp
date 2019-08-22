package com.ml512.mvp.demo.presenter

import com.ml512.mvp.MvpBasePresenter
import com.ml512.mvp.demo.contract.MainContract

/**
 * 功能描述:main-p
 * Created by MaLong on 2019-08-21 19:24.
 */
class MainPresenter : MvpBasePresenter<MainContract.MainView>(), MainContract.MainPresenter {

    override fun showDialog() {
        //可以处理一些网络，数据操作
        view?.showDialog()
    }

}