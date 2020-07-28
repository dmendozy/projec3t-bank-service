package com.bank.bank.adds;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
public class Account {
    public String accountId;
    public String bankId;
    public String numberAccount;
    public String typeAccount;
    public double currentBalance;
    public int transactionsAmount;
    public List<String> customerId;
    public List<String> signatories;
    @Transient
    public List<String> transactions;
}
