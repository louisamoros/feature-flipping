package com.example.servicea.api;

import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Component;

@Component("new-api-service")
public class NewApiService implements ApiService {

    private final CloudNewApiService cloudNewApiService;

    public NewApiService(CloudNewApiService cloudNewApiService) {
        this.cloudNewApiService = cloudNewApiService;
    }

    @Override
    public String whichApi() {
        return cloudNewApiService.whichCloud();
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
