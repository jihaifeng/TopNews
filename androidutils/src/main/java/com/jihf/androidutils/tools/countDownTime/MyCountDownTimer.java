package com.jihf.androidutils.tools.countDownTime;

import android.os.CountDownTimer;
import com.jihf.androidutils.tools.LogUtils;

/**
 * 定义一个倒计时的内部类
 */
public class MyCountDownTimer extends CountDownTimer {
  private static final String TAG = MyCountDownTimer.class.getSimpleName().trim();
  private CountDownCallBack callBack;

  /**
   * @param millisInFuture 从开始调用start()到倒计时完成并 onfinish()方法被调用的毫秒数
   * @param countDownInterval 接收onTick(long)回调的间隔时间
   */
  public MyCountDownTimer(long millisInFuture, long countDownInterval, CountDownCallBack callBack) {
    super(millisInFuture, countDownInterval);
    this.callBack = callBack;
  }

  @Override public void onTick(long l) {
    LogUtils.i(TAG, "onTick：" + l / 1000);
    if (null != callBack) {
      callBack.onNext(l);
    }
  }

  @Override public void onFinish() {
    LogUtils.i(TAG, "onFinish：");
    if (null != callBack) {
      callBack.onFinish();
    }
  }
}