package com.jihf.topnews.contract;

import com.jihf.topnews.model.picture.PictureBean;
import com.jihf.topnews.rx.RxBaseView;
import com.jihf.topnews.rx.RxPresenter;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-05-05 10:32
 * Mail：jihaifeng@raiyi.com
 */
public interface PictureContrat {
  interface View extends RxBaseView {
    void showData(PictureBean pictureBean);

    String getType();
  }

  interface Presenter extends RxPresenter<View> {
    void getDataFromNet();
  }
}
