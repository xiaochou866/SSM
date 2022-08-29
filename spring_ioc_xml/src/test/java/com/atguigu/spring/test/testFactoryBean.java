package com.atguigu.spring.test;
/*
* FactoryBean 是一个接口，需要创建一个类实现该接口
* 其中有三个方法:
* getObject() 通过一个对象交给IOC容器管理
* getObjectType() 设置所提供对象的类型
* isSingleton() 设置所提供的对象是否单例
* 当我们把factoryBean的实现类配置为bean时，会将当前类中getObject()方法所返回的对象交给IOC容器进行管理
* */
import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testFactoryBean {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
