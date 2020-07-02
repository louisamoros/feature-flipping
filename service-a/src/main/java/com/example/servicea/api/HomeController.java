package com.example.servicea.api;

import com.example.flippingutil.MarketFlippingStrategy;
import org.ff4j.core.FlippingExecutionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{brand}/{country}")
public class HomeController {

    private final ApiService apiService;

    public HomeController(@Qualifier("legacy-api-service") ApiService apiService) {
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

    @GetMapping("/hey/market")
    public Payload heyOnMarket(@PathVariable("brand") String brand,
                               @PathVariable("country") String country) {
        FlippingExecutionContext executionContext = new FlippingExecutionContext();
        executionContext.putString(MarketFlippingStrategy.PARAM_NAME_USER_MARKET, brand + "-" + country);
        return new Payload(
                apiService.whichApiOnMarket(executionContext),
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

