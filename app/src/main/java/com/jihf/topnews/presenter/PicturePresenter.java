package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.constants.GankConstants;
import com.jihf.topnews.contract.GankContract;
import com.jihf.topnews.http.HttpApiMethed;
import com.jihf.topnews.model.gank.GankBaseBean;
import com.jihf.topnews.rx.RxBasePresenter;
import com.jihf.topnews.rx.RxSubscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-05-05 10:31
 * Mail：jihaifeng@raiyi.com
 */
public class PicturePresenter extends RxBasePresenter<GankContract.View> implements GankContract.Presenter {
  public PicturePresenter(Context context) {
    super(context);
  }

  @Override public void getDataFromNet() {
    HttpApiMethed.getGankData(GankConstants.gank_fuli, 1, getmView()).subscribe(new RxSubscriber<GankBaseBean>() {
      @Override protected void onError(String message) {
        getmView().showDataError(message, () -> getDataFromNet());
      }

      @Override public void onNext(GankBaseBean gankBaseBean) {
      }
    });
  }

  @Override public void loadMore(int page) {

  }
}
