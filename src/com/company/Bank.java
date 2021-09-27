package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    public Bank(){
        allCustomers = new ArrayList<Customer>();
        allAccounts = new ArrayList<BankAccount>();
    }

    public void doBanking(){
        var inputReader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = inputReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer(inputReader);
                    break;
                case 3:
                    System.out.println("Not yet implemented");
                    break;
            }
        }
    }

    private void addCustomer(Scanner inputReader) {
        inputReader.nextLine();//eats \n from previous call to nextInt
        System.out.print("Enter the new Customer's name: ");
        var newCustomerName = inputReader.nextLine();
        System.out.print("Enter the new Customer's Tax ID (SSN)");
        var newCustomerTaxId = inputReader.nextInt();
        var newCustomer = new Customer(newCustomerName, newCustomerTaxId);
        allCustomers.add(newCustomer);
        System.out.println("Success! Created new Customer with name: " +
                newCustomer.getName() + " and TaxID; " + newCustomer.getID());
    }

    private void printMenu() {
        System.out.println("==================================================");
        System.out.println("What do you want to do next: ");
        System.out.println("   [1] Exit the program");
        System.out.println("   [2] Add a new customer");
        System.out.println("   [3] Get Help");
        System.out.println("==================================================");
        System.out.println("Type the number of the option you want");
    }
}
