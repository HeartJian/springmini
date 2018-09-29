package ioc;

import core.ioc.beans.factory.AutowireCapableBeanFactory;
import core.ioc.beans.factory.BeanFactory;
import core.ioc.beans.io.ResourceLoader;
import core.ioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

public class BeanFactoryTest {
    //单例模式测试
    @Test
    public void test() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
        AutowireCapableBeanFactory factory=new AutowireCapableBeanFactory();
        xmlBeanDefinitionReader.getRegistry().forEach(
                (a,b)->{
                    try {
                        (factory).registerBeanDefinition(a,b);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
        );

        factory.preInstantiateSingletons();
        Hello hello = (Hello) factory.getBean("world");
        hello.sayHello();
    }
}
