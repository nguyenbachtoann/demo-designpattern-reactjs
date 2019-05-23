package com.example.demo.Configurations;


import com.example.demo.entities.ProductEntity;
import com.example.demo.models.ProductModel;
import com.example.demo.models.ProductModel;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MappingConfig {
    @Bean(name = "org.dozer.Mapper")
    public BeanMappingBuilder beanMappingBuilder(){
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(ProductEntity.class, ProductModel.class);

            }
        };
    }

    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }
}
