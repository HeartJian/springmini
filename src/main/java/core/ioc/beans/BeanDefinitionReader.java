package core.ioc.beans;
/**
 * description:从配置中读取BeanDefinitionReader
  * @Param: null
 * @return
 */
public interface BeanDefinitionReader {


    void loadBeanDefinitions(String location) throws Exception;
}
