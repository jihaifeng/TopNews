package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Toast;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;
import com.jihf.topnews.utils.ProgressDialogUtils;

/**
 * Func：Mvp架构baseAcitivity
 * Desc:
 * Author：jihf
 * Data：2017-02-07 09:08
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseMvpActivity<T extends RxPresenter> extends BaseSimpleActivity implements RxBaseView {
  private T presenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
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

  @Override public void showError(String msg) {
    hideLoading();
    Toast.makeText(this, TextUtils.isEmpty(msg) ? "数据异常" : msg, Toast.LENGTH_SHORT).show();
    LogUtils.i(TAG, TextUtils.isEmpty(msg) ? "数据异常" : msg);
  }

  public void showLoading() {
    ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
  }

  public void hideLoading() {
    ProgressDialogUtils.hideProgressDialog();
  }

  protected abstract T initPresenter();
}
