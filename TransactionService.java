package com.fintech.ewallet.service;

import com.fintech.ewallet.model.*;
import com.fintech.ewallet.repository.*;
import com.fintech.ewallet.event.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final UserRepository userRepo;
    private final WalletRepository walletRepo;
    private final TransactionRepository txnRepo;
    private final KafkaProducer kafkaProducer;

    public TransactionService(UserRepository userRepo,
                              WalletRepository walletRepo,
                              TransactionRepository txnRepo,
                              KafkaProducer kafkaProducer) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
        this.txnRepo = txnRepo;
        this.kafkaProducer = kafkaProducer;
    }

    @Transactional
    public String transfer(String senderUpi, String receiverUpi,
                           Double amount, String requestId) {

        // Idempotency Check
        if (txnRepo.findByIdempotencyKey(requestId).isPresent()) {
            return "Duplicate Transaction!";
        }

        User sender = userRepo.findByUpiId(senderUpi).orElseThrow();
        User receiver = userRepo.findByUpiId(receiverUpi).orElseThrow();

        Wallet senderWallet = walletRepo.findById(sender.getId()).orElseThrow();
        Wallet receiverWallet = walletRepo.findById(receiver.getId()).orElseThrow();

        if (senderWallet.getBalance() < amount) {
            return "Insufficient Balance";
        }

        // Transfer
        senderWallet.setBalance(senderWallet.getBalance() - amount);
        receiverWallet.setBalance(receiverWallet.getBalance() + amount);

        walletRepo.save(senderWallet);
        walletRepo.save(receiverWallet);

        // Save Transaction
        Transaction txn = new Transaction();
        txn.setSenderUpi(senderUpi);
        txn.setReceiverUpi(receiverUpi);
        txn.setAmount(amount);
        txn.setStatus("SUCCESS");
        txn.setIdempotencyKey(requestId);
        txn.setCreatedAt(LocalDateTime.now());

        txnRepo.save(txn);

        // 🔥 Kafka Event
        kafkaProducer.publishTransaction(
                new TransactionEvent(senderUpi, receiverUpi, amount)
        );

        return "Transaction Successful";
    }
}
