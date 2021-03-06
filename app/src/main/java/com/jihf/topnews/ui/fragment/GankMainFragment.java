package com.jihf.topnews.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import butterknife.BindView;
import com.jihf.topnews.R;
import com.jihf.topnews.adapter.FragmentViewPageAdapter;
import com.jihf.topnews.base.BaseSimpleFragment;
import com.jihf.topnews.constants.GankConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-28 09:27
 * Mail：jihaifeng@raiyi.com
 */
public class GankMainFragment extends BaseSimpleFragment {

  @BindView (R.id.tab_news) TabLayout tabNews;
  @BindView (R.id.vp_news) ViewPager vpNews;

  private List<Fragment> fragments = new ArrayList<>();

  @Override protected int getLayoutId() {
    return R.layout.fragment_main;
  }

  @Override protected void initViewAndEvent() {
    List<String> typeList = GankConstants.getTypeList();
    for (String key : typeList) {
      // fragments
      fragments.add(GankFragment.newInstance(key));
      // tab
      tabNews.addTab(tabNews.newTab().setText(key));
    }
    tabNews.setTabMode(TabLayout.MODE_SCROLLABLE);
    // viewPage
    // Fragment嵌套Fragment要用getChildFragmentManager
    FragmentViewPageAdapter pageAdapter = new FragmentViewPageAdapter(getChildFragmentManager());
    pageAdapter.setFragmentList(fragments);
    vpNews.setAdapter(pageAdapter);
    // 这句话要放在 ViewPager.setAdapter(mAdapter) 它后面
    tabNews.setupWithViewPager(vpNews);
    // 重新设置tab标题，因为源码setupWithViewPager里面会执行removeAllTabs方法，导致显示空白
    for (int i = 0; i < typeList.size(); i++) {
      // tab
      TabLayout.Tab tab = tabNews.getTabAt(i);
      if (null != tab) {
        tab.setText(TextUtils.isEmpty(typeList.get(i)) ? "all" : typeList.get(i));
      }
    }
  }
}
