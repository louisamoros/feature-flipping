package com.example.servicea.api.cloud;

import com.example.servicea.api.CloudNewApiService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!alibaba")
class AwsNewApiService implements CloudNewApiService {

    public static final String CLOUD_NEW_API = "AWS_NEW_API";

    @Override
    public String whichCloud() {
        return CLOUD_NEW_API;
    }
}
