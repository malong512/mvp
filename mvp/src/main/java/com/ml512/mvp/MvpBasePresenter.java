package com.ml512.mvp;

import java.lang.ref.WeakReference;

/**
 * MVP -- BasePresenter
 * Created by malong on 2017/7/28 14:02.
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    /**
     * Get view weak reference.
     */
    private WeakReference<V> viewRef;

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean isRetainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * Get the attached view. You should always call
     * {@link #isViewAttached()} to check if the view
     * is attached to avoid {@link NullPointerException}
     *
     * @return null or the instance of V
     */
    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * Checks if a view is attached to this presenter.
     * You should always call this method before calling
     * {@link #getView()} to get the view instance.
     *
     * @return
     */
    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

}
