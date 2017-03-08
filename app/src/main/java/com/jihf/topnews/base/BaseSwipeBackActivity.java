package com.jihf.topnews.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jihf.swipbackhelper.SwipeBackHelper;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：支持滑动返回的基类Activity
 * Desc:
 * Author：jihf
 * Data：2017-03-06 10:40
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseSwipeBackActivity<T extends RxPresenter> extends BaseMvpActivity<T> {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    //初始化滑动返回
    setSwipeBackPage();
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    SwipeBackHelper.onPostCreate(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    SwipeBackHelper.onDestroy(this);
  }

  private void setSwipeBackPage() {
    SwipeBackHelper.onCreate(this);
    SwipeBackHelper.getCurrentPage(this)
        .setSwipeBackEnable(true)
        .setSwipeSensitivity(0.5f)
        .setSwipeRelateEnable(true)
        .setSwipeRelateOffset(300);
  }
}
