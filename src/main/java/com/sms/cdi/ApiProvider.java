package com.sms.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Target({ElementType.TYPE, ElementType.FIELD, METHOD, PARAMETER, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface ApiProvider {
    enum Providers {
        AT,
        NEXMO,
        INFOBIP
    }

    Providers value();
}






