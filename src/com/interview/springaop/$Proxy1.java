package com.interview.springaop;
import java.lang.reflect.Method;
public class $Proxy1 implements com.interview.springaop.UserMgr{
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    com.interview.springaop.InvocationHandler h;
    @Override
    public  void addUser() {
        try {
        Method md = com.interview.springaop.UserMgr.class.getMethod("addUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }
    @Override
    public  void delUser() {
        try {
        Method md = com.interview.springaop.UserMgr.class.getMethod("delUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }

}