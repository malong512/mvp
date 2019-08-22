package com.ml512.mvp.demo.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ml512.base.BaseDialogFragment
import com.ml512.mvp.demo.R
import kotlinx.android.synthetic.main.dialog_fragment_test.*

/**
 * 功能描述:测试弹窗
 * Created by MaLong on 2019-08-21 18:09.
 */
class TestFragmentDialog : BaseDialogFragment(), View.OnClickListener {

    private var onOperateClickListener:OnOperateClickListener? = null

    fun setOnOperateClickListener(onOperateClickListener: OnOperateClickListener){
        this.onOperateClickListener = onOperateClickListener
    }

    override fun getContentViewId(): Int = R.layout.dialog_fragment_test

    override fun initAllMembersView(savedInstanceState: Bundle?) {
        rootView.setOnClickListener(this)
        tvCancel.setOnClickListener(this)
        tvReport.setOnClickListener(this)
        tvKickOut.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.rootView,R.id.tvCancel -> {
                dismiss()
            }
            R.id.tvReport->{
                onOperateClickListener?.onReport()
                dismiss()
            }
            R.id.tvKickOut->{
                onOperateClickListener?.onKickOut()
                dismiss()
            }
        }
    }

    /**
     * 操作回调
     * create by malong at 2017/7/26 18:05
     */
    interface OnOperateClickListener {
        fun onReport()

        fun onKickOut()
    }
}