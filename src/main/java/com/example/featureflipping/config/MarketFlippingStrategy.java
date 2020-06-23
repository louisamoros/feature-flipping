package com.example.featureflipping.config;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MarketFlippingStrategy extends AbstractFlipStrategy {

    public MarketFlippingStrategy() {
    }

    /**
     * initial parameter.
     */
    private static final String INIT_PARAM_NAME_REGIONS = "grantedRegions";

    /**
     * current user attribute
     */
    public static final String PARAM_NAME_USER_REGION = "region";

    /**
     * Initial Granted Regions.
     */
    private final Set<String> setOfGrantedRegions = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(String featureName, Map<String, String> initValue) {
        super.init(featureName, initValue);
        assertRequiredParameter(INIT_PARAM_NAME_REGIONS);
        String[] arrayOfRegions = initValue.get(INIT_PARAM_NAME_REGIONS).split(",");
        setOfGrantedRegions.addAll(Arrays.asList(arrayOfRegions));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(String fName, FeatureStore fStore, FlippingExecutionContext ctx) {
        // true means required here
        String userRegion = ctx.getString(PARAM_NAME_USER_REGION, true);
        return setOfGrantedRegions.contains(userRegion);
    }
}