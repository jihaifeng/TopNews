package com.jihf.topnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.jihf.androidutils.tools.DateTimeUtils;
import com.jihf.androidutils.tools.LogUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.model.gank.GankResultBean;
import com.jihf.topnews.utils.DefaultBgUtils;
import com.jihf.topnews.view.recyclerview.BaseRecyclerAdapter;
import com.jihf.topnews.webview.activity.WebSiteActivity;
import java.util.Date;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-28 17:05
 * Mail：jihaifeng@raiyi.com
 */
public class RyGankAdapter extends BaseRecyclerAdapter<GankResultBean> {

  public RyGankAdapter(Context context) {
    super(context);
  }

  @Override public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gank_item, parent, false);
    return new MyViewHolder(view);
  }

  @Override public void onBind(RecyclerView.ViewHolder vh, int pos, GankResultBean data) {
    if (vh instanceof MyViewHolder) {
      MyViewHolder holder = (MyViewHolder) vh;
      if (null != data) {
        holder.viewDoc.setVisibility(View.VISIBLE);
        holder.tvDesc.setText(data.desc);
        if (null != data.images && data.images.size() != 0) {
          Glide.with(context)
              .load(data.images.get(0))
              .fitCenter()
              .dontAnimate()
              .error(R.mipmap.loading)
              .placeholder(DefaultBgUtils.provideIcon())
              .into(holder.ivLeft);
        } else {
          holder.ivLeft.setImageResource(R.mipmap.loading);
        }
        String publishTime = data.publishedAt;
        int idx = publishTime.lastIndexOf(".");
        publishTime = publishTime.substring(0, idx).replace("T", " ");
        Date date = DateTimeUtils.getDateFormat(publishTime, DateTimeUtils.dateTimeFormat);
        holder.tvTime.setText(null != date ? DateTimeUtils.formatTime2String(date.getTime(), true)
            : DateTimeUtils.formatDateTime(publishTime, true));
        holder.tvWho.setText(data.who);
      }
    }
  }

  @Override protected void onItemClick(int position, GankResultBean data) {
    WebSiteActivity.launch(context, data.desc, data.url);
  }

  @Override protected void OnItemLongClickListener(int position, GankResultBean data) {

  }

  public void setScrolling(boolean isScrolling) {
    try {
      if (isScrolling) {
        Glide.with(context).pauseRequests();
      } else {
        Glide.with(context).resumeRequests();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    LogUtils.i(TAG, "setScrolling: " + isScrolling);
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView (R.id.iv_left) ImageView ivLeft;
    @BindView (R.id.tv_desc) TextView tvDesc;
    @BindView (R.id.tv_who) TextView tvWho;
    @BindView (R.id.tv_time) TextView tvTime;
    @BindView (R.id.view_doc) View viewDoc;

    MyViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
