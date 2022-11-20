package com.uniktech.persistor.service;

import com.uniktech.persistor.entity.Transaction;
import com.uniktech.persistor.repository.TxnRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersistorService {

    @Autowired
    private TxnRepository txnRepository;
    public List<Transaction> fetchAll() {
        log.info("inside fetchAll method of PersistorService");
        return txnRepository.findAll();
    }

    public Transaction saveTransaction(Transaction txn) {
        log.info("inside save method of PersistorService");
        return txnRepository.save(txn);
    }

    public List<Transaction> getAllTxnByTopic(String txnEntity) {
        log.info("inside getAllTxnByTopic method of PersistorService");
        return txnRepository.findAllByTxnEntity(txnEntity);
    }
}
