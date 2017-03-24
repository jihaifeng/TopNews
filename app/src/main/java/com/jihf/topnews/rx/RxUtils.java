package com.jihf.topnews.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-24 16:53
 * Mail：jihaifeng@raiyi.com
 */
public class RxUtils {

  /**
   * 倒计时
   *
   * @param time
   *
   * @return
   */
  public static Observable<Integer> countdown(int time) {
    if (time < 0) {
      time = 0;
    }
    final int countTime = time;
    return Observable.interval(0, 1, TimeUnit.SECONDS)
        .map(increaseTime -> countTime - increaseTime.intValue())
        .take(countTime + 1)
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
