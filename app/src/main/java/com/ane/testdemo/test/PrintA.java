package com.ane.testdemo.test;

import com.ane.testdemo.base.utils.TLog;

public class PrintA {
    public PrintA() {
        print1();
        print2();
    }

    private void print2() {
        TLog.log(" PrintA print2");
    }

    private void print1() {
        TLog.log(" PrintA print1");
    }
}
