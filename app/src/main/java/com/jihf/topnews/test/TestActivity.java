package com.jihf.topnews.test;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import com.jihf.androidutils.tools.snackBar.SnackBarType;
import com.jihf.androidutils.tools.snackBar.SnackBarUtils;
import com.jihf.topnews.R;
import com.jihf.topnews.app.App;
import com.jihf.topnews.base.BaseSimpleActivity;
import com.jihf.topnews.db.db_manager.DbManager;
import com.jihf.topnews.db.db_module.JsonModule;
import com.jihf.topnews.rx.RxSchedulersHelper;
import java.util.List;
import org.json.JSONObject;
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
  @BindView (R.id.rl_root) RelativeLayout rlRoot;

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
    // 创建广告View
    String adPlaceId = "2015351"; //  重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
    AdView adView = new AdView(this, adPlaceId);
    final RelativeLayout layout = new RelativeLayout(this);
    final RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);
    // 将adView添加到父控件中(注：该父控件不一定为您的根控件，只要该控件能通过addView能添加广告视图即可)
    layout.addView(adView, rllp);
    if (layout.getParent() != null) {
      ((ViewGroup) layout.getParent()).removeView(adView);
    }
    // 设置监听器
    adView.setListener(new AdViewListener() {
      public void onAdSwitch() {
        Log.i(TAG, "onAdSwitch");
      }

      public void onAdShow(JSONObject info) {
        // 广告已经渲染出来
        Log.i(TAG, "onAdShow " + info.toString());
      }

      public void onAdReady(AdView adView) {
        // 资源已经缓存完毕，还没有渲染出来
        Log.i(TAG, "onAdReady " + adView);
      }

      public void onAdFailed(String reason) {
        Log.i(TAG, "onAdFailed " + reason);
      }

      public void onAdClick(JSONObject info) {
        // Log.i(TAG, "onAdClick " + info.toString());

      }

      @Override public void onAdClose(JSONObject arg0) {
        Log.i(TAG, "onAdClose");
      }
    });
    // 将adView添加到父控件中(注：该父控件不一定为您的根控件，只要该控件能通过addView能添加广告视图即可)
    //RelativeLayout.LayoutParams rllp1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
    //    RelativeLayout.LayoutParams.WRAP_CONTENT);
    //rllp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    rlRoot.addView(layout);
  }
}
