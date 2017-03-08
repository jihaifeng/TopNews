package com.jihf.topnews.contract;

import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 13:40
 * Mail：jihaifeng@raiyi.com
 */
public interface MainContract {
  interface View extends RxBaseView {
    void showUpdateDialog(String newVersion);

    void startDownload();
  }

  interface Presenter extends RxPresenter<View> {
    void checkVersion(String currentVersion);

    void checkPermissions(RxPermissions rxPermissions);
  }
}
