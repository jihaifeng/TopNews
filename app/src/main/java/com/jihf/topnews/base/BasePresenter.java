package com.jihf.topnews.base;

import android.content.Context;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.rx.RxBaseView;

/**
 * Func： presenter基类
 * Desc:
 * Author：jihf
 * Data：2017-02-07 10:37
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BasePresenter<V extends RxBaseView> implements Presenter<V> {
  private V mvpView;
  protected Context context;

  @Override public void attachView(V view) {
    LogUtils.i("BaseMvpActivity", "attachView: " + view);
    this.mvpView = view;
  }

  @Override public void detachView() {
    this.mvpView = null;
  }

  public V getMvpView() {
    return mvpView;
  }

  public boolean isViewAttached() {
    return mvpView != null;
  }

  public BasePresenter(Context context) {
    this.context = context;
  }
}
