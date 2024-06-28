package com.projarc.api_cache.domain.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.projarc.api_cache.interfaceAdapter.SubscriptionProxy;

@Component
public class SubscriptionStatusCacheService {
    private final SubscriptionProxy subscriptionProxy;
    private final HashMap<Long, Boolean> subscriptionStatusCache = new HashMap<>();

    public SubscriptionStatusCacheService(SubscriptionProxy subscriptionProxy) {
        this.subscriptionProxy = subscriptionProxy;
    }

    public Boolean getSubscriptionStatus(long subscriptionId) {
        Boolean status = subscriptionStatusCache.get(subscriptionId);
        if (status == null) {
            status = subscriptionProxy.getSubscriptionStatus(subscriptionId);
            subscriptionStatusCache.put(subscriptionId, status);
        }
        return status;
    }

    public void updateSubscriptionStatus(long subscriptionId, Boolean status) {
        subscriptionStatusCache.put(subscriptionId, status);
    }

}
