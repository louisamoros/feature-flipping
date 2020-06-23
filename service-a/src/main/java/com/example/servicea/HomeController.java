package com.example.servicea;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{brand}/{country}")
public class HomeController {

    private final ApiService apiService;

    public HomeController(@Qualifier("legacy-service-api") ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/hey")
    public Payload hey(@PathVariable("brand") String brand,
                       @PathVariable("country") String country) {
        return new Payload(
                apiService.whichApi(),
                brand,
                country
        );
    }

    @GetMapping("/hey/release-date")
    public Payload heyOnReleaseDate(@PathVariable("brand") String brand,
                                    @PathVariable("country") String country) {
        return new Payload(
                apiService.whichApiOnReleaseDate(),
                brand,
                country
        );
    }

}

