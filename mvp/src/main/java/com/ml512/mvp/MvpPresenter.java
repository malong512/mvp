package com.ml512.mvp;

/**
 * MVP--Presenter
 * Created by malong on 2017/7/28 10:46.
 */
public interface MvpPresenter<V extends MvpView> {
    /**
     * Set or attach the view to this presenter
     *
     * @param view
     */
    void attachView(V view);

    /**
     * Will be called if the view has been destroyed.
     * Typically this method will be invoked from
     * <code>Activity.onDestroy()</code> or
     * <code>Fragment.onDestroyView()</code>
     *
     * @param isRetainInstance
     */
    void detachView(boolean isRetainInstance);
}
