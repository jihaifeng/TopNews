package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;
import com.jihf.topnews.utils.ProgressDialogUtils;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-22 15:53
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseMvpFragment<T extends RxPresenter> extends BaseSimpleFragment implements RxBaseView {
  private T presenter;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    presenter = initPresenter();
    presenter.attachView(this);
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

  @Override public void showError(String msg) {
    hideLoading();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  public void showLoading() {
    ProgressDialogUtils.showProgressDialog(getActivity(), "数据加载中...");
  }

  public void hideLoading() {
    ProgressDialogUtils.hideProgressDialog();
  }

  protected abstract T initPresenter();
}
