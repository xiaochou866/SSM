package com.atguigu.spring.proxy;

import org.junit.Test;

public class ProxyTest {
    /*
    * 动态代理有两种:
    * 1.jdk动态代理 要求必须有接口,最终生成的代理类在com.sun.proxy包下,类名为$proxy2
    * 2.cglib动态代理 没有什么要求，最终生成的代理类会继承目标类，并且和目标类在相同的包下
    * */
    @Test
    public void test(){
        //CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        //proxy.add(1, 2);

        //下面通过动态代理的工厂类来创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1,0);
    }
}
