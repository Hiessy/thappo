package org.thappo.commons.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.groups.Default;


@Target({FIELD, PARAMETER, LOCAL_VARIABLE})
@Retention(RUNTIME)
public @interface Valid {
    Class<?>[] groups() default {Default.class};
}
