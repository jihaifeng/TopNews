package com.jihf.topnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.widget.EmptyView.EmptyLayout;
import com.jihf.topnews.widget.EmptyView.Empty_status;
import com.jihf.topnews.widget.EmptyView.RetryListener;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-09 10:12
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseSimpleFragment extends RxFragment implements RxBaseView {
  public static String TAG = BaseSimpleFragment.class.getSimpleName().trim();
  private Unbinder unbinder;
  public View view;
  /**
   * 把 EmptyLayout 放在基类统一处理，@Nullable 表明 View 可以为 null，详细可看 ButterKnife
   */
  @Nullable
  @BindView (R.id.empty_layout_root) EmptyLayout emptyLayout;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(getLayoutId(), container, false);
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
    LogUtils.i(TAG, "cur：" + getClass().getSimpleName().trim());
    initViewAndEvent();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
  }

  @Override public void showLoading() {
    if (null != emptyLayout) {
      emptyLayout.setEmptyStatus(Empty_status.STATUS_LOADING);
    }
  }

  @Override public void hideLoading() {
    if (null != emptyLayout) {
      emptyLayout.hide();
    }
  }

  @Override public void showNetError(RetryListener retryListener) {
    if (null != emptyLayout) {
      emptyLayout.setEmptyStatus(Empty_status.STATUS_NO_NET);
      emptyLayout.setRetryListener(retryListener);
    }
  }

  @Override public void showDataError(String msg, RetryListener retryListener) {
    if (null != emptyLayout) {
      emptyLayout.setEmptyStatus(Empty_status.STATUS_NO_DATA);
      emptyLayout.setRetryListener(retryListener);
    }
    Snackbar.make(view, TextUtils.isEmpty(msg) ? "数据异常" : msg, Snackbar.LENGTH_SHORT).show();
    LogUtils.i(TAG, TextUtils.isEmpty(msg) ? "数据异常" : msg);
  }

  @Override public <E> LifecycleTransformer<E> bindToLife() {
    return this.bindToLifecycle();
  }

  protected abstract int getLayoutId();

  protected abstract void initViewAndEvent();
}
