package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public   class TestClass {
    private static Object obj;
    private static int countBeforeSuite = 0;
    private static int countAfterSuite = 0;

    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getMethods();
        Method[] annotationMethod = new Method[methods.length];
        try {
             obj = testClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                    countBeforeSuite++;
                if (countBeforeSuite > 1){
                    throw new RuntimeException();
                }
                method.invoke(obj);
            }
        }

        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                annotationMethod[method.getAnnotation(Test.class).priority()] = method;
            }
        }

        for (int i = annotationMethod.length - 1; i >= 0 ; i--) {
            if (annotationMethod[i] != null && annotationMethod[i].getAnnotation(Test.class) != null ){
                annotationMethod[i].invoke(obj);
            }
        }

        for (Method method : methods) {
            if (method.getAnnotation(AfterSuite.class) != null) {
                countBeforeSuite++;
                if (countBeforeSuite > 1){
                    throw new RuntimeException();
                }
                method.invoke(obj);
            }
        }
    }
}