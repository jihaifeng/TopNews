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
import butterknife.OnClick;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.androidutils.tools.ScreenUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.adapter.RyNewsAdapter;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.contract.NewsContract;
import com.jihf.topnews.model.news.JuheResultBean;
import com.jihf.topnews.presenter.NewsPresenter;
import com.jihf.topnews.widget.EmptyView.RetryListener;
import com.jihf.topnews.widget.recyclerview.DividerItemDecoration;
import com.jihf.topnews.widget.recyclerview.LinearLayoutManagerPlus;
import com.orhanobut.logger.Logger;

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
  @BindView (R.id.iv_data_refresh) ImageView ivDataRefresh;

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
    Bundle bundle = getArguments();
    if (null != bundle) {
      TYPE_KEY = TextUtils.isEmpty(bundle.getString(DATA_TYPE)) ? JuHeConstants.TYPE_TOP : bundle.getString(DATA_TYPE);
    }
    Logger.t(TAG).i("initViewAndEvent：" + TYPE_KEY);
    getPresenter().getDataFromNet();
    sfNews.setOnRefreshListener(this);
    sfNews.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
  }

  private void initAdapter() {
    DividerItemDecoration decoration =
        new DividerItemDecoration(getActivity(), R.color.line, DividerItemDecoration.VERTICAL_LIST);
    decoration.setDividerSize(ScreenUtils.dip2px((float) 0.3));
    ryNews.removeItemDecoration(decoration);
    ryNews.addItemDecoration(decoration);
    LinearLayoutManagerPlus linearLayoutManagerPlus = new LinearLayoutManagerPlus(getActivity());
    linearLayoutManagerPlus.setOrientation(LinearLayoutManager.VERTICAL);
    ryNews.setLayoutManager(linearLayoutManagerPlus);
    //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
    ryNews.setHasFixedSize(true);
    ryNewsAdapter = new RyNewsAdapter(getActivity());
    ryNews.setAdapter(ryNewsAdapter);
    ryNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        ryNewsAdapter.setScrolling(newState != RecyclerView.SCROLL_STATE_IDLE);
      }
    });
  }

  @Override public void showData(JuheResultBean resultBean) {
    errorView.setVisibility(View.GONE);
    ryNews.setVisibility(View.VISIBLE);
    hideLoading();
    if (null != resultBean && null != resultBean.data && resultBean.data.size() != 0) {
      ryNewsAdapter.refresh(resultBean.data);
    }
    JuHeConstants.setHasShowLoading(true);
    sfNews.setRefreshing(false);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    JuHeConstants.setHasShowLoading(false);
  }

  @Override public void showDataError(String msg, RetryListener retryListener) {
    super.showDataError(msg, retryListener);
    errorView.setVisibility(View.VISIBLE);
    ryNews.setVisibility(View.GONE);
    tvErrorMsg.setText(TextUtils.isEmpty(msg) ? "数据异常..." : msg);
    sfNews.setRefreshing(false);
  }

  @OnClick ({ R.id.tv_error_msg, R.id.iv_data_refresh }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_error_msg:
      case R.id.iv_data_refresh:
        getPresenter().getDataFromNet();
        break;
    }
  }

  @Override public String getType() {
    LogUtils.i(TAG, "type：" + TYPE_KEY);
    return TYPE_KEY;
  }

  @Override public void onRefresh() {
    getPresenter().getDataFromNet();
  }
}
