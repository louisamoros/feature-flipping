package com.example.servicea.api.cloud;

import com.example.servicea.api.CloudLegacyApiService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!alibaba")
class AwsLegacyApiService implements CloudLegacyApiService {

    public static final String CLOUD_LEGACY_API = "AWS_LEGACY_API";

    @Override
    public String whichCloud() {
        return CLOUD_LEGACY_API;
    }
}
