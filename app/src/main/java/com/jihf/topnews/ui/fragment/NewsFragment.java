package com.jihf.topnews.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.adapter.RyNewsAdapter;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.constants.JuHeConstants;
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

  @BindView (R.id.tv_error_msg) TextView tvErrorMsg;
  @BindView (R.id.news_error_view) View errorView;
  @BindView (R.id.ry_news) RecyclerView ryNews;
  @BindView (R.id.sf_news) SwipeRefreshLayout sfNews;
  @BindView (R.id.iv_news_refresh) ImageView ivNewsRefresh;

  private RyNewsAdapter ryNewsAdapter;
  private static String DATA_TYPE = "data_type";
  private String TYPE_KEY = JuHeConstants.TYPE_TOP;

  public static NewsFragment newInstance(String type) {
    Bundle bundle = new Bundle();
    bundle.putString(DATA_TYPE, TextUtils.isEmpty(type) ? JuHeConstants.TYPE_TOP : type);
    NewsFragment newsFragment = new NewsFragment();
    newsFragment.setArguments(bundle);
    return newsFragment;
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_news;
  }

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(getActivity());
  }

  @Override protected void initViewAndEvent() {
    initAdapter();
    if (!JuHeConstants.isHasShowLoading()) {
      showLoading();
    }
    LogUtils.i(TAG, "JuHeConstants.isHasShowLoading(): " + JuHeConstants.isHasShowLoading());
    Bundle bundle = getArguments();
    if (null != bundle) {
      TYPE_KEY = TextUtils.isEmpty(bundle.getString(DATA_TYPE)) ? JuHeConstants.TYPE_TOP : bundle.getString(DATA_TYPE);
    }
    getPresenter().getDataFromNet();
    sfNews.setOnRefreshListener(this);
    sfNews.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
  }

  private void initAdapter() {
    DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
    decoration.setDividerSize(ScreenUtil.dip2px((float) 0.5));
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
    errorView.setVisibility(View.GONE);
    ryNews.setVisibility(View.VISIBLE);
    hideLoading();
    sfNews.setRefreshing(false);
    if (null != resultBean && null != resultBean.data && resultBean.data.size() != 0) {
      ryNewsAdapter.replaceDatas(resultBean.data);
    }
    JuHeConstants.setHasShowLoading(true);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    JuHeConstants.setHasShowLoading(false);
  }

  @Override public void showError(String msg) {
    super.showError(msg);
    errorView.setVisibility(View.VISIBLE);
    ryNews.setVisibility(View.GONE);
    tvErrorMsg.setText(TextUtils.isEmpty(msg) ? "数据异常..." : msg);
    sfNews.setRefreshing(false);
    ivNewsRefresh.setOnClickListener(v -> getPresenter().getDataFromNet());
  }

  @Override public String getType() {
    return TYPE_KEY;
  }

  @Override public void onRefresh() {
    getPresenter().getDataFromNet();
  }
}
