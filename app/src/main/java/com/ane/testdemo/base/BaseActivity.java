package com.ane.testdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/3/27.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract int getContentViewId();

    public abstract void initView();

    public abstract void initData();


    public void startToActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
