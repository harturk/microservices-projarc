package com.projarc.api_cache.interfaceAdapter.rabbitmq;

import com.projarc.api_cache.domain.model.SubscriptionStatusUpdate;
import com.projarc.api_cache.domain.service.SubscriptionStatusCacheService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

import io.micrometer.common.lang.NonNull;

@Component
public class SubscriptionCacheConsumer {
    private final SubscriptionStatusCacheService subscriptionStatusDataAccess;

    public SubscriptionCacheConsumer(SubscriptionStatusCacheService subscriptionStatusDataAccess) {
        this.subscriptionStatusDataAccess = subscriptionStatusDataAccess;
    }

    @RabbitListener(queues = "#{rabbitConfig.getQueueName()}")
    public void listenToStatusUpdates(@Payload @NonNull SubscriptionStatusUpdate subscriptionStatusUpdate) {
        subscriptionStatusDataAccess.updateSubscriptionStatus(subscriptionStatusUpdate.subscriptionId(),
                subscriptionStatusUpdate.status());
    }

}
