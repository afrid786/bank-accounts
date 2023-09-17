package com.afrid.accounts.bankaccounts.controller;

import com.afrid.accounts.bankaccounts.model.Account;
import com.afrid.accounts.bankaccounts.model.Customer;
import com.afrid.accounts.bankaccounts.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;

    @PostMapping("/user")
    public Account createUser (@RequestBody Customer customer) {
        Account customerAccountInfo = accountRepo.findByCustomerId(customer.getCustomerId());

        if(customerAccountInfo != null) {
            return customerAccountInfo;
        }else {
            return null;
        }
    }

    @GetMapping("/")
    public String helloTest () {
        return "hello Test";
    }
}
