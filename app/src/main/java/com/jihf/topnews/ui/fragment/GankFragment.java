package com.jihf.topnews.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.androidutils.tools.ScreenUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.adapter.RyGankAdapter;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.constants.GankConstants;
import com.jihf.topnews.contract.GankContract;
import com.jihf.topnews.model.gank.GankBaseBean;
import com.jihf.topnews.presenter.GankPresenter;
import com.jihf.topnews.view.recyclerview.DividerItemDecoration;
import com.jihf.topnews.view.recyclerview.LinearLayoutManagerPlus;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 18:06
 * Mail：jihaifeng@raiyi.com
 */
public class GankFragment extends BaseMvpFragment<GankPresenter>
    implements GankContract.View, SwipeRefreshLayout.OnRefreshListener {
  private static String GANK_DATA_TYPE = "gank_data_type";
  private String type = GankConstants.gank_all;
  @BindView (R.id.tv_error_msg) TextView tvErrorMsg;
  @BindView (R.id.news_error_view) View errorView;
  @BindView (R.id.iv_data_refresh) ImageView ivDataRefresh;
  @BindView (R.id.ry_gank) RecyclerView ryGank;
  @BindView (R.id.sf_gank) SwipeRefreshLayout sfGank;
  @BindView (R.id.ll_load_more) LinearLayout viewLoadMore;
  private RyGankAdapter ryGankAdapter;
  private int page;

  @Override protected GankPresenter initPresenter() {
    return new GankPresenter(getActivity());
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_gank;
  }

  @Override protected void initViewAndEvent() {
    initAdapter();
    //showLoading();
    Bundle bundle = getArguments();
    if (null != bundle) {
      type = TextUtils.isEmpty(bundle.getString(GANK_DATA_TYPE)) ? GankConstants.gank_all
          : bundle.getString(GANK_DATA_TYPE);
    }
    LogUtils.i(TAG, "initViewAndEvent：" + type);
    getPresenter().getDataFromNet();
    sfGank.setColorSchemeColors(Color.BLUE, Color.RED, Color.GREEN);
    sfGank.setOnRefreshListener(this);
  }

  public static boolean isVisBottom(RecyclerView recyclerView) {
    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    //屏幕中最后一个可见子项的position
    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
    //当前屏幕所看到的子项个数
    int visibleItemCount = layoutManager.getChildCount();
    //当前RecyclerView的所有子项个数
    int totalItemCount = layoutManager.getItemCount();
    //RecyclerView的滑动状态
    int state = recyclerView.getScrollState();
    LogUtils.i(TAG, visibleItemCount + "\n" + (lastVisibleItemPosition == totalItemCount - 1) + "\n" + (state
        == RecyclerView.SCROLL_STATE_IDLE));
    if (visibleItemCount > 0
        && lastVisibleItemPosition == totalItemCount - 1
        && state == RecyclerView.SCROLL_STATE_IDLE) {
      return true;
    } else {
      return false;
    }
  }

  private void initAdapter() {
    DividerItemDecoration decoration =
        new DividerItemDecoration(getActivity(), R.color.line, DividerItemDecoration.VERTICAL_LIST);
    decoration.setDividerSize(ScreenUtils.dip2px((float) 0.3));
    ryGank.removeItemDecoration(decoration);
    ryGank.addItemDecoration(decoration);

    LinearLayoutManagerPlus linearLayoutManagerPlus = new LinearLayoutManagerPlus(getActivity());
    linearLayoutManagerPlus.setOrientation(LinearLayoutManager.VERTICAL);
    ryGank.setLayoutManager(linearLayoutManagerPlus);
    //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
    ryGank.setHasFixedSize(true);
    ryGankAdapter = new RyGankAdapter(getActivity(), ryGank);
    ryGank.setAdapter(ryGankAdapter);
    ryGank.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        ryGankAdapter.setScrolling(newState != RecyclerView.SCROLL_STATE_IDLE);
        if (isVisBottom(ryGank) && newState == RecyclerView.SCROLL_STATE_IDLE) {
          getPresenter().loadMore(page++);
          viewLoadMore.setVisibility(View.VISIBLE);
        }
      }
    });
  }

  @Override public void showData(GankBaseBean gankBaseBean) {
    errorView.setVisibility(View.GONE);
    ryGank.setVisibility(View.VISIBLE);
    ryGankAdapter.replaceDatas(gankBaseBean.results);
    sfGank.setRefreshing(false);
    hideLoading();
  }

  @Override public void showError(String msg) {
    super.showError(msg);
    errorView.setVisibility(View.VISIBLE);
    ryGank.setVisibility(View.GONE);
    tvErrorMsg.setText(TextUtils.isEmpty(msg) ? "数据异常..." : msg);
    sfGank.setRefreshing(false);
  }

  @Override public void showMore(GankBaseBean gankBaseBean) {
    viewLoadMore.setVisibility(View.GONE);
    ryGankAdapter.addDatas(gankBaseBean.results);
  }

  @Override public void showMoreError(String msg) {
    viewLoadMore.setVisibility(View.GONE);
    errorView.setVisibility(View.VISIBLE);
    ryGank.setVisibility(View.GONE);
    tvErrorMsg.setText(TextUtils.isEmpty(msg) ? "没有更多数据..." : msg);
  }

  @Override public String getType() {
    LogUtils.i(TAG, "type：" + type);
    return type;
  }

  public static GankFragment newInstance(String type) {
    Bundle args = new Bundle();
    args.putString(GANK_DATA_TYPE, type);
    GankFragment fragment = new GankFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @OnClick ({ R.id.tv_error_msg, R.id.iv_data_refresh }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_error_msg:
      case R.id.iv_data_refresh:
        getPresenter().getDataFromNet();
        break;
    }
  }

  @Override public void onRefresh() {
    getPresenter().getDataFromNet();
  }
}
