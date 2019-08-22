package com.ml512.mvp.demo

import android.os.Bundle
import android.widget.Toast
import com.ml512.mvp.MvpActivity
import com.ml512.mvp.demo.contract.MainContract
import com.ml512.mvp.demo.presenter.MainPresenter
import com.ml512.mvp.demo.ui.fragment.TestFragmentDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpActivity<MainContract.MainView,MainContract.MainPresenter>(),MainContract.MainView {

    override fun createPresenter(): MainContract.MainPresenter = MainPresenter()

    override fun getContentViewId(): Int = R.layout.activity_main

    override fun initAllMembersView(savedInstanceState: Bundle?) {
        showDialog.setOnClickListener {
            presenter.showDialog()
        }
    }

    override fun showDialog() {
        var dialog = TestFragmentDialog()
        dialog.setOnOperateClickListener(object : TestFragmentDialog.OnOperateClickListener{
            override fun onReport() {
                Toast.makeText(context,"已举报", Toast.LENGTH_LONG).show()
            }

            override fun onKickOut() {
                Toast.makeText(context,"已踢出", Toast.LENGTH_LONG).show()
            }
        })
        dialog.show(supportFragmentManager,"test")
    }
}
