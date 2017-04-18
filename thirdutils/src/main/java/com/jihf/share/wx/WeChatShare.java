package com.jihf.share.wx;

import android.content.Context;
import android.widget.Toast;
import com.jihf.constants.Constants;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-18 13:30
 * Mail：jihaifeng@raiyi.com
 */
public class WeChatShare {
  // 第三方APP和微信通信的openApi接口
  private static IWXAPI iwxapi;
  private static Context mContext;

  public static WeChatShare regToWx(Context context) {
    mContext = context;
    // WXAPIFactory工厂，获取IWXAPI实例
    iwxapi = WXAPIFactory.createWXAPI(context, Constants.WeChat_APPID, true);
    // 注册应用
    boolean flag = iwxapi.registerApp(Constants.WeChat_APPID);
    Toast.makeText(context, "flag:" + flag, Toast.LENGTH_SHORT).show();
    return new WeChatShare();
  }

  public void share(String shareText) {
    // 初始化一个WXTextObject对象
    WXTextObject textObject = new WXTextObject();
    textObject.text = shareText;
    // 用WXTextObject 对象初始化一个WXMediaMessage对象
    WXMediaMessage mediaMessage = new WXMediaMessage();
    mediaMessage.mediaObject = textObject;
    mediaMessage.description = shareText;
    // 构造Req
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = buildTransaction("text");
    req.message = mediaMessage;
    /*
     * 发送到聊天界面——WXSceneSession
     * 发送到朋友圈——WXSceneTimeline
     * 添加到微信收藏——WXSceneFavorite
     */
    req.scene = SendMessageToWX.Req.WXSceneTimeline;
    iwxapi.sendReq(req);
  }

  private String buildTransaction(String type) {
    return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
  }
}
