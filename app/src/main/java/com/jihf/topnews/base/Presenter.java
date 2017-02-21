package com.jihf.topnews.base;

import com.jihf.topnews.rx.RxBaseView;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-17 16:50
 * Mail：jihaifeng@raiyi.com
 */
public interface Presenter<V extends RxBaseView> {
  void attachView(V view);

  void detachView();
}
