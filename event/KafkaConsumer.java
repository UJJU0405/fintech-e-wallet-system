package com.fintech.ewallet.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "transaction-topic", groupId = "ewallet-group")
    public void listen(TransactionEvent event) {
        System.out.println("📢 Transaction Event: " +
                event.getSender() + " sent ₹" + event.getAmount());
    }
}
