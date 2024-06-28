package com.projarc.api_cache.interfaceAdapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "app-sign-control")
public interface SubscriptionProxy {
    @GetMapping("/servcad/assinaturas/assinvalida/{subscriptionId}")
    Boolean getSubscriptionStatus(@PathVariable long subscriptionId);
}
