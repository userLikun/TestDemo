package com.ane.testdemo.Proxy.proxy_staic;

public class Procurement implements Ibusiness {
    private Man man;

    public Procurement(Man man) {
        this.man = man;
    }

    @Override
    public String buySomething() {

        return "Procurement buy " + man.buySomething();
    }
}
