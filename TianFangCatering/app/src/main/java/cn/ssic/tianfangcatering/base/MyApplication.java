package cn.ssic.tianfangcatering.base;

import android.app.Application;


public class MyApplication extends Application {

//    private DaoSession mDaoSession;
    private static MyApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;

    }

    public static MyApplication getApplication() {
        return sBaseApplication;
    }
}
