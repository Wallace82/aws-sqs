package com.example.aws.service;


import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
	 @SqsListener(value = "spring-boot-poc",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(String message) {
        System.out.println("Message from SQS {}"+ message);
    }
}