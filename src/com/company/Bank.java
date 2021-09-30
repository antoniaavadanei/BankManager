package com.company;

import java.util.ArrayList;

/*Your job is to create a simple banking application.
        Implement the following classes:
        1. com.company.Bank
        -It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
        - A constructor that takes a String (name of the bank). It initialises name and instantiates branches.
        - And five methods, they are (their functions are in their names):
          - addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
          - addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
          - addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added successfully or false otherwise.
          - findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
          - listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
  */
/*→ TEST CODE
        com.company.Bank bank = new com.company.Bank("National Australia com.company.Bank");
        bank.addBranch("Adelaide");
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);
        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
        bank.listCustomers("Adelaide", true);
        → OUTPUT
        The list of customers should be printed out in the following format if boolean parameter is true:
        Customer details for branch Adelaide
        Customer: Tim[1]
        Transactions
        [1]  Amount 50.05
        [2]  Amount 44.22
        [3]  Amount 12.44
        Customer: Mike[2]
        Transactions
        [1]  Amount 175.34
        [2]  Amount 1.65
        Customer: Percy[3]
        Transactions
        [1]  Amount 220.12
        and if false, only the customers - no transactions:
        bank.listCustomers("Adelaide", false);
        Customer details for branch Adelaide
        Customer: Tim[1]
        Customer: Mike[2]
        Customer: Percy[3]

 */
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName){
        if(findBranch(branchName)!=null){
            return false;
        } else{
            Branch branch = new Branch(branchName);
            return branches.add(branch);
        }
    }
    public boolean addCustomer(String branchName, String customerName, Double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.newCustomer(customerName,transaction);
            return true;
        }else{
            return false;
        }

    }
    private Branch findBranch(String name){
        for(int i=0;i<branches.size();i++){
            if(branches.get(i).getName().equals(name)){
                return branches.get(i);
            }
        }
        return null;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, Double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
                branch.addCustomerTransaction(customerName, transaction);
                return true;
        }else{
            return false;
        }
    }
    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            if(printTransactions){
                System.out.println("Customer details for branch " + branchName);
                for(int i=0;i<branch.getCustomers().size();i++){
                    System.out.println("Customer: " + branch.getCustomers().get(i).getName() + "[" + (i+1) + "]");
                    System.out.println("Transactions");
                    for(int j=0;j<branch.getCustomers().get(i).getTransactions().size();j++){
                        System.out.println("[" + (j+1) + "]  Amount " + branch.getCustomers().get(i).getTransactions().get(j));
                    }
                }
            } else{
                System.out.println("Customer details for branch " + branchName);
                for(int i=0;i<branch.getCustomers().size();i++){
                    System.out.println("Customer: " + branch.getCustomers().get(i).getName() + "[" + (i+1) + "]");

                }
            }
            return true;
        }else{
            return false;
        }

    }
}
