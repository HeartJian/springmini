package ioc;

import core.ioc.context.ApplicationContext;
import core.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApplicationContextTest {
    @Test
    public void test(){
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
            Hello hello= (Hello) applicationContext.getBean("world");
            hello.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
