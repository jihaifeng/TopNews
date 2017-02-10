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
    return new Observable.Transformer<T, T>() {
      @Override public Observable<T> call(Observable<T> tObservable) {
        return tObservable
            // 指定 subscribe() 发生在 子 线程
            .subscribeOn(Schedulers.newThread())
            // 指定 unsubscribeOn() 发生在 子 线程
            .unsubscribeOn(Schedulers.newThread())
            // 指定 observeOn() 发生在 主 线程
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }
}