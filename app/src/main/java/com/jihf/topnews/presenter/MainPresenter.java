package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.contract.MainContract;
import com.jihf.topnews.rx.RxBasePresenter;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 13:39
 * Mail：jihaifeng@raiyi.com
 */
public class MainPresenter extends RxBasePresenter<MainContract.View> implements MainContract.Presenter {
  public MainPresenter(Context context) {
    super(context);
  }

  @Override public void checkVersion(String currentVersion) {
    // 版本检测
  }

  @Override public void checkPermissions(RxPermissions rxPermissions) {
    // 权限检测
  }
}
