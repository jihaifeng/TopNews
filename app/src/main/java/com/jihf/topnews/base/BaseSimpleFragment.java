package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jihf.topnews.utils.ProgressDialogUtils;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-09 10:12
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseSimpleFragment extends RxFragment {
  public static String TAG = BaseSimpleFragment.class.getSimpleName().trim();
  private Unbinder unbinder;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutId(), container, false);
    ViewGroup parent = (ViewGroup) view.getParent();
    if (null != parent) {
      parent.removeView(view);
    }
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
    TAG = getClass().getSimpleName().trim();
    initViewAndEvent();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
  }

  public void showLoading() {
    ProgressDialogUtils.showProgressDialog(getActivity(), "数据加载中...");
  }

  public void hideLoading() {
    ProgressDialogUtils.hideProgressDialog();
  }

  protected abstract int getLayoutId();

  protected abstract void initViewAndEvent();
}
