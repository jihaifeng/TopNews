package com.jihf.topnews.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jihf.androidutils.tools.ActivityUtils;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.androidutils.tools.ProgressDialogUtils;
import com.jihf.androidutils.tools.snackBar.SnackBarType;
import com.jihf.androidutils.tools.snackBar.SnackBarUtils;
import com.jihf.swipbackhelper.SwipeBackHelper;
import com.jihf.topnews.R;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-09 09:32
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseSimpleActivity extends BaseSwipeBackActivity {
  public static String TAG = BaseSimpleActivity.class.getSimpleName().trim();

  @BindView (R.id.content_frame) FrameLayout contentFrame;
  @BindView (R.id.toolbar) Toolbar toolbar;

  private Context mBaseContext;
  private Activity mCurrentActivity;
  private Unbinder unbinder;
  private long exitTime;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //布局注入
    setContentView(getLayoutId());
    unbinder = ButterKnife.bind(this);
    setActivityStatus(this);
    initViewAndEvent();
    mBaseContext = this;
    setToolBar();
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

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    SwipeBackHelper.onPostCreate(this);
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

  @Override public void setContentView(@LayoutRes int layoutResID) {
    View view = getLayoutInflater().inflate(R.layout.activity_base, null);
    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_frame);
    // 将传入的layout加载到activity_base的content_frame里面
    getLayoutInflater().inflate(layoutResID, frameLayout, true);
    super.setContentView(view);
  }

  protected void setToolBar() {
    toolbar.setTitleTextColor(Color.WHITE);
    setSupportActionBar(toolbar);
    // 设置返回键可用
    assert null != getSupportActionBar();
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  public Toolbar getToolBar() {
    return toolbar;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        if (canGoBack()) {
          finish();
        }
        break;
    }
    return true;
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

  @Override protected boolean initSwipeBackEnable() {
    return true;
  }

  /**
   * 无参数的跳转
   *
   * @param to 目标Activity
   */
  public void jumpTo(Class to) {
    jumpTo(to, null);
  }

  /**
   * 带参数的跳转
   *
   * @param to 目标Activity
   * @param bundle 参数
   */
  public void jumpTo(Class to, Bundle bundle) {
    Intent intent = new Intent();
    intent.setClass(mCurrentActivity, to);
    if (null != bundle) {
      intent.putExtras(bundle);
    }
    mCurrentActivity.startActivity(intent);
  }

  public void jumpToWithResultCode(Class to, Bundle bundle, int resultCode) {
    Intent intent = new Intent();
    intent.setClass(mCurrentActivity, to);
    if (null != bundle) {
      intent.putExtras(bundle);
    }
    mCurrentActivity.startActivityForResult(intent, resultCode);
  }

  public void jumpToWithResultCode(Class to, int resultCode) {
    jumpToWithResultCode(to, null, resultCode);
  }

  public void showLoading() {
    ProgressDialogUtils.showProgressDialog(this, "数据加载中...");
  }

  public void hideLoading() {
    ProgressDialogUtils.hideProgressDialog();
  }

  protected abstract int getLayoutId();

  protected abstract void initViewAndEvent();

  @Override public void onBackPressed() {
    if (canGoBack()) {
      super.onBackPressed();
    } else {
      exit();
    }
  }

  public void exit() {
    if ((System.currentTimeMillis() - exitTime) > 2000) {
      SnackBarUtils.creatShort(contentFrame, "再按一次退出程序").setType(SnackBarType.Confirm).show();
      exitTime = System.currentTimeMillis();
    } else {
      finish();
      System.exit(0);
    }
  }
}
