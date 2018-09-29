package core.ioc.beans.factory;

import core.ioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
    private final List<String> beanDefinitionNames = new ArrayList<String>();


    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition==null){
            throw new IllegalArgumentException("dont have："+name+" bean");
        }
        Object bean = beanDefinition.getBean();
        if(bean==null){
            try {
                bean=doCreateBean(beanDefinition);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    public void preInstantiateSingletons(){
        this.beanDefinitionNames.forEach(a->{
            getBean(a);
        });
    }

    /**
     * description:注册bean
     *
     * @return
     * @Param: null
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * description:初始化bean
     *
     * @return
     * @Param: null
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException;
}
