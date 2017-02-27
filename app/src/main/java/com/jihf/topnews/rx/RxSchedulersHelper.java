package com.jihf.topnews.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Func：处理Rx线程
 * Desc:
 * Author：jihf
 * Data：2017-02-09 09:33
 * Mail：jihaifeng@raiyi.com
 */
public class RxSchedulersHelper {

  public static <T> Observable.Transformer<T, T> io_main() {
    return tObservable -> tObservable
        // 指定 subscribe() 发生在 子 线程
        .subscribeOn(Schedulers.io())
        // 指定 unsubscribeOn() 发生在 子 线程
        .unsubscribeOn(Schedulers.io())
        // 指定 observeOn() 发生在 主 线程
        .observeOn(AndroidSchedulers.mainThread());
  }
}