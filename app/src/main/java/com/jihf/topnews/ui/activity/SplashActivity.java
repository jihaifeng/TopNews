package com.jihf.topnews.ui.activity;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
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
import com.jihf.topnews.rx.RxUtils;
import com.jihf.androidutils.tools.countDownTime.MyCountDownTimer;
import rx.Subscriber;

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
    getToolBar().setVisibility(View.GONE);
    cutDownTime();
  }

  private void cutDownTime() {
    RxUtils.countdown(5).compose(bindToLifecycle()).subscribe(new Subscriber<Integer>() {

      @Override public void onCompleted() {
        toMain();
      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(Integer integer) {
        LogUtils.i(TAG, "subscribe：" + integer);
        if (integer > 0) {
          SpannableString spanStr = new SpannableString("跳过\n" + integer + " s");
          spanStr.setSpan(new AbsoluteSizeSpan(12, true), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
          spanStr.setSpan(new AbsoluteSizeSpan(10, true), 2, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
          spanStr.setSpan(new AbsoluteSizeSpan(12, true), 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
          tvCutDownTime.setText(spanStr);
        } else {
          toMain();
        }
      }
    });
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
