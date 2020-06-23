package com.example.servicea.api;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("new-service-api")
class NewApiApiService implements ApiService {

    public static final String NEW_API = "NEW_API";

    @Override
    public String whichApi() {
        return NEW_API;
    }

    @Override
    public String whichApiOnMarket(FlippingExecutionContext context) {
        return NEW_API;
    }

    @Override
    public String whichApiOnReleaseDate() {
        return NEW_API;
    }
}
