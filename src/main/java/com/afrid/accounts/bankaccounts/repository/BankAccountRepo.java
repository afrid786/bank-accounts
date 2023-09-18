package com.afrid.accounts.bankaccounts.repository;

import com.afrid.accounts.bankaccounts.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends CrudRepository<BankAccount,Long> {

    public BankAccount findByCustomerId (long customerId);

}
