package com.example.servicea.config;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MarketFlippingStrategy extends AbstractFlipStrategy {

    /**
     * initial parameter.
     */
    private static final String INIT_PARAM_NAME_MARKETS = "grantedMarkets";

    /**
     * current user attribute
     */
    public static final String PARAM_NAME_USER_MARKET = "market";

    /**
     * Initial Granted Markets.
     */
    private final Set<String> setOfGrantedMarkets = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(String featureName, Map<String, String> initValue) {
        super.init(featureName, initValue);
        assertRequiredParameter(INIT_PARAM_NAME_MARKETS);
        String[] arrayOfMarkets = initValue.get(INIT_PARAM_NAME_MARKETS).split(",");
        setOfGrantedMarkets.addAll(Arrays.asList(arrayOfMarkets));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(String fName, FeatureStore fStore, FlippingExecutionContext ctx) {
        // true means required here
        String userMarket = ctx.getString(PARAM_NAME_USER_MARKET, true);
        return setOfGrantedMarkets.contains(userMarket);
    }
}