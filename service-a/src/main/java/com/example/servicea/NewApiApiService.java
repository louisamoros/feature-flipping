package com.example.servicea;

import org.springframework.stereotype.Component;

@Component("new-service-api")
class NewApiApiService implements ApiService {
    @Override
    public String whichApi() {
        return "NEW_API";
    }
    @Override
    public String whichApiOnReleaseDate() {
        return whichApi();
    }
}
