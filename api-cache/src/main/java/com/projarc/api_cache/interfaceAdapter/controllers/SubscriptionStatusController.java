package com.projarc.api_cache.interfaceAdapter.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SubscriptionStatusController {
    private final QuerySubscriptionStatusUseCase querySubscriptionStatusUseCase;

    public SubscriptionStatusController(QuerySubscriptionStatusUseCase querySubscriptionStatusUseCase) {
        this.querySubscriptionStatusUseCase = querySubscriptionStatusUseCase;
    }

    @GetMapping("/assinvalida/{subscriptionId}")
    public boolean getSubscriptionStatus(@PathVariable long subscriptionId) {
        return this.querySubscriptionStatusUseCase.getSubscriptionStatus(subscriptionId);
    }

}
