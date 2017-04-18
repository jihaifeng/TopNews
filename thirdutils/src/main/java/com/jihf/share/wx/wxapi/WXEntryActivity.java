package com.jihf.share.wx.wxapi;

import android.app.Activity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-18 14:43
 * Mail：jihaifeng@raiyi.com
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

  @Override public void onReq(BaseReq baseReq) {
  }

  @Override public void onResp(BaseResp resp) {
    int errorCode = resp.errCode;
    switch (errorCode) {
      case BaseResp.ErrCode.ERR_OK:
        //用户同意
        String code = ((SendAuth.Resp) resp).code;
        break;
      case BaseResp.ErrCode.ERR_AUTH_DENIED:
        //用户拒绝
        break;
      case BaseResp.ErrCode.ERR_USER_CANCEL:
        //用户取消
        break;
      default:
        break;
    }
  }
}
