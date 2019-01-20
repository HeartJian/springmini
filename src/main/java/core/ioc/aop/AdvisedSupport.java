package core.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

//pointcut  包含了MethodInterceptor:即advice（具体执行逻辑，before after around）,Joinpoint切点
public class AdvisedSupport {
    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    public AdvisedSupport(TargetSource targetSource, MethodInterceptor methodInterceptor) {
        this.targetSource = targetSource;
        this.methodInterceptor = methodInterceptor;
    }

    public AdvisedSupport() {
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
