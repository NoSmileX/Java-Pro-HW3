package org.example;

import org.example.annotations.SaveTo;
import org.example.annotations.Saver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaveText {
    public static void saveTxt(TextContainer txt) {
        Class<?> cls = txt.getClass();
        if (cls.isAnnotationPresent(SaveTo.class)) {
            for (Method method : cls.getMethods()) {
                if (method.isAnnotationPresent(Saver.class)) {
                    try {
                        method.invoke(txt, cls.getAnnotation(SaveTo.class).path());
                        System.out.println("Текст успешно сохранен!");
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
