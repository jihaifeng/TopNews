package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.contract.GankContract;
import com.jihf.topnews.http.HttpApiMethed;
import com.jihf.topnews.model.gank.GankBaseBean;
import com.jihf.topnews.rx.RxBasePresenter;
import com.jihf.topnews.rx.RxSubscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-27 18:07
 * Mail：jihaifeng@raiyi.com
 */
public class GankPresenter extends RxBasePresenter<GankContract.View> implements GankContract.Presenter {
  public GankPresenter(Context context) {
    super(context);
  }

  @Override public void getDataFromNet() {
    HttpApiMethed.getGankData(getmView().getType(), getmView().getPage(), getmView())
        .subscribe(new RxSubscriber<GankBaseBean>() {
          @Override protected void onError(String message) {
            getmView().showError(message);
          }

          @Override public void onNext(GankBaseBean gankBaseBean) {
            getmView().showData(gankBaseBean);
          }
        });
  }
}
