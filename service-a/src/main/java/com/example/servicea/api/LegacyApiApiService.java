package com.example.servicea.api;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("legacy-service-api")
class LegacyApiApiService implements ApiService {

    public static final String LEGACY_API = "LEGACY_API";

    @Override
    public String whichApi() {
        return LEGACY_API;
    }

    @Override
    public String whichApiOnMarket(FlippingExecutionContext context) {
        return LEGACY_API;
    }

    @Override
    public String whichApiOnReleaseDate() {
        return LEGACY_API;
    }
}
