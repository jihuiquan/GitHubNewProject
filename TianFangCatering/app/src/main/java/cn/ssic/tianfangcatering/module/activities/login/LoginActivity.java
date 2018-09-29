package cn.ssic.tianfangcatering.module.activities.login;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.UUID;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.ssic.tianfangcatering.R;
import cn.ssic.tianfangcatering.base.BaseBean;
import cn.ssic.tianfangcatering.base.mvp.MVPBaseActivity;
import cn.ssic.tianfangcatering.config.AppConfig;
import cn.ssic.tianfangcatering.utils.DeviceUtil;
import cn.ssic.tianfangcatering.utils.KeyBoardUtil;
import cn.ssic.tianfangcatering.utils.PermissionUtil;
import cn.ssic.tianfangcatering.utils.SPUtil;
import cn.ssic.tianfangcatering.utils.StringUtil;
import cn.ssic.tianfangcatering.utils.ToastCommon;
import cn.ssic.tianfangcatering.utils.UUIDUtil;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @InjectView(R.id.account_et)
    EditText mAccountEt;
    @InjectView(R.id.account_del_iv)
    ImageView mAccountDelIv;
    @InjectView(R.id.password_et)
    EditText mPasswordEt;
    @InjectView(R.id.password_del_iv)
    ImageView mPasswordDelIv;
    private static final String TAG = "LoginActivity";
    private String mUuidStr;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        //第一次进入页面，申请系统权限弹窗
        PermissionUtil.requestPermissions(this, new String[]{
                Manifest.permission.READ_PHONE_STATE
        });
        initEvent();
//        mAccountEt.setText("kfxx1");
        mAccountEt.setText("lihongmei");
//        mPasswordEt.setText("123456");
        mPasswordEt.setText("123456");
        SPUtil.remove(this, SPUtil.STRING_ACCESSTOKEN);
        String deviceInfo = DeviceUtil.getDeviceInfo(this);
        mUuidStr = StringUtil.byteToBase64(UUIDUtil.convertUUIDToBytes(UUID.randomUUID()));
        mPresenter.sendDeviceInfo(bindObs(getRequestService().gRegisterInstallationId(AppConfig.CLIENT_ID, mUuidStr, StringUtil.stringToBase64(deviceInfo))));
    }

    private void initEvent() {
        mAccountEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    mAccountDelIv.setVisibility(View.GONE);
                } else {
                    mAccountDelIv.setVisibility(View.VISIBLE);
                }
            }
        });
        mPasswordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    mPasswordDelIv.setVisibility(View.GONE);
                } else {
                    mPasswordDelIv.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @OnClick({R.id.login_bt, R.id.ll, R.id.account_del_iv, R.id.password_del_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                SPUtil.remove(this, SPUtil.STRING_ACCESSTOKEN);
                pAuthorize();
                break;
            case R.id.ll:
                //关闭软键盘
                KeyBoardUtil.hideKey(mPasswordEt, this);
                break;
            case R.id.account_del_iv:
                mAccountEt.setText("");
                break;
            case R.id.password_del_iv:
                mPasswordEt.setText("");
                break;
            default:
                break;
        }

    }

    private void pAuthorize() {
        SPUtil.remove(this, SPUtil.STRING_ACCESSTOKEN);
        PLoginInfo info = new PLoginInfo();
        info.setUsername(mAccountEt.getText().toString().trim());
        info.setPassword(mPasswordEt.getText().toString().trim());
        mPresenter.pAuthorize(bindObs(getRequestService().pAuthorize(AppConfig.CLIENT_ID, "code", AppConfig.REDIRECT_URL, StringUtil.stringToBase64(DeviceUtil.getDeviceInfo(this)), SPUtil.getString(this, SPUtil.STRING_UUID), info)));
    }

    private void gLogin(String code) {
        SPUtil.remove(this, SPUtil.STRING_ACCESSTOKEN);
        mPresenter.gLogin(bindObs(getRequestService().gLogin(AppConfig.CLIENT_ID, StringUtil.stringToBase64(DeviceUtil.getDeviceInfo(this)), SPUtil.getString(this, SPUtil.STRING_UUID), code)));

    }

    @Override
    public void sendDeviceSuccess(BaseBean baseBean) {
        SPUtil.putString(this, SPUtil.STRING_UUID, mUuidStr);
    }

    @Override
    public void pAuthorizeSuccess(BaseBean baseBean) {
        if (baseBean.getData() instanceof String) {
            String dataStr = (String) baseBean.getData();
            String[] split = dataStr.split("=");
            String codeStr = split[1];
            gLogin(codeStr);
        }
    }

    @Override
    public void gLoginSuccess(LoginBean loginBean) {
        if (null != loginBean) {
            ToastCommon.toastSuccess(this, "登录成功");
        } else {
            onFailure(LoginContract.FAILURE_GLOGIN, "登录失败，请重新尝试");
        }
    }

    @Override
    public void onFailure(int failureType, String failureStr) {
        ToastCommon.toast(this, failureStr);
    }
}
