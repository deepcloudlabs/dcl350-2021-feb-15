package com.example.lottery.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "com.example.service.MarketApi.class")
public class AppConfig {

}
