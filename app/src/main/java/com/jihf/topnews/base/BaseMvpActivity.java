package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：Mvp架构baseAcitivity
 * Desc:
 * Author：jihf
 * Data：2017-02-07 09:08
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseMvpActivity<T extends RxPresenter> extends BaseSimpleActivity {
  private T presenter;

  @Override

  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //presenter注入
    presenter = initPresenter();
    LogUtils.i(TAG, "--------onCreate--------");
  }

  @Override protected void onResume() {
    super.onResume();
    if (null != presenter) {
      presenter.attachView(this);
    }
    LogUtils.i(TAG, "-------onResume------" + this);
  }

  @Override protected void onDestroy() {
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
