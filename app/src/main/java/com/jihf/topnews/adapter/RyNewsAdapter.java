package com.jihf.topnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.model.news.NewsBean;
import com.jihf.topnews.utils.DefaultBgUtils;
import com.jihf.topnews.view.recyclerview.BaseRecyclerAdapter;
import com.jihf.topnews.webview.activity.WebSiteActivity;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 16:56
 * Mail：jihaifeng@raiyi.com
 */
public class RyNewsAdapter extends BaseRecyclerAdapter<NewsBean> {

  public RyNewsAdapter(Context context) {
    super(context);
  }

  @Override public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
    return new MyViewHolder(view);
  }

  @Override public void onBind(RecyclerView.ViewHolder vh, int pos, NewsBean data) {
    if (vh instanceof MyViewHolder) {
      MyViewHolder viewHolder = (MyViewHolder) vh;
      if (null != data) {
        if (TextUtils.isEmpty(data.thumbnail_pic_s) || TextUtils.isEmpty(data.thumbnail_pic_s02) || TextUtils.isEmpty(
            data.thumbnail_pic_s03)) {
          viewHolder.viewRootOne.setVisibility(View.VISIBLE);
          viewHolder.viewRootThree.setVisibility(View.GONE);
          viewHolder.tvTitleOne.setText(TextUtils.isEmpty(data.title) ? "" : data.title);
          viewHolder.tvFromOne.setText(TextUtils.isEmpty(data.author_name) ? "" : data.author_name);
          viewHolder.tvTimeOne.setText(TextUtils.isEmpty(data.date) ? "" : data.date);
          if (!TextUtils.isEmpty(data.thumbnail_pic_s)) {
            loadImage(data.thumbnail_pic_s, viewHolder.ivRight);
          }
        } else {
          viewHolder.viewRootOne.setVisibility(View.GONE);
          viewHolder.viewRootThree.setVisibility(View.VISIBLE);
          viewHolder.tvTitleThree.setText(TextUtils.isEmpty(data.title) ? "" : data.title);
          viewHolder.tvFromThree.setText(TextUtils.isEmpty(data.author_name) ? "" : data.author_name);
          viewHolder.tvTimeThree.setText(TextUtils.isEmpty(data.date) ? "" : data.date);
          if (!TextUtils.isEmpty(data.thumbnail_pic_s)) {
            loadImage(data.thumbnail_pic_s, viewHolder.ivBottomLeft);
          }
          if (!TextUtils.isEmpty(data.thumbnail_pic_s02)) {
            loadImage(data.thumbnail_pic_s02, viewHolder.ivBottomCenter);
          }
          if (!TextUtils.isEmpty(data.thumbnail_pic_s03)) {
            loadImage(data.thumbnail_pic_s03, viewHolder.ivBottomRight);
          }
        }
      }
    }
  }

  private void loadImage(String thumbnail_pic, ImageView view) {
    Glide.with(context)
        .load(thumbnail_pic)
        .fitCenter()
        .dontAnimate()
        .error(DefaultBgUtils.provideIcon())
        .placeholder(DefaultBgUtils.provideIcon())
        .into(view);
  }

  public void setScrolling(boolean isScrolling) {
    if (isScrolling) {
      Glide.with(context).pauseRequests();
    } else {
      Glide.with(context).resumeRequests();
    }
    LogUtils.i(TAG, "setScrolling: " + isScrolling);
  }

  static class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView (R.id.tv_title_one) TextView tvTitleOne;
    @BindView (R.id.iv_right) ImageView ivRight;
    @BindView (R.id.tv_from_one) TextView tvFromOne;
    @BindView (R.id.tv_time_one) TextView tvTimeOne;
    @BindView (R.id.tv_title_three) TextView tvTitleThree;
    @BindView (R.id.iv_bottom_left) ImageView ivBottomLeft;
    @BindView (R.id.iv_bottom_center) ImageView ivBottomCenter;
    @BindView (R.id.iv_bottom_right) ImageView ivBottomRight;
    @BindView (R.id.ll_image_bottom) LinearLayout llImageBottom;
    @BindView (R.id.tv_from_three) TextView tvFromThree;
    @BindView (R.id.tv_time_three) TextView tvTimeThree;
    @BindView (R.id.root_one) View viewRootOne;
    @BindView (R.id.root_three) View viewRootThree;

    MyViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }

  @Override protected void onItemClick(int position, NewsBean data) {
    WebSiteActivity.launch(context, data.title, data.url);
  }

  @Override protected void OnItemLongClickListener(int position, NewsBean data) {

  }
}
