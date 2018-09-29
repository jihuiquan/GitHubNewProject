package cn.ssic.tianfangcatering.module.activities.login;


import cn.ssic.tianfangcatering.base.BaseBean;
import cn.ssic.tianfangcatering.base.mvp.BasePresenterImpl;
import cn.ssic.tianfangcatering.dialog.LoadDialog;
import cn.ssic.tianfangcatering.network.ExecuteHttpManger;
import cn.ssic.tianfangcatering.network.NetworkCallback;
import rx.Observable;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {


    @Override
    public void sendDeviceInfo(Observable<BaseBean> observable) {
        ExecuteHttpManger.executeHttp(mView.getContext(), observable, new NetworkCallback<BaseBean>(mView.getContext(), LoadDialog.STRING_LOGINMSG) {
            @Override
            public void onNext(BaseBean bean) {
                if (assertionObjIsNotNull(bean)) {
                    mView.sendDeviceSuccess(bean);
                }
            }

            @Override
            public void onError(String e) {
                if (null != mView) {
                    mView.onFailure(LoginContract.FAILURE_SENDDEVICE, e);
                }
            }
        });
    }

    @Override
    public void pAuthorize(Observable<BaseBean> observable) {
        ExecuteHttpManger.executeHttp(mView.getContext(), observable, new NetworkCallback<BaseBean>(mView.getContext(), LoadDialog.STRING_LOGINMSG) {
            @Override
            public void onNext(BaseBean baseBean) {
                if (assertionObjIsNotNull(baseBean)) {
                    mView.pAuthorizeSuccess(baseBean);
                }
            }

            @Override
            public void onError(String e) {
                if (null != mView) {
                    mView.onFailure(LoginContract.FAILURE_PAUTHORIZE, e);
                }
            }
        });
    }

    @Override
    public void gLogin(Observable<BaseBean<LoginBean>> observable) {
        ExecuteHttpManger.executeHttp(mView.getContext(), observable, new NetworkCallback<BaseBean<LoginBean>>(mView.getContext(), LoadDialog.STRING_LOGINMSG) {
            @Override
            public void onNext(BaseBean<LoginBean> bean) {
                if (assertionObjIsNotNull(bean)) {
                    mView.gLoginSuccess(bean.getData());
                }
            }

            @Override
            public void onError(String e) {
                if (null != mView) {
                    mView.onFailure(LoginContract.FAILURE_GLOGIN, e);
                }
            }
        });
    }
}
