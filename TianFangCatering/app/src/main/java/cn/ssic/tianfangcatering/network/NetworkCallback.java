package cn.ssic.tianfangcatering.network;

import android.content.Context;
import android.util.Log;

import cn.ssic.tianfangcatering.dialog.LoadDialog;


/**
 * author：${JHuiQ} on 2018/4/9 13:59
 */
public abstract class NetworkCallback<T> {

    private String mAnimStr;
    private Context mContext;
    private String mMsg;
    private static final String TAG = "BaseCallback";

    public NetworkCallback() {
    }

    public NetworkCallback(Context context) {
        this.mContext = context;
    }

    public NetworkCallback(Context context, String msg) {
        this.mContext = context;
        this.mMsg = msg;
    }

    public NetworkCallback(Context context, String msg, String animStr) {
        this.mContext = context;
        this.mMsg = msg;
        this.mAnimStr = animStr;
    }


    public void onStart() {
        Log.d(TAG, "---ssssssstart-------发----起----请----求----网-----络--------------------------------------------------------");
        if (null != mContext) {
            LoadDialog.showLoading(mContext, mMsg, mAnimStr);
        }
    }

    public void onCompleted() {
        LoadDialog.dismissLoading();
        Log.d(TAG, "---eeeeeeend-------网-----络-----请-----求-----结-----束------------------------------------------------------");
    }

    public abstract void onNext(T t);

    public abstract void onError(String e);

    public void onTokenInvalid(final Context context) {

    }
}
