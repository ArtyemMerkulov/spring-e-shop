package com.geekbrains;

import com.geekbrains.config.security.SecurityConfig;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableVaadin
@Import(SecurityConfig.class)
@EnableAutoConfiguration
@ComponentScan("com.geekbrains")
@EnableJpaRepositories("com.geekbrains.backend.repository")
public class ApplicationConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean
    public ModelMapper modelMapper(List<PropertyMap> propertyMapList) {
        ModelMapper modelMapper = new ModelMapper();
        propertyMapList.stream()
                       .map(modelMapper::addMappings);
        return modelMapper;
    }

}
