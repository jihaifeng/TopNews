package com.jihf.topnews.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseMvpActivity;
import com.jihf.topnews.contract.MainContract;
import com.jihf.topnews.presenter.MainPresenter;
import com.jihf.topnews.test.TestActivity;
import com.jihf.topnews.ui.fragment.GankMainFragment;
import com.jihf.topnews.ui.fragment.NewsMainFragment;
import com.jihf.topnews.utils.SharedPreferencesUtils;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

  @BindView (R.id.fragment_content) FrameLayout idContent;
  @BindView (R.id.drawer_root) DrawerLayout drawerRoot;
  @BindView (R.id.btn_test) Button btnTest;
  @BindView (R.id.btn_news) Button btnNews;
  @BindView (R.id.btn_gank) Button btnGank;

  private String curFragmmentTag;
  private String fragmentTag;

  private Fragment showFragment;

  public static final String Tag_NewsFragment = "news";
  public static final String Tag_GankFragment = "gank";

  private NewsMainFragment newsMainFragment;
  private GankMainFragment gankMainFragment;

  @Override protected MainPresenter initPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void initViewAndEvent() {

    getToolBar().setTitle("新闻");
    ActionBarDrawerToggle drawerToggle =
        new ActionBarDrawerToggle(this, drawerRoot, getToolBar(), R.string.drawer_open, R.string.drawer_close);
    drawerToggle.syncState();
    drawerRoot.addDrawerListener(drawerToggle);
    //将侧边栏顶部延伸至status bar
    drawerRoot.setFitsSystemWindows(true);
    //将主页面顶部延伸至status bar
    drawerRoot.setClipToPadding(false);
    fragmentTag = SharedPreferencesUtils.getInstance().getString(fragmentTag);
    switchShowFragment(fragmentTag);
  }

  private void switchShowFragment(String fgTag) {
    if (TextUtils.isEmpty(fgTag)) {
      showFragment = new GankMainFragment();
      fgTag = Tag_GankFragment;
    }
    if (!TextUtils.isEmpty(curFragmmentTag) && fgTag.equals(curFragmmentTag)) {
      return;
    }
    switch (fgTag) {
      case Tag_NewsFragment:
        showFragment = new NewsMainFragment();
        break;
      case Tag_GankFragment:
        showFragment = new GankMainFragment();
        break;
    }

    if (null == showFragment) {
      showFragment = new GankMainFragment();
    }
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fragment_content, showFragment);
    fragmentTransaction.commit();
    curFragmmentTag = fgTag;
  }

  @Override public void showUpdateDialog(String newVersion) {
    // 新版本更新dialog
  }

  @Override public void startDownload() {
    // 下载新版本

  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        if (drawerRoot.isDrawerOpen(GravityCompat.START)) {
          drawerRoot.closeDrawer(GravityCompat.START);
        } else {
          drawerRoot.openDrawer(GravityCompat.START);
        }
        break;
    }
    return true;
  }

  @OnClick ({ R.id.btn_test, R.id.btn_news, R.id.btn_gank }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_test:
        jumpTo(TestActivity.class);

        break;
      case R.id.btn_news:
        switchShowFragment(Tag_NewsFragment);
        break;
      case R.id.btn_gank:
        switchShowFragment(Tag_GankFragment);
        break;
    }
    if (drawerRoot.isDrawerOpen(GravityCompat.START)) {
      drawerRoot.closeDrawer(GravityCompat.START);
    }
  }

  @Override public void onBackPressed() {
    if (drawerRoot.isDrawerOpen(GravityCompat.START)) {
      drawerRoot.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override protected boolean initSwipeBackEnable() {
    return false;
  }
}
