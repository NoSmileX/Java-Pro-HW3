package org.example;

import org.example.annotations.*;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        Sum sm = new Sum();
        try {
            Class<?> cls = Sum.class;
            Method method = cls.getMethod("sumTwoInt", int.class, int.class);
            if (method.isAnnotationPresent(PareOfTwoInt.class)) {
                PareOfTwoInt myAnnotation = method.getAnnotation(PareOfTwoInt.class);
                method.invoke(sm, myAnnotation.param1(), myAnnotation.param2());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Задание 2

        TextContainer textContainer = new TextContainer("Some interesting text for Java PRO home work");
        SaveText.saveTxt(textContainer);

        // Задание 3
        Test test = new Test(1, true, '`', 5000L, 4.78);
        System.out.println("Before serialize: " + test);
        Serialize.save(test);
        System.out.println("After deserialize: " + Deserialize.restore(test));
        Test test1 = (Test) Deserialize.restore(test);
        System.out.println("New object with deserialization: " + test1);
    }
}