package com.example.servicea.config;

import org.ff4j.FF4j;
import org.ff4j.redis.RedisConnection;
import org.ff4j.store.EventRepositoryRedis;
import org.ff4j.store.FeatureStoreRedis;
import org.ff4j.store.PropertyStoreRedis;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class FF4JConfiguration {

    private final RedisProperties redisProperties;

    public FF4JConfiguration(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public FF4j getFF4j() {
        FF4j ff4j = new FF4j();

        RedisConnection redisConnection = new RedisConnection(
                redisProperties.getHost(),
                redisProperties.getPort(),
                redisProperties.getPassword(),
                redisProperties.isSsl()
        );
        /*
         * Implementation of each store. Here this is boiler plate as if nothing
         * is specified the inmemory is used. Those are really the one that will
         * change depending on your technology.
         */
        ff4j.setFeatureStore(new FeatureStoreRedis(redisConnection));
        ff4j.setPropertiesStore(new PropertyStoreRedis(redisConnection));
        ff4j.setEventRepository(new EventRepositoryRedis(redisConnection));

        // Enabling audit and monitoring, default value is false
        ff4j.audit(true);

        // When evaluting not existing features, ff4j will create then but disabled
        ff4j.autoCreate(true);


        return ff4j;
    }

}
