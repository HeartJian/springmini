package core.ioc.beans.factory;

import core.ioc.beans.BeanDefinition;
import core.ioc.beans.BeanReference;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    protected Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {
        beanDefinition.getPropertyValues().getPropertyValueList().forEach(a -> {
            try {
                Field field = bean.getClass().getDeclaredField(a.getName());
                field.setAccessible(true);
                if(a.getValue() instanceof BeanReference){
                    String name = ((BeanReference) a.getValue()).getName();
                    field.set(bean,getBean(name));
                }
                else{field.set(bean, a.getValue());}
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }
}
