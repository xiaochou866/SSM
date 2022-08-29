package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTestByXml {

    /**
     * 自动装配:
     * 根据指定的人策略，在IOC容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值
     * 可以通过bean标签中的autowire属性设置自动装配的策略
     * no, default: 表示不进行装配 即 bean中的属性不会自动去匹配某个bean为属性进行赋值，此时属性使用默认值
     * byType: 根据要赋值的属性的类型，在IOC容器中匹配某个bean,为属性进行赋值
     * 经常使用的两种是byType 和 byName
     * 注意:
     * a>若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性使用的是默认值
     * b>若通过类型找到了多个类型匹配的Bean, 此时会抛出异常: NoUniqueBeanDefinitionException
     * 总结: 当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性进行赋值
     * 3. byName: 将要赋值的属性名作为bean的id在IOC容器中匹配某个bean,为属性赋值
     * 总结: 当类型匹配的bean有多个时，此时可以使用byName实现自动装配
     */
    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
