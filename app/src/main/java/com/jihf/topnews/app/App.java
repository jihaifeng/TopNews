package com.jihf.topnews.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import com.f2prateek.rx.preferences.RxSharedPreferences;
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
  private RxSharedPreferences rxPreference;

  public static App getInstance() {
    return instance;
  }

  private static void setInstance(App instance) {
    App.instance = instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    init();
  }

  private void init() {
    setInstance(this);
    // Rxpreference 初始化
    setRxPreference();
    //工具类注入
    Utils.init(this);
    //设置日志类是否显示
    LogUtils.setLogSwitch(BuildConfig.DEBUG);
    //内存泄漏检测
    //LeakCanary.install(this);

  }

  public RxSharedPreferences getRxPreference() {
    if (null == rxPreference) {
      setRxPreference();
    }
    return rxPreference;
  }

  private void setRxPreference() {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    rxPreference = RxSharedPreferences.create(sharedPreferences);
  }

  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    // 解决方法数超出65535问题
    MultiDex.install(this);
  }
}
