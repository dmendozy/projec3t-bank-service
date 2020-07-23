package com.bank.bank.repository;

import com.bank.bank.model.Bank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends ReactiveMongoRepository<Bank, String> {
}
