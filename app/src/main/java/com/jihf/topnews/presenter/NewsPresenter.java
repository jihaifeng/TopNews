package com.jihf.topnews.presenter;

import android.content.Context;
import com.jihf.topnews.base.BasePresenter;
import com.jihf.topnews.constants.JuHeConstants;
import com.jihf.topnews.constants.UrlConstants;
import com.jihf.topnews.contract.NewsView;
import com.jihf.topnews.entity.ResultBean;
import com.jihf.topnews.http.HttpResult;
import com.jihf.topnews.http.HttpResultFuc;
import com.jihf.topnews.http.JuheApiService;
import com.jihf.topnews.model.NewsModel;
import com.jihf.topnews.progress.ProgressSubscriber;
import com.jihf.topnews.rx.RxHelper;
import com.jihf.topnews.rx.RxSchedulersHelper;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 15:58
 * Mail：jihaifeng@raiyi.com
 */
public class NewsPresenter extends BasePresenter<NewsView> {
  private NewsModel newsModel;
  private NewsView newsView;

  public NewsPresenter(NewsView newsView) {
    attachView(newsView);
    this.newsView = newsView;
    this.newsModel = new NewsModel(this);
  }

  public void loadData(Context context) {
    //newsModel.loadData(context);
    JuheApiService service = RxHelper.getInstance().getApiService(UrlConstants.URL_TOP_NEWS, JuheApiService.class);
    service.getTopNews(JuHeConstants.KEY_NEWS, JuHeConstants.TYPE_TOP)
        // 线程指定
        .compose(RxSchedulersHelper.<HttpResult<ResultBean>>io_main())
        // 生命周期绑定
        .compose(newsView.<HttpResult<ResultBean>>bindToLifecycle())
        // 数据预处理
        .map(new HttpResultFuc<ResultBean>())
        // 订阅
        .subscribe(new ProgressSubscriber<ResultBean>(context) {
          @Override public void onError(String msg) {
            newsView.showError(msg);
          }

          @Override public void onNext(ResultBean resultBean) {
            newsView.showData(resultBean);
          }
        });
  }

  @Override public void onSuccess(ResultBean resultBean) {
    getMvpView().showData(resultBean);
  }

  @Override public void onFailure(String msg) {
    getMvpView().showError(msg);
  }
}
