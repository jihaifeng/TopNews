package com.jihf.androidutils.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-16 15:19
 * Mail：jihaifeng@raiyi.com
 */
public class ProgressDialogUtils {
  private static ProgressDialog progressDialog;

  public static void showProgressDialog(Context context) {
    showProgressDialog(context, null, null);
  }

  public static void showProgressDialog(Context context, String msg) {
    showProgressDialog(context, msg, null);
  }

  public static void showProgressDialog(Context context, ProgressCancelListener cancelListener) {
    showProgressDialog(context, null, cancelListener);
  }

  public static void showProgressDialog(Context context, String msg, final ProgressCancelListener cancelListener) {
    if (null == progressDialog) {
      progressDialog = new ProgressDialog(context);
    }
    progressDialog.setMessage(TextUtils.isEmpty(msg) ? "" : msg);
    progressDialog.setCanceledOnTouchOutside(null != cancelListener);
    if (null != cancelListener) {
      progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
        @Override public void onCancel(DialogInterface dialog) {
          cancelListener.onCancelProgress();
        }
      });
    }
    if (!progressDialog.isShowing()) {
      progressDialog.show();
    }
  }

  public static void hideProgressDialog() {
    if (isShowing()) {
      progressDialog.dismiss();
    }
    clearDialog();
  }

  public static void clearDialog() {
    if (isShowing()) {
      progressDialog.dismiss();
    }
    if (null != progressDialog) {
      progressDialog = null;
    }
  }

  public static boolean isShowing() {
    return null != progressDialog && progressDialog.isShowing();
  }

  public interface ProgressCancelListener {
    void onCancelProgress();
  }
}
