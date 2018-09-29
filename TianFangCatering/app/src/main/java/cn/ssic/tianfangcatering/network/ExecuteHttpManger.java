package cn.ssic.tianfangcatering.network;

import android.content.Context;

import cn.ssic.tianfangcatering.base.BaseBean;
import cn.ssic.tianfangcatering.utils.NetWorkUtil;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：${JHuiQ} on 2018/4/9 13:57
 */
public class ExecuteHttpManger {

    public static <T> void executeHttp(final Context context, Observable<T> observable, final NetworkCallback<T> callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        callback.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //调用了onError就不会调用onCompleted
                        callback.onCompleted();
                        if (!NetWorkUtil.hasNetWork()) {
                            callback.onError("网络不可用,请检查网络连接是否可用");
                            return;
                        }
                        if (e.toString().indexOf("TimeoutException") != -1) {
                            callback.onError("  网络超时,请重试!  ");
                            return;
                        }
                        if (e.toString().indexOf("EOFException") != -1) {
                            callback.onError("  数据解析失败!  ");
                            return;
                        }
                        if (e.toString().indexOf("ConnectException") != -1) {
                            callback.onError("  与服务器连接失败,请重试!  ");
                            return;
                        }
                        callback.onError("  获取数据失败!请重试  ");
                    }

                    @Override
                    public void onNext(T t) {
                        if (null == t) {
                            callback.onError("获取数据错误,请尝试重试!");
                            return;
                        }
                        if (t instanceof BaseBean) {
                            BaseBean baseBean = (BaseBean) t;
                            if (baseBean.getRetCode() == HttpResponseCode.STATUS_OK) {
                                callback.onNext(t);
                            } else if (baseBean.getRetCode() == HttpResponseCode.STATUS_TOOMANY) {
                                callback.onError("登录失败次数已超过当天最大限度");
                            } else if (baseBean.getRetCode() == HttpResponseCode.STATUS_ACCOUN_RPASSWORDERROR) {
                                callback.onError("账号或密码输入错误");
                            } else if (baseBean.getRetCode() == HttpResponseCode.STATUS_TOKENINVALID) {
                                callback.onTokenInvalid(context);
                            } else {
                                callback.onError(baseBean.getRetMsg());
                            }
                            return;
                        }
                        callback.onNext(t);
                    }
                });

    }

}
