package com.minu.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig{

    @Bean
    public Docket api(){
        return new Docket( DocumentationType.OAS_30 )
                .useDefaultResponseMessages( false )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.minu.blog.controller" ) )
                .paths( PathSelectors.any() )
                .build()
                .apiInfo( swaggerInfo() );
    }

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder()
                .title( "blog API" )
                .description( "blog API Docs" )
                .build();
    }

}
