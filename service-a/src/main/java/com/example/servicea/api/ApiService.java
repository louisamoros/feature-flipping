package com.example.servicea.api;

import org.ff4j.aop.ContextLocation;
import org.ff4j.aop.Flip;
import org.ff4j.core.FlippingExecutionContext;

interface ApiService {

    @Flip(name = "new-api", alterBean = "new-api-service")
    String whichApi();

    @Flip(
            name = "new-api-market",
            alterBean = "new-api-service",
            contextLocation = ContextLocation.PARAMETER
    )
    String whichApiOnMarket(FlippingExecutionContext context);

    @Flip(name = "new-api-release-date", alterBean = "new-api-service")
    String whichApiOnReleaseDate();

}
