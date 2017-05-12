package com.jihf.topnews.rx;

import com.jihf.topnews.widget.EmptyView.RetryListener;
import com.trello.rxlifecycle.LifecycleTransformer;
import rx.Observable;

/**
 * Func：rxjava BaseView  添加 RxLifecycle 管理rxjava订阅的生命周期
 * Desc: 解决MVP架构下p层获取数据缺少bind方法，避免内存泄漏 compose操作符
 * Author：jihf
 * Data：2017-02-10 14:18
 * Mail：jihaifeng@raiyi.com
 */
//依赖    compile 'com.trello:rxlifecycle:1.0' 和  compile 'com.trello:rxlifecycle-components:1.0'
public interface RxBaseView {
  <T> Observable.Transformer<T, T> bindToLifecycle();

  /**
   * 绑定生命周期
   *
   * @param <T>
   *
   * @return
   */
  <T> LifecycleTransformer<T> bindToLife();

  /**
   * 显示加载动画
   */
  void showLoading();

  /**
   * 隐藏加载
   */
  void hideLoading();

  /**
   * 显示网络错误
   *
   * @param retryListener 点击监听
   */
  void showNetError(RetryListener retryListener);

  /**
   * 显示数据异常
   *
   * @param retryListener 点击监听
   */
  void showDataError(String msg, RetryListener retryListener);
}
