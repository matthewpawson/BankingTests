package org.example;

import org.example.exceptions.InvalidNameException;
import org.example.exceptions.NegativeInputException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NegativeInputException, InvalidNameException {

        BankAccount birdAccountKupo = new BankAccount(2000, "Kupo Simon");
        BankAccount birdAccountTonton = new BankAccount(1000, "Tonton Simon");

        CurrentAccount currentAccount1 = new CurrentAccount(29000, "Victoria");
        currentAccount1.setInterestRate(1.05);
        CurrentAccount currentAccount2 = new CurrentAccount(15000, "Paul");
        currentAccount2.setInterestRate(1.15);

        SavingsAccount savingsAccount1 = new SavingsAccount(10000, "A Person");
        savingsAccount1.setMaxWithdrawal(1000);
        SavingsAccount savingsAccount2 = new SavingsAccount(25000, "Another Person");
        savingsAccount2.setMaxWithdrawal(0);

        List<BankAccount> accounts = new ArrayList<BankAccount>() {{
            add(birdAccountKupo);
            add(birdAccountTonton);
            add(currentAccount1);
            add(currentAccount2);
            add(savingsAccount1);
            add(savingsAccount2);
        }};

        for (BankAccount account : accounts)
            System.out.println(account.toString());


    }
}
