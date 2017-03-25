package com.jihf.topnews.ui.activity;

import android.os.Build;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseSimpleActivity;

import static android.text.Html.FROM_HTML_MODE_LEGACY;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-25 17:24
 * Mail：jihaifeng@raiyi.com
 */
public class SplashActivity extends BaseSimpleActivity {

  @BindView (R.id.iv_splash) ImageView ivSplash;
  @BindView (R.id.tv_cut_down_time) TextView tvCutDownTime;

  private MyCountDownTimer timer;

  @Override protected int getLayoutId() {
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    return R.layout.activity_splash;
  }

  @Override protected void initViewAndEvent() {
    Glide.with(this).load(R.mipmap.ic_splash).into(ivSplash);
    timer = new MyCountDownTimer(5 * 1000, 1000);
    timer.start();
    getToolBar().setVisibility(View.GONE);
  }

  @OnClick ({ R.id.iv_splash, R.id.tv_cut_down_time }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.iv_splash:
        break;
      case R.id.tv_cut_down_time:
        toMain();
        break;
    }
  }

  /**
   * 定义一个倒计时的内部类
   */
  private class MyCountDownTimer extends CountDownTimer {
    /**
     * @param millisInFuture 从开始调用start()到倒计时完成并 onfinish()方法被调用的毫秒数
     * @param countDownInterval 接收onTick(long)回调的间隔时间
     */
    MyCountDownTimer(long millisInFuture, long countDownInterval) {
      super(millisInFuture, countDownInterval);
    }

    @Override public void onTick(long l) {
      LogUtils.i(TAG, "onTick：" + l / 1000);
      String html = "<a style=\"font-size: 20px\">跳过</a><br>\n"
          + "<a style=\"font-size: 16px\">"
          + l / 1000
          + "</a>\n"
          + "<a style=\"font-size: 18px\">s</a>";
      if (Build.VERSION.SDK_INT >= 24) {
        tvCutDownTime.setText(Html.fromHtml(html, FROM_HTML_MODE_LEGACY)); // for 24 api and more
      } else {
        tvCutDownTime.setText(Html.fromHtml(html)); // or for older api
      }
    }

    @Override public void onFinish() {
      LogUtils.i(TAG, "onFinish：");
      toMain();
      //tvCutDownTime.setText("");
      //tvCutDownTime.setVisibility(View.GONE);
    }
  }

  private void toMain() {
    SplashActivity.this.finish();
    jumpTo(MainActivity.class);
  }

  @Override protected boolean initSwipeBackEnable() {
    return false;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (null != timer) {
      timer.cancel();
      timer = null;
    }
  }
}
