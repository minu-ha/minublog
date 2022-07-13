package com.minu.blog.config;

import com.minu.blog.util.FieldLogTrace;
import com.minu.blog.util.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig{

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }

}
