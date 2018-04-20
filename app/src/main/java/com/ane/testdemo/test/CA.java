package com.ane.testdemo.test;

import com.ane.testdemo.base.utils.TLog;

public class CA {

    static {TLog.log("staticCA");}

    {TLog.log("ClassCA");}
    public CA(){
        TLog.log("CA");
    }

}
