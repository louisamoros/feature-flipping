package com.example.servicea.config;

import org.springframework.stereotype.Component;

@Component("new-api")
class NewApiApiService implements ApiService {
    @Override
    public String whichApi() {
        return "NEW_API";
    }
}
