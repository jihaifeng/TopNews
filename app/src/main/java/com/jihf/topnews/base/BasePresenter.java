package com.jihf.topnews.base;

import com.jihf.topnews.entity.ResultBean;

/**
 * Func： presenter基类
 * Desc:
 * Author：jihf
 * Data：2017-02-07 10:37
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BasePresenter<T extends BaseView> {
  private T mvpView;

  protected void attachView(T view) {
    this.mvpView = view;
  }

  void detachView() {
    this.mvpView = null;
  }

  protected T getMvpView() {
    return mvpView;
  }

  public abstract void onSuccess(ResultBean resultBean);

  public abstract void onFailure(String msg);


}
