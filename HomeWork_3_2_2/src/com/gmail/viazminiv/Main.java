package com.gmail.viazminiv;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException{
            Container mc = new Container();
            Class<?> myClass = mc.getClass();

            SaveTo annotation = myClass.getAnnotation(SaveTo.class);
            System.out.println(annotation);
            String path = annotation.path();

            Method[] methods = myClass.getMethods();
            for (Method method : methods){
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(mc, path);
                }

        }

    }
    }

