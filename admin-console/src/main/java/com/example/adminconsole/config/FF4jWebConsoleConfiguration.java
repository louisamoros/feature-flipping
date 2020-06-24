package com.example.adminconsole.config;

import org.ff4j.FF4j;
import org.ff4j.spring.boot.web.api.config.EnableFF4jSwagger;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Enable the REST API documentation
@EnableFF4jSwagger
// The class should be on classpath : FF4jDispatcherServlet
@ConditionalOnClass({FF4jDispatcherServlet.class})
// Setup FF4j first, not is required
@AutoConfigureAfter(FF4JConfiguration.class)
public class FF4jWebConsoleConfiguration extends SpringBootServletInitializer implements WebMvcConfigurer {
    /**
     * Definition of the servlet for web console
     */
    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet defineFF4jServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }

    /**
     * Mapping from FF4j to the endpoint you want
     */
    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ServletRegistrationBean registerFF4jServlet(FF4jDispatcherServlet ff4jDispatcherServlet) {
        return new ServletRegistrationBean(ff4jDispatcherServlet, "/console/*");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
