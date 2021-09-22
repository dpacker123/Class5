package com.company;

public class Main {

    public static void main(String[] args) {
	var myAccount = new BankAccount();
    myAccount.deposit(1000);
    myAccount.addInterest();
    var didSucceed = myAccount.withdraw(2000);
    if(didSucceed)
        System.out.println("Succesfully Made Withdrawl");
    else
        System.out.println("Could not withdraw, current balance is " +myAccount.checkBalance());
    }
}
