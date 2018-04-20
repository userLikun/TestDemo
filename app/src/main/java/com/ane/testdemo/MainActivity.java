package com.ane.testdemo;

import android.widget.Button;

import com.ane.testdemo.Proxy.ProxyActivity;
import com.ane.testdemo.base.BaseActivity;
import com.ane.testdemo.recyclerView.RecycleViewActivity;
import com.ane.testdemo.retrofit.RetrofitActivity;
import com.ane.testdemo.test.CB;
import com.ane.testdemo.test.PrintB;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    List<Integer> list  = new ArrayList<Integer>();

    @BindView(R.id.button_click)
    Button btnClick;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new PrintB();
    }

    @OnClick(R.id.button_click)
    public void buttonClick() {
        startToActivity(RecycleViewActivity.class);
    }


    @OnClick(R.id.button_click1)
    public void buttonClick1() {
        startToActivity(MainActivity.class);
    }


    @OnClick(R.id.button_retrofit)
    public void buttonRetrofit() {
        startToActivity(RetrofitActivity.class);
    }

    @OnClick(R.id.button_proxy)
    public void buttonProxy() {
        startToActivity(ProxyActivity.class);
    }
}
