package com.jihf.topnews.progress;

import android.content.Context;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import rx.Subscriber;

/**
 * Func：progress抽象类
 * Desc: 不实现Subscriber中的onNext方法和RxSubscriber中的 onError(msg)，让使用者实现onNext
 * Author：jihf
 * Data：2017-02-08 13:30
 * Mail：jihaifeng@raiyi.com
 */
public abstract class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
  private Context context;
  private ProgressDialogHandler mProgressDialogHandler;

  public ProgressSubscriber(Context context) {
    this.context = context;
    mProgressDialogHandler = new ProgressDialogHandler(context, this);
  }

  @Override public void onStart() {
    showProgressDialog();
  }

  @Override public void onCompleted() {
    dismissProgressDialog();
  }

  @Override public void onError(Throwable e) {

    if (e instanceof SocketTimeoutException || e instanceof ConnectException) {
      onError("网络中断，请检查您的网络状态");
    } else {
      onError(e.getMessage());
    }
  }

  private void showProgressDialog() {
    if (mProgressDialogHandler != null) {
      mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
    }
  }

  private void dismissProgressDialog() {
    if (mProgressDialogHandler != null) {
      mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
      mProgressDialogHandler = null;
    }
  }

  @Override public void onCancelProgress() {
    if (!this.isUnsubscribed()) {
      this.unsubscribe();
    }
  }

  public abstract void onError(String msg);
}
