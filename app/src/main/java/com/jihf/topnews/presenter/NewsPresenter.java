package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.contract.NewsContract;
import com.jihf.topnews.http.HttpApiMethed;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.rx.RxBasePresenter;
import com.jihf.topnews.rx.RxSubscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 15:58
 * Mail：jihaifeng@raiyi.com
 */
public class NewsPresenter extends RxBasePresenter<NewsContract.View> implements NewsContract.Presenter {

  public NewsPresenter(Context context) {
    super(context);
  }

  @Override public void getDataFromNet() {
    HttpApiMethed.getTopNews(getmView().getType(), getmView()).subscribe(new RxSubscriber<ResultBean>() {

      @Override protected void onError(String message) {
        getmView().showError(message);
      }

      @Override public void onNext(ResultBean bean) {
        getmView().showData(bean);
      }
    });
  }
}
