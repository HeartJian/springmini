package core.ioc.aop;

public interface PointCut {
    ClassFilter classFilter();
    MethodMatcher getMethodMatcher();
}
