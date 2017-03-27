package com.jihf.androidutils.tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Func：操作软键盘的显示与隐藏
 * Desc:
 * Author：jihf
 * Data：2017-02-07 17:13
 * Mail：jihaifeng@raiyi.com
 */
public class KeyboardUtils {
  /**
   * 动态隐藏软键盘
   *
   * @param activity activity
   */
  public static void hideSoftInput(Activity activity) {
    View view = activity.getCurrentFocus();
    if (view == null) {
      view = new View(activity);
    }
    InputMethodManager imm = (InputMethodManager) activity.getSystemService(
        Activity.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }

  /**
   * 动态显示软键盘
   *
   * @param edit 输入框
   */
  public static void showSoftInput(EditText edit) {
    edit.setFocusable(true);
    edit.setFocusableInTouchMode(true);
    edit.requestFocus();
    InputMethodManager imm = (InputMethodManager) Utils.getContext()
        .getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.showSoftInput(edit, 0);
  }

  /**
   * 切换键盘显示与否状态
   */
  public static void toggleSoftInput() {
    InputMethodManager imm = (InputMethodManager) Utils.getContext()
        .getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
  }
}
