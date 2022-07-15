package com.minu.blog.config;

import com.minu.blog.util.log.FieldLogTrace;
import com.minu.blog.util.log.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig{

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }

}
