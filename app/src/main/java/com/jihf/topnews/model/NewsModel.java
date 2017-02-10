package com.jihf.topnews.model;

import android.content.Context;
import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.entity.ResultBean;
import com.jihf.topnews.http.HttpMethod;
import com.jihf.topnews.http.HttpResultFuc;
import com.jihf.topnews.presenter.NewsPresenter;
import com.jihf.topnews.rx.RxSubscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 16:06
 * Mail：jihaifeng@raiyi.com
 */
public class NewsModel {
  private NewsPresenter newsPresenter;

  public NewsModel(NewsPresenter newsPresenter) {
    this.newsPresenter = newsPresenter;
  }

  public void loadData(Context context) {

    HttpMethod.getTopNewsObservable(JuHeConstants.TYPE_TOP)
        .map(new HttpResultFuc<ResultBean>())
        .subscribe(new RxSubscriber<ResultBean>() {

          @Override public void onError(String msg) {
            newsPresenter.onFailure(msg);
          }

          @Override public void onNext(ResultBean resultBean) {
            newsPresenter.onSuccess(resultBean);
          }
        });
  }
}
