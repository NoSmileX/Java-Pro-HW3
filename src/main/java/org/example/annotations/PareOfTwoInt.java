package org.example.annotations;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PareOfTwoInt {
    int param1();

    int param2();

}

