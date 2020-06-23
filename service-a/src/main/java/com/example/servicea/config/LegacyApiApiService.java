package com.example.servicea.config;

import org.springframework.stereotype.Component;

@Component("legacy-api")
class LegacyApiApiService implements ApiService {
    @Override
    public String whichApi() {
        return "LEGACY_API";
    }
}
