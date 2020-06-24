package com.example.adminconsole.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("redis")
@EnableConfigurationProperties(RedisConfiguration.class)
public class RedisConfiguration {
    public int port;
    public String url;
}
