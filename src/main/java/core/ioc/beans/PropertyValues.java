package core.ioc.beans;

import java.util.ArrayList;
import java.util.List;
/**
 * description:属性list
  * @Param: null
 * @return 
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();
    
    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }
}
