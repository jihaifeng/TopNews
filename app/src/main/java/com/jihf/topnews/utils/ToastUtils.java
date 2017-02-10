package com.jihf.topnews.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;
import com.jihf.androidutils.tools.Utils;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-09 12:55
 * Mail：jihaifeng@raiyi.com
 */
public class ToastUtils {
  private ToastUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  private static Toast sToast;

  /**
   * 显示短时吐司
   *
   * @param text 文本
   */
  public static void showShort(CharSequence text) {
    showToast(text, Toast.LENGTH_SHORT);
  }

  /**
   * 显示短时吐司
   *
   * @param resId 资源Id
   */
  public static void showShort(@StringRes int resId) {
    showToast(resId, Toast.LENGTH_SHORT);
  }

  /**
   * 显示长时吐司
   *
   * @param text 文本
   */
  public static void showLong(CharSequence text) {
    showToast(text, Toast.LENGTH_LONG);
  }

  /**
   * 显示长时吐司
   *
   * @param resId 资源Id
   */
  public static void showLong(@StringRes int resId) {
    showToast(resId, Toast.LENGTH_LONG);
  }

  /**
   * 显示吐司
   *
   * @param resId 资源Id
   * @param duration 显示时长
   */
  private static void showToast(@StringRes int resId, int duration) {
    showToast(Utils.getContext().getResources().getText(resId).toString(), duration);
  }

  /**
   * 显示吐司
   *
   * @param resId 资源Id
   * @param duration 显示时长
   * @param args 参数
   */
  private static void showToast(@StringRes int resId, int duration, Object... args) {
    showToast(String.format(Utils.getContext().getResources().getString(resId), args), duration);
  }

  /**
   * 显示吐司
   *
   * @param format 格式
   * @param duration 显示时长
   * @param args 参数
   */
  private static void showToast(String format, int duration, Object... args) {
    showToast(String.format(format, args), duration);
  }

  /**
   * 显示吐司
   *
   * @param text 文本
   * @param duration 显示时长
   */
  private static void showToast(CharSequence text, int duration) {
    if (sToast == null) {
      sToast = Toast.makeText(Utils.getContext(), text, duration);
    } else {
      sToast.setText(text);
      sToast.setDuration(duration);
    }
    sToast.show();
  }

  /**
   * 取消吐司显示
   */
  public static void cancelToast() {
    if (sToast != null) {
      sToast.cancel();
      sToast = null;
    }
  }
}
