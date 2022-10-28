package org.example;

public class BankAccount {
    private int balance = 0, minBalance = 0;
    private String accountHolder = "default user";

    BankAccount(int balance, String accountHolder) throws NegativeInputException, InvalidNameException {
        this(balance);
        setAccountHolder(accountHolder);
    }

    BankAccount(int balance) throws NegativeInputException {
        this();
        setBalance(balance);
    }

    BankAccount() {

    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) throws NegativeInputException {

        if (balance < 0) {
            throw new NegativeInputException();
        }

        this.balance = balance;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        this.minBalance = minBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) throws InvalidNameException {

        if (!accountHolder.matches("[a-zA-Z ]+")) {
            throw new InvalidNameException();
        }
        this.accountHolder = accountHolder;
    }

    public void deposit(int deposit) throws NegativeInputException, CringeMatt {
        if (deposit < 0) {
            throw new NegativeInputException();
        }
        if(this.getBalance()+deposit<0){
            throw new CringeMatt();
        }
        this.setBalance(this.getBalance() + deposit);
    }

    public void withdraw(int withdraw) throws NegativeInputException, NotEnoughMoneyException {
        if (withdraw < 0) {
            throw new NegativeInputException();
        }

        if (withdraw > this.getBalance() - this.getMinBalance()) {
            throw new NotEnoughMoneyException();
        }

        this.setBalance(this.getBalance() - withdraw);
    }
}