package core.ioc.context;

import core.ioc.beans.factory.AbstractBeanFactory;

public class AbstractApplicationContext implements ApplicationContext{
    protected AbstractBeanFactory beanFactory;

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh()throws Exception{

    }
}
