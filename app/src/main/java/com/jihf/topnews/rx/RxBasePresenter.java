package com.jihf.topnews.rx;

import android.content.Context;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 11:22
 * Mail：jihaifeng@raiyi.com
 */
public abstract class RxBasePresenter<T extends RxBaseView> implements RxPresenter<T> {
  private T mView;
  private CompositeSubscription mCompositeSubscription;

  protected Context context;

  public RxBasePresenter(Context context) {
    this.context = context;
  }

  protected void unSubscribe() {
    if (mCompositeSubscription != null) {
      mCompositeSubscription.unsubscribe();
    }
  }

  protected void addSubscrebe(Subscription subscription) {
    if (mCompositeSubscription == null) {
      mCompositeSubscription = new CompositeSubscription();
    }
    mCompositeSubscription.add(subscription);
  }

  @Override public void attachView(T view) {
    this.mView = view;
  }

  @Override public void detachView() {
    this.mView = null;
    unSubscribe();
  }

  public T getmView() {
    if (null == mView) {
      throw new NullPointerException("mView is null.");
    }
    return mView;
  }
}
