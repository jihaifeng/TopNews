package com.jihf.topnews.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.androidutils.tools.ScreenUtils;
import com.jihf.androidutils.tools.Utils;
import com.jihf.androidutils.tools.crashLog.CrashHandler;
import com.jihf.topnews.BuildConfig;
import com.jihf.topnews.db.db_manager.DbManager;
import com.jihf.topnews.http.HttpApiMethed;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import org.litepal.LitePalApplication;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-06 15:44
 * Mail：jihaifeng@raiyi.com
 */
public class App extends LitePalApplication {
  private static App instance;

  private DbManager dbManager;

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
    // 工具类注入
    Utils.init(this);
    // 设置日志类是否显示
    LogUtils.setLogSwitch(BuildConfig.DEBUG);
    Logger.addLogAdapter(new AndroidLogAdapter());
    // 异常捕获
    CrashHandler.getInstance(this).init();
    // 内存泄漏检测
    LeakCanary.install(this);
    //
    ScreenUtils.createInstance(this);
    // http
    HttpApiMethed.init();
    // DB
    dbManager = DbManager.getInstance(getInstance());
  }

  public DbManager getDbManager() {
    return dbManager;
  }

  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    // 解决方法数超出65535问题
    MultiDex.install(this);
  }
}
