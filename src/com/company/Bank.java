package com.company;

import java.util.ArrayList;
import java.util.Optional;
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
                    System.out.print("What is the customer ID of the customer to select");
                    var idToFind = inputReader.nextInt();
                    var customer = getCustomer(idToFind);
                    if(customer.isPresent()){
                        doCustomerMenu(inputReader, customer.get());

                    }
                    else
                        System.out.println("No such customer exists at this bank");
                    break;
            }
        }
    }

    private void doCustomerMenu(Scanner inputReader, Customer customer) {
        while(true) {
            printCustomerMenu();
            System.out.print("Enter Selection");
            var choice = inputReader.nextInt();
            switch (choice){
                case 1:
                    BankAccount newAccount = addAccountToCustomer(inputReader, customer);
                    allAccounts.add(newAccount);
                    break;
                case 2:
                    closeAccount(inputReader, customer);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please choose one of the choices in the list");
            }
        }
    }

    private void closeAccount(Scanner inputReader, Customer customer) {
        //ask the user for the account number to close
        System.out.print("What is the number of the account you would like the close");
        var closeID = inputReader.nextInt();

        // calll close account on the customer
        var closedAccount = customer.closeAccount(closeID);

        //if succesful remove the account from allcaccounts as well.
        if(closedAccount.isPresent()){
            System.out.println("Closing account....");
            allAccounts.remove(closedAccount.get());
        }
        //if succesful remove the account from allcaccounts as well.

    }


    private BankAccount addAccountToCustomer(Scanner inputReader, Customer cust) {
        System.out.println("How much is the initial balance for hte new account");
        var intialDeposit = inputReader.nextDouble();
        var newAccount = cust.openAccount(intialDeposit);
        System.out.println("created account with ID" + newAccount.getAccountID());
        return newAccount;


    }

    private void printCustomerMenu() {
        System.out.println("==========================================");
        System.out.println("Please select what to do with this customer ");
        System.out.println("     [1] open account");
        System.out.println("     [2] close account");
        System.out.println("     [3] return to main menu");
        System.out.println("==========================================");
    }

    private Optional<Customer> getCustomer(int CustomerID){
        for(var currentCustomer : allCustomers){
            if(currentCustomer.getID() == CustomerID)
                return Optional.of(currentCustomer);
        }
        return Optional.empty();
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
        System.out.println("   [3] Select Customer");
        System.out.println("==================================================");
        System.out.println("Type the number of the option you want");
    }
}
