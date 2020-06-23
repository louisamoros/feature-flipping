package com.example.servicea;

import org.ff4j.aop.Flip;

interface ApiService {

    @Flip(name = "new-api", alterBean = "new-service-api")
    String whichApi();

    @Flip(name = "new-api-release-date", alterBean = "new-service-api")
    String whichApiOnReleaseDate();

}
