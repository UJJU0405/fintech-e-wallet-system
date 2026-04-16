package com.fintech.ewallet.event;

public class TransactionEvent {

    private String sender;
    private String receiver;
    private Double amount;

    public TransactionEvent(String sender, String receiver, Double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Double getAmount() {
        return amount;
    }
}
