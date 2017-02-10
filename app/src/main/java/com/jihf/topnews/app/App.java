package com.jihf.topnews.app;

import android.app.Application;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.androidutils.tools.Utils;
import com.jihf.topnews.BuildConfig;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-06 15:44
 * Mail：jihaifeng@raiyi.com
 */
public class App extends Application {
  private static App instance;

  public static App getInstance() {
    return instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    init();
  }

  private void init() {
    //工具类注入
    Utils.init(this);
    //设置日志类是否显示
    LogUtils.setLogSwitch(BuildConfig.DEBUG);
  }
}
