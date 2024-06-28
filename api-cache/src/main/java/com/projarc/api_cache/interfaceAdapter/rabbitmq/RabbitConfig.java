package com.projarc.api_cache.interfaceAdapter.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Declarables;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Configuration
public class RabbitConfig {

    private final String QUEUENAME = "subscription-cache-queue-" + UUID.randomUUID();
    private final String FANOUTEXCHANGENAME = "subscription-cache-fannout-" + UUID.randomUUID();

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTEXCHANGENAME);
    }

    @Bean
    public Declarables fanoutBindings() {
        Queue uniqueQueue = new Queue(this.QUEUENAME);
        FanoutExchange fanoutExchange = new FanoutExchange("subscription-status-update-fanout");

        return new Declarables(
                uniqueQueue,
                fanoutExchange,
                BindingBuilder.bind(uniqueQueue).to(fanoutExchange));
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    public String getQueueName() {
        return this.QUEUENAME;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter messageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
