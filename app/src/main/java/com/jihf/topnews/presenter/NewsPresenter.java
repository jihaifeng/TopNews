package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.base.BasePresenter;
import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.http.HttpApiMethed;
import com.jihf.topnews.http.HttpResultFuc;
import com.jihf.topnews.model.news.ResultBean;
import com.jihf.topnews.progress.ProgressSubscriber;
import com.jihf.topnews.rx.RxSchedulersHelper;
import com.jihf.topnews.rx.RxSubscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 15:58
 * Mail：jihaifeng@raiyi.com
 */
public class NewsPresenter extends BasePresenter<NewsView> {

  public NewsPresenter(Context context) {
    super(context);
  }

  public void getData() {
    HttpApiMethed.getJuheApiService()
        //获取新闻头条数据
        .getTopNews(JuHeConstants.KEY_NEWS, JuHeConstants.TYPE_TOP)
        // 线程指定
        .compose(RxSchedulersHelper.io_main())
        // 生命周期绑定
        .compose(getMvpView().bindToLifecycle())
        // 数据预处理
        .map(new HttpResultFuc<>())
        // 订阅
        .subscribe(new RxSubscriber<ResultBean>() {

          @Override protected void onError(String msg) {
            getMvpView().showError(msg);
          }

          @Override public void onNext(ResultBean bean) {
            getMvpView().showData(bean);
          }
        });
  }

  public void getData2() {
    HttpApiMethed.getJuheApiService()
        //获取新闻头条数据
        .getTopNews(JuHeConstants.KEY_NEWS, JuHeConstants.TYPE_TOP)
        // 线程指定
        .compose(RxSchedulersHelper.io_main())
        // 生命周期绑定
        .compose(getMvpView().bindToLifecycle())
        // 数据预处理
        .map(new HttpResultFuc<>())
        // 订阅
        .subscribe(new ProgressSubscriber<ResultBean>(context) {
          @Override public void onError(String msg) {
            getMvpView().showError(msg);
          }

          @Override public void onNext(ResultBean bean) {
            getMvpView().showData(bean);
          }
        });
  }
}
