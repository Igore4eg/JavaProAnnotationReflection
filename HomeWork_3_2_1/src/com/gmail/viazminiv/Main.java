package com.gmail.viazminiv;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClass{
    @Test(a = 5, b = 6)
    public int plus(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException{
            MyClass mc = new MyClass();
            Class<?> myClass = mc.getClass();
            Method[] methods = myClass.getMethods();
            for (Method method : methods){
                if (method.isAnnotationPresent(Test.class)) {
                Annotation annotation = myClass.getAnnotation(Test.class);
                Test myAnnotation = method.getAnnotation(Test.class);
                System.out.println(method.invoke(mc, myAnnotation.a(), myAnnotation.b()));
            }
        }

    }

}

