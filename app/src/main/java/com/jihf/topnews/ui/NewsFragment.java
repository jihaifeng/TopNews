package com.jihf.topnews.ui;

import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.Unbinder;
import com.jakewharton.rxbinding.view.RxView;
import com.jihf.topnews.R;
import com.jihf.topnews.base.BaseMvpFragment;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.presenter.NewsPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-22 15:52
 * Mail：jihaifeng@raiyi.com
 */
public class NewsFragment extends BaseMvpFragment<NewsView, NewsPresenter> implements NewsView {
  @BindView (R.id.btn_top_get) Button btnTopGet;
  Unbinder unbinder;

  @Override protected int getLayoutId() {
    return R.layout.fragment_news;
  }

  @Override protected NewsPresenter initPresenter() {
    return new NewsPresenter(getActivity());
  }

  @Override protected void initViewAndEvent() {
    RxView.clicks(btnTopGet).subscribe(aVoid -> {
      showLoading();
      getPresenter().getData();
    });
  }

  @Override public void showData(ResultBean resultBean) {
    Toast.makeText(getActivity(), resultBean.data.get(0).author_name, Toast.LENGTH_SHORT).show();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
