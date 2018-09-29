package cn.ssic.tianfangcatering.base.mvp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.RxFragment;

import java.lang.reflect.ParameterizedType;

import cn.ssic.tianfangcatering.network.RequestInterface;
import cn.ssic.tianfangcatering.network.RetroftServiceManager;
import rx.Observable;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public abstract class MVPBaseFragment<V extends BaseView, T extends BasePresenterImpl<V>> extends RxFragment implements BaseView {
    public T mPresenter;
    private RequestInterface mService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
    }

    public RequestInterface getRequestService() {
        if (null == mService) {
            mService = RetroftServiceManager.getService(RequestInterface.class);
        }
        return mService;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 防止Rxjava由于订阅者内存泄漏，每个网络请求必须调用
     *
     * @param observable
     * @param <B>
     * @return
     */
    public <B> Observable<B> bindObs(Observable<B> observable) {
        return observable.compose(this.<B>bindToLifecycle());
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (Fragment.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
