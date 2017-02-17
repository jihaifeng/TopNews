package com.jihf.topnews.ui.activity;

import android.support.v7.widget.AppCompatButton;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import com.jakewharton.rxbinding.view.RxView;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import com.jihf.topnews.base.BaseMvpActivity;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.presenter.NewsPresenter;
import java.util.concurrent.TimeUnit;

public class MainActivity extends BaseMvpActivity<NewsView, NewsPresenter> implements NewsView {

  @BindView (R.id.btn_top_news) AppCompatButton btnTopNews;
  @BindView (R.id.iv_show) ImageView ivShow;
  @BindView (R.id.btn_top_get) AppCompatButton btnTopGet;

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void initViewAndEvent() {
    RxView.clicks(btnTopNews).throttleFirst(0, TimeUnit.SECONDS).subscribe(click -> {
      getPresenter().getData();
    });
    RxView.clicks(btnTopGet).subscribe(click ->{
      getPresenter().getData2();
    });
  }

  @Override protected boolean stopSwipeBack() {
    return false;
  }

  @Override public void showData(ResultBean resultBean) {
    LogUtils.i(TAG, "showData: " + App.getInstance().getExternalCacheDir());
    Toast.makeText(this, resultBean.data.get(0).author_name, Toast.LENGTH_SHORT).show();
  }

  @Override public void showError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }
}
