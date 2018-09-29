package cn.ssic.tianfangcatering.network;

import cn.ssic.tianfangcatering.base.BaseBean;
import cn.ssic.tianfangcatering.config.AppConfig;
import cn.ssic.tianfangcatering.module.activities.login.LoginBean;
import cn.ssic.tianfangcatering.module.activities.login.PLoginInfo;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author：${JHuiQ} on 2018/4/9 11:47
 */
public interface RequestInterface {
    @GET(AppConfig.oauthUrl + "/api/v1.0/oauth/register_installation_id")
    Observable<BaseBean> gRegisterInstallationId(@Query("client_id") String clientId, @Query("installation_id") String installationId, @Query("device_info") String deviceInfo);

    @POST(AppConfig.oauthUrl + "/api/v1.0/oauth/authorize")
    Observable<BaseBean> pAuthorize(@Query("client_id") String clientId, @Query("response_type") String responseType, @Query("redirect_url") String redirectUrl,
                                    @Query("device_info") String deviceInfo, @Query("installation_id") String uuid, @Body PLoginInfo pLoginInfo);

    @GET("/api/v1.0/hospitaldinner/application/login")
    Observable<BaseBean<LoginBean>> gLogin(@Query("client_id") String clientId, @Query("device_info") String deviceInfo,
                                           @Query("installation_id") String installationId, @Query("code") String code);
}
