package cn.ssic.tianfangcatering.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * author：${JHuiQ} on 2018/4/14 14:57
 */
public class SPUtil {

    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    public static final String STRING_UUID = "string_uuid";

    /**
     * 账号
     */
    public static final String STRING_ACCOUNT = "string_account";
    /**
     * 密码
     */
    public static final String STRING_PASSWORD = "string_password";
    /**
     * 食堂id
     */
    public static final String STRING_DINNERHALLID = "string_dinnerhallID";
    /**
     * 医院id
     */
    public static final String STRING_HPHOSPITALORGANIZATIONID = "string_dsSchoolDiningHallID";

    /**
     * 登录类型（1，市 2，区 3，医院）
     */
    public static final String INT_LOGINTYPE = "int_logintype";

    public static final String STRING_ACCESSTOKEN = "string_accesstoken";
    public static final String STRING_REFRESHTOKEN = "string_refreshToken";


    public static void putInt(Context context, String key, int valueInt) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, valueInt);
        editor.apply();
    }

    public static void putLong(Context context, String key, long valueLong) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, valueLong);
        editor.apply();
    }

    public static void putFloat(Context context, String key, float valueFloat) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, valueFloat);
        editor.apply();
    }

    public static void putBoolean(Context context, String key, boolean valueBoolean) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, valueBoolean);
        editor.apply();
    }

    public static void putString(Context context, String key, String valueString) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, valueString);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defaultInt) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getInt(key, defaultInt);
    }

    public static int getInt(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }

    public static long getLong(Context context, String key, long defaultLong) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getLong(key, defaultLong);
    }

    public static float getFloat(Context context, String key, float defaultFloat) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getFloat(key, defaultFloat);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultBoolean) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultBoolean);
    }

    public static String getString(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getString(key, null);
    }


    /**
     * 移除某个key值已经对应的值
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }
}
