package com.ane.testdemo.test;

import com.ane.testdemo.base.utils.TLog;

public class PrintB extends PrintA{
    public PrintB() {
        print1();
        print2();
    }

    private void print2() {
        TLog.log(" PrintB print2");
    }

    private void print1() {
        TLog.log(" PrintB print1");
    }
}
