package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-22 15:53
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseMvpFragment<T extends RxPresenter> extends BaseSimpleFragment {
  private T presenter;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    presenter = initPresenter();
    if (null != presenter) {
      presenter.attachView(this);
    }
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    if (null != presenter) {
      presenter.detachView();
    }
  }

  public T getPresenter() {
    if (null == presenter) {
      throw new NullPointerException("you have not init presenter.");
    }
    return presenter;
  }

  protected abstract T initPresenter();
}
