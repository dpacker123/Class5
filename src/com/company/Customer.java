package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<BankAccount> accounts;
    private String name;
    private int customerID;

    public Customer(String customerName, int taxID){
        customerID = taxID;
        name = customerName;
        accounts = new ArrayList<BankAccount>();
    }

    public boolean openAccount(double initialBalance){
        var newAccount = new BankAccount();
        newAccount.deposit(initialBalance);
        var didSucceed = accounts.add(newAccount);
        return didSucceed;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return customerID;
    }


}

