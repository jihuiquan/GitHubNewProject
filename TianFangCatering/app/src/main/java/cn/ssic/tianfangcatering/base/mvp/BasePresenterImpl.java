package cn.ssic.tianfangcatering.base.mvp;


import cn.ssic.tianfangcatering.utils.ToastCommon;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    protected V mView;
    @Override
    public void attachView(V view) {
        mView=view;
    }

    @Override
    public void detachView() {
        mView=null;
    }

    public boolean assertionObjIsNotNull(Object obj) {
        if (null == mView) {
            return false;
        }
        if (null == obj) {
            ToastCommon.nativityToast(mView.getContext(), "未获取到数据，请稍后重试!");
            return false;
        }
        return true;
    }
}
