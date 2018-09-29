package cn.ssic.tianfangcatering.base.mvp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;

import cn.ssic.tianfangcatering.dialog.LoadDialog;
import cn.ssic.tianfangcatering.network.RequestInterface;
import cn.ssic.tianfangcatering.network.RetroftServiceManager;
import cn.ssic.tianfangcatering.utils.StatusBarUtil;
import rx.Observable;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public abstract class MVPBaseActivity<V extends BaseView, T extends BasePresenterImpl<V>> extends RxAppCompatActivity implements BaseView {
    public T mPresenter;
    private RequestInterface mService;
    //此Activity需不需要右滑出动画
    private boolean mEndActivityAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //修改状态字体颜色
        StatusBarUtil.StatusBarLightMode(this);
    }

    public RequestInterface getRequestService() {
        if (null == mService) {
            mService = RetroftServiceManager.getService(RequestInterface.class);
        }
        return mService;
    }

    @Override
    public Context getContext() {
        return this;
    }

    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    //防止Rxjava由于订阅者内存泄漏，每个网络请求必须调用
    public <B> Observable<B> bindObs(Observable<B> observable) {
        return observable.compose(this.<B>bindToLifecycle());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(new Bundle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消掉loading
        LoadDialog.destoryLoading();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
