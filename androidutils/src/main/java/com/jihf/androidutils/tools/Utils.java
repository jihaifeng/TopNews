package com.jihf.androidutils.tools;

import android.content.Context;

/**
 * Func：Utils初始化相关
 * User：jihf
 * Data：2017-01-16
 * Time: 13:39
 * Mail：jihaifeng@raiyi.com
 */
public class Utils {
  private static Context mContext;

  private Utils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * 初始化工具类
   *
   * @param context 上下文
   */
  public static void init(Context context) {
    mContext = context.getApplicationContext();
  }

  /**
   * 获取ApplicationContext
   *
   * @return ApplicationContext
   */
  public static Context getContext() {
    if (mContext != null) {
      return mContext;
    }
    throw new NullPointerException("u should init first");
  }
}
