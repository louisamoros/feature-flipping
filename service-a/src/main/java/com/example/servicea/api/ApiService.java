package com.example.servicea.api;

import com.example.flippingutil.MarketFlippingStrategy;
import org.ff4j.aop.ContextLocation;
import org.ff4j.aop.Flip;
import org.ff4j.core.FlippingExecutionContext;

interface ApiService {

    @Flip(name = "new-api", alterBean = "new-service-api")
    String whichApi();

    @Flip(
            name = "new-api-market",
            alterBean = "new-service-api",
            contextLocation = ContextLocation.PARAMETER
    )
    String whichApiOnMarket(FlippingExecutionContext context);

    @Flip(name = "new-api-release-date", alterBean = "new-service-api")
    String whichApiOnReleaseDate();

}
