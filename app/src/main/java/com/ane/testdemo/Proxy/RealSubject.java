package com.ane.testdemo.Proxy;

public class RealSubject implements BuySomething{

    @Override
    public String buyMac() {
        return "buyMac";
    }
}
