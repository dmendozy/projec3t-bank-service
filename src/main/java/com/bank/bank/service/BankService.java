package com.bank.bank.service;

import com.bank.bank.model.Bank;
import com.bank.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public Flux<Bank> getAll(){
        return bankRepository.findAll();
    }

    public Mono<Bank> getById(String id){return bankRepository.findById(id);}

    public Mono update(String id, Bank bank){
        return bankRepository.save(bank);
    }

    public Mono save(Bank bank){
        return bankRepository.save(bank);
    }

    public Mono delete(String id){
        return bankRepository.deleteById(id);
    }

    public Flux<Bank> getByCustomerId(String customerId){return bankRepository.findByCustomerId(customerId);}

}
