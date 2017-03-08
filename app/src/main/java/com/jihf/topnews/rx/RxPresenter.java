package com.jihf.topnews.rx;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-17 16:50
 * Mail：jihaifeng@raiyi.com
 */
public interface RxPresenter<V extends RxBaseView> {
  void attachView(V view);

  void detachView();
}
