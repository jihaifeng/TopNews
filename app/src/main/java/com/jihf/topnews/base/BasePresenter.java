package com.jihf.topnews.base;

import android.content.Context;

/**
 * Func： presenter基类
 * Desc:
 * Author：jihf
 * Data：2017-02-07 10:37
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BasePresenter<V> {
  private V mvpView;
  protected Context context;

  public void attachView(V view) {
    this.mvpView = view;
  }

  public void detachView() {
    this.mvpView = null;
  }

  public V getMvpView() {
    return mvpView;
  }

  public BasePresenter(Context context) {
    this.context = context;
  }
}
