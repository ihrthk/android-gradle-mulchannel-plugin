package me.zhangls.mulchannel.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by BSDC-ZLS on 2015/3/11.
 */
public class Main {


    public static void main(String[] args) {
        //1.implement InvocationHandler interface
        TimingInvocationHandler timingInvocationHandler = new TimingInvocationHandler(new OperateImpl());
        Operate operate = (Operate) (Proxy.newProxyInstance(Operate.class.getClassLoader(),
                new Class[]{Operate.class},
                timingInvocationHandler));

        // call method of proxy instance
        operate.operateMethod1();
        System.out.println();
        operate.operateMethod2();
        System.out.println();
        operate.operateMethod3();
    }
}
