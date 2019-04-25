package com.example.bellIntegrator.other.mapper;

import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {

    @Override
    public MapperFactory getObject() {
        return new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
