package org.thappo.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "config/default-values.properties")
public class ServicesConfiguration {

}
