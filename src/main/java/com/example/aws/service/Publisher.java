package com.example.aws.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;
    @Scheduled(fixedRate = 10000)
    public void scheduleFixedRateTask() {
    	System.err.println("Producer SQS");
        //queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload("Niraj").build());
        queueMessagingTemplate.convertAndSend(endpoint, "Olá mundo");
    }
}