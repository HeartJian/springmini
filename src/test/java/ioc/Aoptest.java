package ioc;

import core.ioc.aop.AdvisedSupport;
import core.ioc.aop.JdkDynamicAopProxy;
import core.ioc.aop.TargetSource;
import core.ioc.context.ApplicationContext;
import core.ioc.context.ClassPathXmlApplicationContext;
import ioc.product.Fruit;
import ioc.product.Orange;
import ioc.product.Product;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Aoptest {

    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        HelloInterface hello= (HelloInterface) applicationContext.getBean("world");
        ((Hello)hello).sayHello();
        //设置代理对象joinpoint
        AdvisedSupport advisedSupport=new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new MyInterceptor());
        advisedSupport.setTargetSource(new TargetSource(hello));

        JdkDynamicAopProxy jdkDynamicAopProxy=new JdkDynamicAopProxy(advisedSupport);
        HelloInterface proxy = (HelloInterface) jdkDynamicAopProxy.getProxy();
        proxy.say();
    }
}
