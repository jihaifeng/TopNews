package com.jihf.topnews.contract;

import com.jihf.topnews.model.gank.GankBaseBean;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 18:07
 * Mail：jihaifeng@raiyi.com
 */
public interface GankContract {
  interface View extends RxBaseView {
    void showData(GankBaseBean gankBaseBean);

    String getType();

    void showMore(GankBaseBean gankBaseBean);

    void showMoreError(String moreError);
  }

  interface Presenter extends RxPresenter<View> {
    void getDataFromNet();

    void loadMore(int page);
  }
}
