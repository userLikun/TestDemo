package com.ane.testdemo.test;

import com.ane.testdemo.base.utils.TLog;

public class CB extends CA{

    static {TLog.log("staticCB");}

    {TLog.log("ClassCB");}
    public CB(){
        TLog.log("CB");
    }

}
