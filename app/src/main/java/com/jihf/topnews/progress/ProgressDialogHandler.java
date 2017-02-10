package com.jihf.topnews.progress;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 14:09
 * Mail：jihaifeng@raiyi.com
 */
public class ProgressDialogHandler extends Handler {

  public static final int SHOW_PROGRESS_DIALOG = 1;
  public static final int DISMISS_PROGRESS_DIALOG = 2;

  private ProgressDialog progressDialog;

  private Context context;
  private boolean cancelable;
  private ProgressCancelListener mProgressCancelListener;

  public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener) {
    this(context, mProgressCancelListener, true);
  }

  public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener, boolean cancelable) {
    super();
    this.context = context;
    this.mProgressCancelListener = mProgressCancelListener;
    this.cancelable = cancelable;
  }

  private void initProgressDialog() {
    if (progressDialog == null) {
      progressDialog = new ProgressDialog(context);
      progressDialog.setMessage("努力加载中...");
      progressDialog.setCancelable(cancelable);
      if (cancelable) {
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
          @Override public void onCancel(DialogInterface dialogInterface) {
            mProgressCancelListener.onCancelProgress();
          }
        });
      }
      if (!progressDialog.isShowing()) {
        progressDialog.show();
      }
    }
  }

  private void dismissProgressDialog() {
    if (progressDialog != null) {
      progressDialog.dismiss();
      progressDialog = null;
    }
  }

  @Override public void handleMessage(Message msg) {
    switch (msg.what) {
      case SHOW_PROGRESS_DIALOG:
        initProgressDialog();
        break;
      case DISMISS_PROGRESS_DIALOG:
        dismissProgressDialog();
        break;
    }
  }
}