package com.jihf.topnews.base;

import com.jihf.topnews.rx.RxBaseView;

/**
 * Func： View基类
 * Desc:  继承rxBaseView更好的管理rxjava订阅的什么周期
 * Author：jihf
 * Data：2017-02-07 10:39
 * Mail：jihaifeng@raiyi.com
 */
public interface BaseView extends RxBaseView {
  void showError(String msg);
}
