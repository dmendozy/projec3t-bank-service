package com.bank.bank.controller;

import com.bank.bank.adds.Account;
import com.bank.bank.model.Bank;
import com.bank.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping
    public Flux<Bank> getAllBanks(){
        return bankService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Bank> getBankById(@PathVariable("id") String bankId){
        return bankService.getById(bankId);
    }

    @PostMapping
    public Mono<Bank> createBank(@Validated @RequestBody Bank bank){
        return bankService.save(bank);
    }

    @PutMapping("{id}")
    public Mono<Bank> updateBank(@PathVariable("id") String bankId,
                                       @Validated @RequestBody Bank bank){
        return bankService.update(bankId, bank);
    }

    @DeleteMapping("{id}")
    public Mono<Bank> deleteBank(@PathVariable("id") String bankId){
        return bankService.delete(bankId);
    }

    @GetMapping("/customer/{customerId}")
    public Flux<Bank> findByCustomer(@PathVariable("customerId") String customerId) {
        return bankService.getByCustomerId(customerId);
    }
}
