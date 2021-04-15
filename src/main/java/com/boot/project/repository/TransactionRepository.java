package com.boot.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
