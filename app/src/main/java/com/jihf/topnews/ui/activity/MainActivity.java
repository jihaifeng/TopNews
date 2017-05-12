package com.jihf.topnews.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseMvpActivity;
import com.jihf.topnews.contract.MainContract;
import com.jihf.topnews.presenter.MainPresenter;
import com.jihf.topnews.test.TestActivity;
import com.jihf.topnews.ui.fragment.GankMainFragment;
import com.jihf.topnews.ui.fragment.NewsMainFragment;
import com.jihf.topnews.utils.SharedPreferencesUtils;

public class MainActivity extends BaseMvpActivity<MainPresenter>
    implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {

  @BindView (R.id.fragment_content) FrameLayout idContent;
  @BindView (R.id.drawer_root) DrawerLayout drawerRoot;
  @BindView (R.id.navigation_left) NavigationView navigationLeft;
  //@BindView (R.id.btn_test) Button btnTest;
  //@BindView (R.id.btn_gank) Button btnGank;
  //@BindView (R.id.btn_news) Button btnNews;

  private String curFragmentTag;
  private String fragmentTag;

  private Fragment showFragment;

  private String title = "新闻";

  public static final String Tag_NewsFragment = "news";
  public static final String Tag_GankFragment = "gank";
  public static final String Tag_MeiziFragment = "meizi";

  @Override protected MainPresenter initPresenter() {
    return new MainPresenter(this);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override protected void initViewAndEvent() {
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
    navigationLeft.setNavigationItemSelectedListener(this);
  }

  private void switchShowFragment(String fgTag) {

    if (TextUtils.isEmpty(fgTag)) {
      showFragment = new NewsMainFragment();
      fgTag = Tag_NewsFragment;
    }
    if (!TextUtils.isEmpty(curFragmentTag) && fgTag.equals(curFragmentTag)) {
      return;
    }
    switch (fgTag) {
      case Tag_NewsFragment:
        showFragment = new NewsMainFragment();
        title = "新闻";
        break;
      case Tag_GankFragment:
        showFragment = new GankMainFragment();
        title = "干货";
        break;
      case Tag_MeiziFragment:
        //showFragment = new GirlsFragment();
        title = "妹子";
        break;
    }

    if (null == showFragment) {
      showFragment = new NewsMainFragment();
    }

    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fragment_content, showFragment);
    fragmentTransaction.commit();
    curFragmentTag = fgTag;
    getToolBar().setTitle(title);
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

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.test:
        jumpTo(TestActivity.class);
        break;
      case R.id.news:
        switchShowFragment(Tag_NewsFragment);
        item.setChecked(true);
        break;
      case R.id.gank:
        switchShowFragment(Tag_GankFragment);
        item.setChecked(true);
        break;
      case R.id.meizi:
        switchShowFragment(Tag_MeiziFragment);
        item.setChecked(true);
        break;
    }
    if (drawerRoot.isDrawerOpen(GravityCompat.START)) {
      drawerRoot.closeDrawer(GravityCompat.START);
    }
    return false;
  }
}
