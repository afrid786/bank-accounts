package com.afrid.accounts.bankaccounts.repository;

import com.afrid.accounts.bankaccounts.model.Account;
import com.afrid.accounts.bankaccounts.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account,Long> {

    public Account findByCustomerId (long customerId);

}
