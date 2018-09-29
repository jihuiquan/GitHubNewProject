package cn.ssic.tianfangcatering.network;

/**
 * author：${JHuiQ} on 2018/4/20 14:34
 */
public class HttpResponseCode {

    /**
     * 请求成功
     */
    public static final int STATUS_OK = 100000;
    /**
     * 登录次数过多
     */
    public static final int STATUS_TOOMANY = 200018;
    /**
     * 账号or密码错误
     */
    public static final int STATUS_ACCOUN_RPASSWORDERROR = 200020;
    /**
     * Token非法
     */
    public static final int STATUS_TOKENINVALID = 200201;
}
