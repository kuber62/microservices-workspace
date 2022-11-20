package com.uniktech.persistor.repository;

import com.uniktech.persistor.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxnRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByTxnEntity(String txnEntity);
}
