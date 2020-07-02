package com.example.servicea.api;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("legacy-api-service")
public class LegacyApiService implements ApiService {

    private final CloudLegacyApiService cloudLegacyApiService;

    public LegacyApiService(CloudLegacyApiService cloudLegacyApiService) {
        this.cloudLegacyApiService = cloudLegacyApiService;
    }

    @Override
    public String whichApi() {
        return cloudLegacyApiService.whichCloud();
    }

    @Override
    public String whichApiOnMarket(FlippingExecutionContext context) {
        return whichApi();
    }

    @Override
    public String whichApiOnReleaseDate() {
        return whichApi();
    }
}
