package com.jihf.topnews.rx;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import rx.Subscriber;

/**
 * Func：封装Subscriber,不实现onNext
 * Desc:
 * Author：jihf
 * Data：2017-02-09 14:28
 * Mail：jihaifeng@raiyi.com
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

  @Override public void onStart() {
  }

  @Override public void onCompleted() {

  }

  @Override public void onError(Throwable e) {
    e.printStackTrace();
    if (e instanceof SocketTimeoutException || e instanceof ConnectException) {
      onError("网络中断，请检查您的网络状态");
    } else {
      onError(e.getMessage());
    }
  }

  public abstract void onError(String msg);
}