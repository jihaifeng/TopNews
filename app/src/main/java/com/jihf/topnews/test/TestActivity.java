package com.jihf.topnews.test;

import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.BindView;
import com.example.thirdutils.share.WeChatShare;
import com.jihf.androidutils.tools.snackBar.SnackBarType;
import com.jihf.androidutils.tools.snackBar.SnackBarUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import com.jihf.topnews.base.BaseSimpleActivity;
import com.jihf.topnews.db.db_manager.DbManager;
import com.jihf.topnews.db.db_module.JsonModule;
import com.jihf.topnews.rx.RxSchedulersHelper;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-03-20 10:41
 * Mail：jihaifeng@raiyi.com
 */
public class TestActivity extends BaseSimpleActivity {
  int i = 0;
  @BindView (R.id.ll_root) LinearLayout llRoot;
  @BindView (R.id.btn_save) Button btnSave;
  @BindView (R.id.btn_get) Button btnGet;
  @BindView (R.id.btn_other) Button btnOther;
  @BindView (R.id.btn_share_wx) Button btnShareWx;

  @Override protected int getLayoutId() {
    return R.layout.activity_test;
  }

  @Override protected void initViewAndEvent() {
    getToolBar().setTitle("测试");
    btnOther.setOnClickListener(v -> jumpTo(OtherActivity.class));
    btnSave.setOnClickListener(v -> {
      i++;
      String val = "json_data_" + i;
      JsonModule jsonModule = new JsonModule();
      jsonModule.json_key = "data";
      jsonModule.json_str = val;
      jsonModule.save();
      App.getInstance().getDbManager().insertNewsJson("json_data_" + i);
    });

    btnGet.setOnClickListener(v -> {
      Observable<List<String>> observable = App.getInstance().getDbManager().getJsonStr(DbManager.key_json_news);
      observable.compose(RxSchedulersHelper.io_main()).subscribe(new Subscriber<List<String>>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {
          //Exception thrown on Scheduler.Worker thread. Add
          SnackBarUtils.creatShort(llRoot, e.getMessage()).setType(SnackBarType.Confirm).show();
        }

        @Override public void onNext(List<String> list) {

          SnackBarUtils.creatShort(llRoot, list.get(0)).setType(SnackBarType.Confirm).show();
        }
      });
    });

    btnShareWx.setOnClickListener(v -> WeChatShare.regToWx(TestActivity.this).share("hello"));
  }
}
