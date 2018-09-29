package cn.ssic.tianfangcatering.module.activities.login;


import cn.ssic.tianfangcatering.base.BaseBean;
import cn.ssic.tianfangcatering.base.mvp.BasePresenter;
import cn.ssic.tianfangcatering.base.mvp.BaseView;
import rx.Observable;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginContract {
    public static final int FAILURE_PAUTHORIZE = 0;
    public static final int FAILURE_GLOGIN = 1;
    public static final int FAILURE_SENDDEVICE = 2;

    interface View extends BaseView {
        void sendDeviceSuccess(BaseBean baseBean);
        void pAuthorizeSuccess(BaseBean baseBean);

        void gLoginSuccess(LoginBean loginBean);

        void onFailure(int type, String failureMsg);
    }

    interface Presenter extends BasePresenter<View> {

        void sendDeviceInfo(Observable<BaseBean> observable);
        void pAuthorize(Observable<BaseBean> observable);

        void gLogin(Observable<BaseBean<LoginBean>> observable);

    }
}
