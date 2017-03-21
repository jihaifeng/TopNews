package com.jihf.topnews.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 11:22
 * Mail：jihaifeng@raiyi.com
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public static final String TAG = BaseRecyclerAdapter.class.getSimpleName().trim();
  public static final int TYPE_HEADER = 0;
  public static final int TYPE_NORMAL = 1;
  private List<T> mDatas = new ArrayList<>();
  private View mHeaderView;
  protected Context context;
  private int itemShowNum = -1;

  public BaseRecyclerAdapter(Context context) {
    this.context = context;
  }

  public void setHeaderView(View headerView) {
    mHeaderView = headerView;
    notifyItemInserted(0);
  }

  public View getHeaderView() {
    return mHeaderView;
  }

  public void addDatas(List<T> datas) {
    mDatas.addAll(datas);
    notifyDataSetChanged();
  }

  public void replaceDatas(List<T> datas) {
    mDatas.clear();
    mDatas.addAll(datas);
    notifyDataSetChanged();
  }

  public List<T> getDatas() {
    return mDatas;
  }

  @Override public int getItemViewType(int position) {
    if (mHeaderView == null) {
      return TYPE_NORMAL;
    }
    if (position == 0) {
      return TYPE_HEADER;
    }
    return TYPE_NORMAL;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
    if (mHeaderView != null && viewType == TYPE_HEADER) {
      return new RecyclerView.ViewHolder(mHeaderView) {
      };
    }
    return onCreate(parent, viewType);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    if (getItemViewType(position) == TYPE_HEADER) {
      return;
    }
    final int pos = getRealPosition(viewHolder);
    final T data = mDatas.get(pos);
    onBind(viewHolder, pos, data);
    viewHolder.itemView.setOnClickListener(v -> {
      onItemClick(pos, data);
    });
    viewHolder.itemView.setOnLongClickListener(v -> {
      OnItemLongClickListener(pos, data);
      return false;
    });
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
    RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
    if (manager instanceof GridLayoutManager) {
      final GridLayoutManager gridManager = ((GridLayoutManager) manager);
      gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override public int getSpanSize(int position) {
          return getItemViewType(position) == TYPE_HEADER ? gridManager.getSpanCount() : 1;
        }
      });
    }
  }

  @Override public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
    super.onViewAttachedToWindow(holder);
    ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
    if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams && holder.getLayoutPosition() == 0) {
      StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
      p.setFullSpan(true);
    }
  }

  public int getRealPosition(RecyclerView.ViewHolder holder) {
    int position = holder.getLayoutPosition();
    return mHeaderView == null ? position : position - 1;
  }

  @Override public int getItemCount() {
    int dataLength;
    if (mHeaderView == null) {
      dataLength = mDatas.size();
    } else {
      dataLength = mDatas.size() + 1;
    }
    if (itemShowNum > 0 && itemShowNum < dataLength) {
      dataLength = itemShowNum;
    }
    return dataLength;
  }

  public void setNumToShow(int num) {
    if (num > 0) {
      this.itemShowNum = num;
    } else {
      this.itemShowNum = -1;
    }
  }

  public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, final int viewType);

  public abstract void onBind(RecyclerView.ViewHolder vh, int pos, T data);

  // item 点击
  protected abstract void onItemClick(int position, T data);

  // item 长按
  protected abstract void OnItemLongClickListener(int position, T data);
}
