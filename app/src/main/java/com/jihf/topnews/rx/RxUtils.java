package com.jihf.topnews.rx;

import java.util.concurrent.TimeUnit;
import rx.Observable;

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
    return Observable.interval(0, 1, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
        .map(increaseTime -> countTime - increaseTime.intValue())
        .compose(RxSchedulersHelper.io_main())
        .take(countTime + 1);
  }
}
