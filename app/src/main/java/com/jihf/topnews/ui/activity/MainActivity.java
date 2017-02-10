package com.jihf.topnews.ui.activity;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import com.jihf.topnews.base.BaseMvpActivity;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.entity.ResultBean;
import com.jihf.topnews.presenter.NewsPresenter;

public class MainActivity extends BaseMvpActivity<NewsPresenter> implements NewsView {

  @BindView (R.id.btn_top_news) AppCompatButton btnTopNews;
  @BindView (R.id.iv_show) ImageView ivShow;
  @BindView (R.id.activity_main) LinearLayout activityMain;

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void initViewAndEvent() {
    //RxView.clicks(btnTopNews).subscribe(new Action1<Void>() {
    //  @Override public void call(Void aVoid) {
    //    getPresenter().loadData(MainActivity.this);
    //  }
    //});
  }

  @Override protected boolean stopSwipeBack() {
    return true;
  }

  @Override public void showData(ResultBean resultBean) {
    LogUtils.i(TAG, "showData: " + App.getInstance().getExternalCacheDir());
    Toast.makeText(this, resultBean.data.get(0).author_name, Toast.LENGTH_SHORT).show();
  }

  @Override public void showError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }


  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @OnClick ({ R.id.btn_top_news, R.id.iv_show }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_top_news:
        getPresenter().loadData(this);
        break;
      case R.id.iv_show:
        break;
    }
  }
}
