package com.afrid.accounts.bankaccounts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Account {

    @Column(name = "customer_id")
    private long customerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "created_date")
    private LocalDate createdAt;
}
