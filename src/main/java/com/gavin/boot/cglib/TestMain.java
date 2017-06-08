package com.gavin.boot.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gavin on 17-6-9.
 * motan实现原理: http://www.07net01.com/2017/02/1810643.html
 * 动态实现接口: http://www.cnblogs.com/lemap/archive/2012/10/25/2738523.html
 * 实战CGLib系列之proxy：方法拦截MethodInterceptor
 * http://5181028.blog.51cto.com/5171028/1231229
 * Spring AOP两种实现方式: http://www.cnblogs.com/xx0405/p/5497672.html
 * Spring提供了4种实现AOP的方式： http://hyhai7.iteye.com/blog/837497
 */
public class TestMain {
    private static Method method;

    static {
        for (Method m : TestMain.class.getDeclaredMethods()) {
            if (m.getName().equals("testSomething")) {
                method = m;
                break;
            }
        }
    }

    public static Object testSomething(String method, String clazz) {
        System.out.println("这个是一个简单实现, 调用" + clazz + "." + method);
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        TestProxy testProxy = new TestProxy();
        //Class<TestInterface> c = Class.forName("com.gavin.boot.cglib.TestInterface");
        Class c = TestMain.class.getClassLoader().loadClass("com.gavin.boot.cglib.TestInterface");
        Object t = testProxy.getProxy(c);

        for (Method m : t.getClass().getDeclaredMethods()) {
            System.out.println("method: " + m.getName());
            System.out.println(method.invoke(t, new Object[]{m.getName(), c.getName()}));
        }

        System.out.println("---------------------------");

        for (Method m : c.getDeclaredMethods()) {
            System.out.println("method: " + m.getName());
            System.out.println(method.invoke(t, new Object[]{m.getName(), c.getName()}));
        }


    }
}
