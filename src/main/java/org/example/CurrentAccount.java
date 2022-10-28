package org.example;

import org.example.exceptions.CringeMatt;
import org.example.exceptions.InvalidNameException;
import org.example.exceptions.NegativeInputException;

public class CurrentAccount extends BankAccount {

    private double interestRate = 0.0f;

    CurrentAccount(int balance, String accountHolder) throws NegativeInputException, InvalidNameException {
        super(balance, accountHolder);
    }

    CurrentAccount(int balance) throws NegativeInputException {
        super(balance);
    }

    CurrentAccount() {
        super();
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws NegativeInputException {

        if (interestRate < 1.0f)
            throw new NegativeInputException();
        this.interestRate = interestRate;
    }

    public void calculateInterest() throws NegativeInputException, CringeMatt {
        double newBalance = getBalance() * getInterestRate();
        if (newBalance > Integer.MAX_VALUE)
            throw new CringeMatt();
        setBalance((int) Math.round(newBalance));
    }

    @Override
    public String toString() {
        return String.format("Current Account | %s | Interest Rate: %f |", super.getDetails(), getInterestRate());
    }
}
