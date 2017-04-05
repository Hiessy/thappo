package org.thappo.domain.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.thappo.commons.annotation.Valid;
import org.thappo.commons.annotation.ValidateGroups;
import org.thappo.commons.model.Cause;
import org.thappo.domain.exception.ValidationException;
import org.thappo.domain.feature.commons.annotation.ValidId;

@Aspect
@Order(0)
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
    private final Validator validator;

    public ValidationAspect(final Validator validator) {
        this.validator = validator;
    }

    @Pointcut("execution(* org.thappo.domain.feature..*.*(..))")
    private void selectAllFeatureMethods() {
    }

    @Pointcut("execution(* org.thappo.domain..*.*(..))")
    private void selectAllProjectMethods() {
    }

    @Pointcut("bean(*Service)")
    private void selectAllServiceBeanMethods() {
    }

    @Before("selectAllFeatureMethods() && selectAllServiceBeanMethods()")
    public synchronized void validate(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LOGGER.info("[DOMAIN] *method-interception* Validating " + method.getName() + " method parameters");

        for (int i = 0; i < method.getParameterAnnotations().length; i++) {
            Object object = joinPoint.getArgs()[i];
            Annotation[] objectAnnotations = method.getParameterAnnotations()[i];
            for (Annotation annotation : objectAnnotations) {
                if (annotation instanceof Valid) {
                    LOGGER.debug(">>> Validating argument class " + object.getClass().getSimpleName());
                    Valid valid = (Valid) annotation;
                    Class<?>[] groups;
                    if (method.isAnnotationPresent(ValidateGroups.class) && valid.groups()[0] == Default.class) {
                        ValidateGroups validateGroups = method.getAnnotation(ValidateGroups.class);
                        groups = validateGroups.value();
                    } else {
                        groups = valid.groups();
                    }
                    Set<ConstraintViolation<Object>> violations = this.validator.validate(object, groups);
                    this.handleViolations(violations);
                }
                if (annotation instanceof ValidId) {
                    ValidIdContainer annotationContainer = new ValidIdContainer(object.toString());
                    Set<ConstraintViolation<ValidIdContainer>> violations = this.validator.validate(annotationContainer);
                    this.handleViolations(violations);
                }
            }
        }
    }

    private <T> void handleViolations(Set<ConstraintViolation<T>> violations) {
        String status = "OK";
        if (!violations.isEmpty()) {
            List<Cause> causes = new ArrayList<Cause>();
            for (ConstraintViolation<T> constraintViolation : violations) {
                String value = String.valueOf(constraintViolation.getInvalidValue());
                String label = constraintViolation.getMessage();
                causes.add(new Cause(value, label));
            }
            status = "ERROR";
            LOGGER.debug(">>> Validation finished [Status: " + status + "]");
            throw new ValidationException(causes);
        }
    }

    private class ValidIdContainer {

        @ValidId
        private String id;

        public ValidIdContainer(String id) {
            this.id = id;
        }

    }
}
