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
import java.net.URLConnection;

public class MainActivity extends BaseMvpActivity<NewsView, NewsPresenter> implements NewsView{

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
    RxView.clicks(btnTopNews).subscribe(click -> {
      //showLoading();
      getPresenter().getData();
    });
    RxView.clicks(btnTopGet).subscribe(click -> {
      String testUrl = "http://dldir1.qq.com/dlomg/chuanyue/kuaibao_536.apk";
      String type = URLConnection.guessContentTypeFromName(testUrl);
      LogUtils.i(TAG, "type: " + type);
    });
  }

  @Override protected boolean stopSwipeBack() {
    return false;
  }

  @Override public void showData(ResultBean resultBean) {
    //hideLoading();
    LogUtils.i(TAG, "showData: " + App.getInstance().getExternalCacheDir());
    Toast.makeText(this, resultBean.data.get(0).author_name, Toast.LENGTH_SHORT).show();
  }

}
