package com.ane.testdemo.Proxy;

import android.widget.TextView;

import com.ane.testdemo.Proxy.proxy_staic.Man;
import com.ane.testdemo.Proxy.proxy_staic.Procurement;
import com.ane.testdemo.R;
import com.ane.testdemo.base.BaseActivity;

import java.lang.reflect.Proxy;

import butterknife.BindView;

public class ProxyActivity extends BaseActivity {

    @BindView(R.id.textview)
    TextView textView;

    @Override
    public int getContentViewId() {
        return R.layout.activity_proxy;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

//        DynamicProxy proxy = new DynamicProxy();
        // 2. 创建 目标类 对象
        RealSubject subject = new RealSubject();

        // 3. 创建动态代理类 & 对象：通过调用处理器类对象newProxyInstance（）
        // 传入上述目标类对象
//        BuySomething Buyer1_DynamicProxy = (BuySomething) proxy.newProxyInstance(BuySomething.class, subject);
        BuySomething Buyer1_DynamicProxy =
                // 返回的是 IBank 的一个实例对象，这个对象是由 Java 给我们创建的 ,调用的是 jni
                (BuySomething) Proxy.newProxyInstance(
                        BuySomething.class.getClassLoader(), // ClassLoader
                        new Class<?>[]{BuySomething.class}, // 目标接口
                        new DynamicProxy(subject) // InvocationHandler (这个类是关键)
                );


        DoSomethingSubject subject1 = new DoSomethingSubject();

        DoSomething doSomething =
                (DoSomething) Proxy.newProxyInstance(
                        DoSomething.class.getClassLoader(), // ClassLoader
                        new Class<?>[]{DoSomething.class}, // 目标接口
                        new DynamicProxy(subject1) // InvocationHandler (这个类是关键)
                );
//        DoSomething doSomething = (DoSomething) proxy.newProxyInstance(DoSomething.class, subject1);
        textView.setText(Buyer1_DynamicProxy.buyMac() + doSomething.doSonmeThing());

        staticProxy();
    }

    private void staticProxy() {
        Procurement procurement = new Procurement(new Man());
        textView.setText(procurement.buySomething());

    }

}
