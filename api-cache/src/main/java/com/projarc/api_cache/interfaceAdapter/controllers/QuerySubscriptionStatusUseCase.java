package com.projarc.api_cache.interfaceAdapter.controllers;

import org.springframework.stereotype.Component;

import com.projarc.api_cache.domain.service.SubscriptionStatusCacheService;

@Component
public class QuerySubscriptionStatusUseCase {
    private final SubscriptionStatusCacheService subscriptionStatusDataAccess;

    public QuerySubscriptionStatusUseCase(SubscriptionStatusCacheService subscriptionStatusDataAccess) {
        this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
    }

    public boolean getSubscriptionStatus(long subscriptionId) {
        return subscriptionStatusDataAccess.getSubscriptionStatus(subscriptionId);
    }

}
