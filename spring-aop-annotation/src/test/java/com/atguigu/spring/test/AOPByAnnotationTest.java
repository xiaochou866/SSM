package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import com.atguigu.spring.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);
        //calculator.add(1,1);
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10,2);
    }
}
