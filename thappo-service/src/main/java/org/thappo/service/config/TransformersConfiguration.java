package org.thappo.service.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thappo.service.mapper.CustomPagingRequestMapper;

@Configuration("serviceTransformersConfiguration")
public class TransformersConfiguration {

    @Bean(name = "serviceMapper")
    public MapperFacade mapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.registerMapper(new CustomPagingRequestMapper());
        return mapperFactory.getMapperFacade();
    }



}
