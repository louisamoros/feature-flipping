package com.example.servicea.config;

import org.ff4j.aop.Flip;

interface ApiService {
    @Flip(name = "legacy-api", alterBean = "legacy-api")
    String whichApi();
}
