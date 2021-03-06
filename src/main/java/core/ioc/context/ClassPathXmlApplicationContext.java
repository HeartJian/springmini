package core.ioc.context;

import core.ioc.beans.factory.AbstractBeanFactory;
import core.ioc.beans.factory.AutowireCapableBeanFactory;
import core.ioc.beans.io.ResourceLoader;
import core.ioc.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) {
        super(beanFactory);
        this.configLocation = configLocation;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ClassPathXmlApplicationContext(String configLocation) {
        this(new AutowireCapableBeanFactory(),configLocation);
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        xmlBeanDefinitionReader.getRegistry().forEach((a,b)->{
            try {
                beanFactory.registerBeanDefinition(a,b);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });

    }
}
