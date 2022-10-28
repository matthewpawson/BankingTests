package org.example;

import org.example.exceptions.InvalidNameException;
import org.example.exceptions.NegativeInputException;
import org.example.exceptions.NotEnoughMoneyException;
import org.example.exceptions.OverMaxWithdrawalException;

public class SavingsAccount extends BankAccount {

    private int maxWithdrawal = 0;

    SavingsAccount(int balance, String accountHolder) throws NegativeInputException, InvalidNameException {
        super(balance, accountHolder);
    }

    SavingsAccount(int balance) throws NegativeInputException {
        super(balance);
    }

    SavingsAccount() {
        super();
    }

    @Override
    public void withdraw(int withdraw) throws NegativeInputException, NotEnoughMoneyException, OverMaxWithdrawalException {
        if (withdraw > getMaxWithdrawal())
            throw new OverMaxWithdrawalException();

        super.withdraw(withdraw);
    }

    public int getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void setMaxWithdrawal(int maxWithdrawal) throws NegativeInputException {
        if (maxWithdrawal < 0)
            throw new NegativeInputException();
        this.maxWithdrawal = maxWithdrawal;
    }
}
