package com.afrid.accounts.bankaccounts.controller;

import com.afrid.accounts.bankaccounts.config.BankAccountsConfig;
import com.afrid.accounts.bankaccounts.model.BankAccount;
import com.afrid.accounts.bankaccounts.model.Customer;
import com.afrid.accounts.bankaccounts.model.Properties;
import com.afrid.accounts.bankaccounts.repository.BankAccountRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BankAccountController {

    @Autowired
    BankAccountRepo accountRepo;

    @Autowired
    BankAccountsConfig accountsConfig;

    @PostMapping("/user")
    public BankAccount createUser(@RequestBody Customer customer) {
        BankAccount customerAccountInfo = accountRepo.findByCustomerId(customer.getCustomerId());

        if (customerAccountInfo != null) {
            return customerAccountInfo;
        } else {
            return null;
        }
    }

    @GetMapping("/application/properties")
    public String getProperties() {
        String propertiesString = "";
        try {
            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

            Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
                    accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());

            propertiesString = objectWriter.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return propertiesString;
    }
}
