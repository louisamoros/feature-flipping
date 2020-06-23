package com.example.servicea;

import org.springframework.stereotype.Component;

@Component("legacy-service-api")
class LegacyApiApiService implements ApiService {
    @Override
    public String whichApi() {
        return "LEGACY_API";
    }
    @Override
    public String whichApiOnReleaseDate() {
        return whichApi();
    }
}
