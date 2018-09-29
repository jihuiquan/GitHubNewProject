package cn.ssic.tianfangcatering.network;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.ssic.tianfangcatering.Constant;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * author：${JHuiQ} on 2018/4/9 13:24
 */
public class OkHttpClientManger {
    private static final String TAG = "OkHttpClientManger";

    public static OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(OkHttpClientManger.getHeaderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //失败重连
                .retryOnConnectionFailure(true)
                .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        return okHttpClient;

    }

    private static Interceptor getHeaderInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
//                String accessToken = SPUtil.getString(HospitalApplication.getApplication(), SPUtil.STRING_ACCESSTOKEN);
//                if (!StringUtil.isEmptyWithString(accessToken)) {
//                    //添加Parameter
//                    HttpUrl httpUrl = request.url().newBuilder()
//                            .addQueryParameter("client_id", AppConfig.CLIENT_ID)
//                            .addQueryParameter("installation_id", SPUtil.getString(HospitalApplication.getApplication(), SPUtil.STRING_UUID))
//                            .addQueryParameter("widget_id", AppConfig.WIDGET_ID)
//                            .build();
//                    //添加header
//                    Request builder = request.newBuilder()
//                            .addHeader("AccessToken", accessToken)
//                            .url(httpUrl)
//                            .build();
//
//                    return chain.proceed(builder);
//                }

                return chain.proceed(request);
            }
        };
        return interceptor;
    }
}
