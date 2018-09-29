package cn.ssic.tianfangcatering.config;

/**
 * author：${JHuiQ} on 2018/4/11 09:51
 */
public class AppConfig {

    /**
     * 环境切换
     */
//    public static final String oauthUrl = "http://192.168.1.230:9000";
//    public static final String baseUrl = "http://192.168.1.230:9000";
    public static final String oauthUrl = "http://dev.tfsiunique.com";
    public static final String baseUrl = "http://dev.tfhospital.com";

    /**
     * client_id 第一次进入app传入
     */
//    public static final String CLIENT_ID = "I_h9T8fxRoGReZx7Ng7fkQ";   //230
    public static final String CLIENT_ID = "v78ygsv0RxGjdGC4038Gtw";    //dev
    /**
     * 第三方应用用于接受授权码的重定向网址，
     * 用户鉴权成功后，客户端代理将收到的授权码重定向到此第三方应用网址
     */
//    public static final String REDIRECT_URL = "http://test.tfsiedu.com";
    public static final String REDIRECT_URL = "http://dev.tfhospital.com";

    public static final String WIDGET_ID = "1";
}
