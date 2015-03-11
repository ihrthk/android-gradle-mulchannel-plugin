package me.zhangls.mulchannel.dynamic_proxy;

import me.zhangls.mulchannel.dynamic_proxy.Operate;

/**
 * Created by BSDC-ZLS on 2015/3/11.
 */
public class OperateImpl implements Operate {
    @Override
    public void operateMethod1() {
        System.out.println("Invoke operateMethod1");
        sleep(110);
    }

    @Override
    public void operateMethod2() {
        System.out.println("Invoke operateMethod2");
        sleep(120);
    }

    @Override
    public void operateMethod3() {
        System.out.println("Invoke operateMethod3");
        sleep(130);
    }

    private static void sleep(long millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
