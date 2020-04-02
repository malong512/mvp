package com.ml512.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.ml512.mvp.R;

/**
 * Base DialogFragment
 * Created by malong on 2017/7/28 17:05.
 */
public abstract class BaseDialogFragment extends DialogFragment {
    protected Context context;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, 0);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//no title
        getDialog().getWindow().getAttributes().windowAnimations = R.style.MVP_DialogAnimation;

        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.context = getActivity();

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAllMembersView(savedInstanceState);
    }

    @Override
    public void onStart() {
        Window window = getDialog().getWindow();

        if (window != null) {
            // 一定要设置Background，如果不设置，window属性设置无效
            //或window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
            window.setBackgroundDrawableResource(R.color.mvp_color_transparent);

            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;

            window.setAttributes(params);
        }
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * Get content view id.
     *
     * @return layoutResID
     */
    protected abstract int getContentViewId();

    /**
     * Init all members view.
     *
     * @param savedInstanceState
     */
    protected abstract void initAllMembersView(Bundle savedInstanceState);

    /**
     * hide keyboard.
     */
    public void hideSoftInput(View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /**
     * hide keyboard without view.
     */
    public void hideSoftInput() {
        try {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
