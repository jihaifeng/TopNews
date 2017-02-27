package com.jihf.topnews.ui.fragment;

import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.presenter.NewsPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-27 17:20
 * Mail：jihaifeng@raiyi.com
 */
public class NewsFragment extends BaseMvpFragment<NewsView, NewsPresenter> implements NewsView {
  @Override protected int getLayoutId() {
    return R.layout.fragment_news;
  }

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(getActivity());
  }

  @Override protected void initViewAndEvent() {

  }

  @Override public void showData(ResultBean resultBean) {

  }
}
