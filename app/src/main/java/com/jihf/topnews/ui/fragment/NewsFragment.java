package com.jihf.topnews.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import com.jihf.topnews.R;
import com.jihf.topnews.adapter.RyNewsAdapter;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.contract.NewsContract;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.presenter.NewsPresenter;
import com.jihf.topnews.utils.ScreenUtil;
import com.jihf.topnews.view.recyclerview.DividerItemDecoration;
import com.jihf.topnews.view.recyclerview.LinearLayoutManagerPlus;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-22 15:52
 * Mail：jihaifeng@raiyi.com
 */
public class NewsFragment extends BaseMvpFragment<NewsPresenter>
    implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener {

  @BindView (R.id.ry_news) RecyclerView ryNews;
  @BindView (R.id.sf_news) SwipeRefreshLayout sfNews;

  private RyNewsAdapter ryNewsAdapter;

  @Override protected int getLayoutId() {
    return R.layout.fragment_news;
  }

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(getActivity());
  }

  @Override protected void initViewAndEvent() {
    initAdapter();
    showLoading();
    getPresenter().getDataFromNet();
    sfNews.setOnRefreshListener(this);
  }

  private void initAdapter() {
    DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
    decoration.setDividerSize(ScreenUtil.dip2px((float) 0.3));
    ryNews.removeItemDecoration(decoration);
    ryNews.addItemDecoration(decoration);
    LinearLayoutManagerPlus linearLayoutManagerPlus = new LinearLayoutManagerPlus(getActivity());
    linearLayoutManagerPlus.setOrientation(LinearLayoutManager.VERTICAL);
    ryNews.setLayoutManager(linearLayoutManagerPlus);
    //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
    ryNewsAdapter = new RyNewsAdapter(getActivity());
    ryNews.setAdapter(ryNewsAdapter);
  }

  @Override public void showData(ResultBean resultBean) {
    hideLoading();
    sfNews.setRefreshing(false);
    if (null != resultBean && null != resultBean.data && resultBean.data.size() != 0) {
      ryNewsAdapter.replaceDatas(resultBean.data);
      Toast.makeText(getActivity(), resultBean.data.get(0).author_name, Toast.LENGTH_SHORT).show();
    }
  }

  @Override public void onRefresh() {
    getPresenter().getDataFromNet();
  }
}
