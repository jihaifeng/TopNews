package com.jihf.topnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-21 12:45
 * Mail：jihaifeng@raiyi.com
 */
public class FragmentViewPageAdapter extends FragmentPagerAdapter {

  private List<Fragment> fragments;

  public FragmentViewPageAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return null == fragments ? null : fragments.get(position);
  }

  @Override public int getCount() {
    return null == fragments ? 0 : fragments.size();
  }

  public void setFragmentList(List<Fragment> fragments) {
    if (null == fragments) {
      throw new NullPointerException("the arrayList of fragment is empty");
    }
    this.fragments = fragments;
  }
}
