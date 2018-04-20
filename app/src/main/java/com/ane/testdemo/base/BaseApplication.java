package com.ane.testdemo.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by lenovo on 2018/3/28.
 */

public class BaseApplication extends Application {
    private static Context mContext;
    private volatile static BaseApplication mInstance;

    private BaseApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        init();
    }

    protected void init(){

    };

    public static Context getContext() {
        return mContext;
    }

    public static BaseApplication getInstance() {
        if(mInstance == null) {
            synchronized (BaseApplication.class) {
                mInstance = new BaseApplication();
            }
        }
        return mInstance;
    }
}
