package cn.ssic.tianfangcatering;

import android.view.View;

/**
 * @package: com.ssic.yytc
 * @author：JHQ
 * @date： 2018/4/19  9:15
 */
public class Constant {

    //PermissionUtil无对应权限返回此字符串
    public static final String NO_PERMISSION = "MissingPermission";
    //---上拉加载更多和下拉刷新---
    //自动刷新延迟加载时间（毫秒）
    public static final int AUTOREFRESH_DELAYED = 0;
    //拖拽动画持续时间（毫秒）
    public static final int AUTOREFRESH_DURATION = 200;
    //拉拽的高度比率（要求 ≥ 1 ）
    public static final int AUTOREFRESH_DRAGRATE = 1;

    public static final int CHECK_STATUS_WAIT = 1;
    public static final int CHECK_STATUS_READY = 2;
    public static final int CHECK_STATUS_ALL = 3;

    //---MenuActivity---
    //双击时间段可以退出应用（毫秒）
    public static final int EXIT_APP = 2000;

    /**
     * 1：市
     * 2：区
     * 3：医院
     */
    public static final int LOGIN_TYPE_CITY = 1;
    public static final int LOGIN_TYPE_AREA = 2;
    public static final int LOGIN_TYPE_SCHOOL = 3;

    public static final int LISTENER_TYPE_ONE = 1;
    public static final int LISTENER_TYPE_TWO = 2;
    public static final int LISTENER_TYPE_THREE = 3;
    //回调不需要传的参数，且必须需要传时
    public static final int LISTENER_TYPE_INT_NULL = -1;
    public static final String LISTENER_TYPE_STRING_NULL = null;
    public static final boolean LISTENER_TYPE_BOOLEAN_NULL = false;
    public static final View LISTENER_TYPE_VIEW_NULL = null;
    public static final String WARN_CHECK = "全选";
    public static final String WARN_UNCHECK = "取消全选";
    public static final String DATA_EXCEPTION = "数据未获取到，请稍后重试";

    /**
     * 1:已验收
     * 2：待验收
     */
    public static final int CHECK_STATUS_TYPE_ONE = 1957;
    public static final int CHECK_STATUS_TYPE_TWO = 2;
    /**
     * 网络请求超时时长
     */
    public static final int CONNECT_TIMEOUT = 20;

    /**
     * 原料
     */
    public static final int CHECK_DISTRIBUTIONGOODSTYPE_ONE = 1102;

    public static final String STRING_CHECK_ACCEPTANCE = "待验收";
    public static final String STRING_CHECK_ACCEPTED = "已验收";
    public static final String STRING_CHECK_FINISHEDDISH = "成品菜:";
    public static final String STRING_CHECK_MATERIAL = "原料:";
    /**
     * 1:直配
     * 2:统配
     */
    public static final int CHECK_DELIVERY_TYPE_ONE = 1;
    public static final int CHECK_DELIVERY_TYPE_TWO = 2;
    public static final int CHECK_DELIVERY_TYPE_ONE_TABLE = 2;

    /**
     * dbNAME
     */
    public static final String DB_NAME = "hospital-name";

    /**
     * 1、医院
     * 2、学校
     */
    public static final String TARGET_ENTITY_TYPE_ID = "1";
}
