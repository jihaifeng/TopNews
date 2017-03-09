package com.jihf.topnews.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jihf.androidutils.tools.ActivityUtils;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.utils.ProgressDialogUtils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-09 09:32
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseSimpleActivity extends RxAppCompatActivity {
  public static String TAG = BaseSimpleActivity.class.getSimpleName().trim();
  private Context mBaseContext;
  private Activity mCurrentActivity;
  private Unbinder unbinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //布局注入
    setContentView(getLayoutId());
    unbinder = ButterKnife.bind(this);
    setActivityStatus(this);
    initViewAndEvent();
    mBaseContext = this;
    LogUtils.i(TAG, "--------onCreate--------");
  }

  @Override protected void onStart() {
    super.onStart();
    LogUtils.i(TAG, "-------onStart------");
  }

  @Override protected void onPause() {
    super.onPause();
    LogUtils.i(TAG, "-------onPause------");
  }

  @Override protected void onResume() {
    super.onResume();
    LogUtils.i(TAG, "-------onResume------" + this);
  }

  @Override protected void onStop() {
    super.onStop();
    LogUtils.i(TAG, "-------onStop------");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (null != unbinder) {
      unbinder.unbind();
    }
    // 在Activity栈中移除Activity
    ActivityUtils.getInstance().removeActivity(this);
    LogUtils.i(TAG, "-------onDestroy------");
  }

  @Override protected void onRestart() {
    super.onRestart();
    LogUtils.i(TAG, "-------onRestart------");
  }

  @Override public void finish() {
    super.finish();
    LogUtils.i(TAG, "-------finish------");
    ActivityUtils.getInstance().removeActivity(this);
  }

  /**
   * Activity 统一配置
   *
   * @param activity 需要配置的Activity
   */
  private void setActivityStatus(Activity activity) {
    //设置当前栈顶Activity
    mCurrentActivity = activity;
    //设置Activity强制竖屏显示
    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    // 向Acitivty栈（数据类型为List）中添加Activity
    ActivityUtils.getInstance().addActivity(activity);
    //设置TAG
    TAG = getClass().getSimpleName().trim();
  }

  /**
   * 是否有上一级的Activity可以返回
   *
   * @return true===可返回，false====不可返回
   */
  public static boolean canGoBack() {
    return ActivityUtils.getInstance().getActivityNum() > 1;
  }

  /**
   * 获取当前显示的Activity
   *
   * @return 当前Activity
   */
  public Activity getCurrentActivity() {
    if (null == mCurrentActivity) {
      mCurrentActivity = this;
    }
    return mCurrentActivity;
  }

  /**
   * 无参数的跳转
   *
   * @param from 起始Activity
   * @param to 目标Activity
   */
  public void startActivity(Context from, Class to) {
    Intent intent = new Intent();
    intent.setClass(from, to);
    startActivity(intent);
  }

  /**
   * 带参数的跳转
   *
   * @param from 起始Activity
   * @param to 目标Activity
   * @param bundle 参数
   */
  public void startActivityWithBundle(Context from, Class to, Bundle bundle) {
    Intent intent = new Intent();
    intent.putExtras(bundle);
    intent.setClass(from, to);
    startActivity(intent);
  }

  public void showLoading() {
    ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
  }

  public void hideLoading() {
    ProgressDialogUtils.hideProgressDialog();
  }


  protected abstract int getLayoutId();

  protected abstract void initViewAndEvent();
}
