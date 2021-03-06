package core.ioc.aop;

public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource() {
    }

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public TargetSource(Object target) {
        this(target.getClass(),target);
    }


    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
