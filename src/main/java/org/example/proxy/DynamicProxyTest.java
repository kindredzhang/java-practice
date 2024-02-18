package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 目标接口
interface Subject {
    void request();
}

// 目标类
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

// InvocationHandler 实现
class MyInvocationHandler implements InvocationHandler {
    private final Object realSubject;

    public MyInvocationHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic Proxy: Before handling request.");
        Object result = method.invoke(realSubject, args);
        System.out.println("Dynamic Proxy: After handling request.");
        return result;
    }
}

// 测试类
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 创建目标对象
        RealSubject realSubject = new RealSubject();

        // 创建 InvocationHandler
        InvocationHandler handler = new MyInvocationHandler(realSubject);

        // 创建动态代理
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                handler
        );

        // 调用代理对象的方法
        proxySubject.request();
    }
}
