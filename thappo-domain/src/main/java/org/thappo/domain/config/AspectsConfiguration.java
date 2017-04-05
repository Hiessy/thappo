package org.thappo.domain.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.thappo.domain.aspect.ValidationAspect;



@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectsConfiguration {

    @Bean
    @Description("Used to validate request's input")
    public Validator validator() {
        ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        return validationFactory.getValidator();
    }

    @Bean
    @Description("Method validation aspect")
    public ValidationAspect validationAspect() {
        return new ValidationAspect(this.validator());
    }

}
