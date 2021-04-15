package com.boot.project.service;



import java.util.List;

import com.boot.project.model.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}
