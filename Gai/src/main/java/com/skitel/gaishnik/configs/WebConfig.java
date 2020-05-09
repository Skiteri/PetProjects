package com.skitel.gaishnik.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.skitel.gaishnik")
public class WebConfig{
//
//    @Bean
//    @Scope(value = "prototype")
//    Number getNumber() {
//        return new Number();
//    }

}
