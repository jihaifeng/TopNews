package com.jihf.topnews.rx;

import com.trello.rxlifecycle.android.ActivityEvent;
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

  <T> Observable.Transformer<T, T> bindUntilEvent(ActivityEvent event);
}
