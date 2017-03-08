package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;
import com.jihf.topnews.utils.ProgressDialogUtils;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-22 15:53
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseMvpFragment<T extends RxPresenter> extends RxFragment implements RxBaseView {
  public static final String TAG = BaseMvpFragment.class.getSimpleName().trim();
  private T presenter;
  private Unbinder unbinder;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutId(), container,false);
    ViewGroup parent = (ViewGroup) view.getParent();
    if (null != parent) {
      parent.removeView(view);
    }
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
    presenter = initPresenter();
    presenter.attachView(this);
    initViewAndEvent();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
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

  protected abstract int getLayoutId();

  protected abstract T initPresenter();

  protected abstract void initViewAndEvent();
}
