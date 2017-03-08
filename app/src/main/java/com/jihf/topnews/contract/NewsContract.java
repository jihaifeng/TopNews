package com.jihf.topnews.contract;

import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-28 12:45
 * Mail：jihaifeng@raiyi.com
 */
public interface NewsContract {
  interface View extends RxBaseView {
    void showData(ResultBean resultBean);
  }

  interface Presenter extends RxPresenter<View> {
    void getDataFromNet();
  }
}
