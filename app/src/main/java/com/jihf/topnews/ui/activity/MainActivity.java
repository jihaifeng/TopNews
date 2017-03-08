package com.jihf.topnews.ui.activity;

import android.support.v4.app.FragmentTransaction;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseMvpActivity;
import com.jihf.topnews.contract.MainContract;
import com.jihf.topnews.presenter.MainPresenter;
import com.jihf.topnews.ui.fragment.NewsFragment;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

  @Override protected MainPresenter initPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void initViewAndEvent() {
    NewsFragment newsFragment = new NewsFragment();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.id_content,newsFragment);
    fragmentTransaction.commit();
    LogUtils.i(TAG,"newsFragment：" + newsFragment);
  }

  @Override public void showUpdateDialog(String newVersion) {
    // 新版本更新dialog
  }

  @Override public void startDownload() {
    // 下载新版本

  }
}
