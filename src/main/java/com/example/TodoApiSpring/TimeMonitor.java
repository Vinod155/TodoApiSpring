package com.example.TodoApiSpring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //applicable on methods
@Retention(RetentionPolicy.RUNTIME)

public @interface TimeMonitor {
}
