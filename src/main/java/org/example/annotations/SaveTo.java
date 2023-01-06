package org.example.annotations;

import java.lang.annotation.*;


@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path();
}
