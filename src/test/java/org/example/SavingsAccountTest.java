package org.example;

import org.example.exceptions.NegativeInputException;
import org.example.exceptions.NotEnoughMoneyException;
import org.example.exceptions.OverMaxWithdrawalException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingsAccountTest {
    @Test
    public void test_setGetLimit() throws NegativeInputException {
        SavingsAccount account = new SavingsAccount();
        int value = 1000;
        account.setMaxWithdrawal(value);
        assertEquals(value, account.getMaxWithdrawal());
    }

    @Test
    public void test_setLimitNegative() throws NegativeInputException {
        SavingsAccount account = new SavingsAccount();
        assertThrows(NegativeInputException.class, () -> {
            account.setMaxWithdrawal(-5);
        });
    }

    @Test
    public void test_overLimit() throws NegativeInputException, OverMaxWithdrawalException {
        SavingsAccount account = new SavingsAccount(10);
        account.setMaxWithdrawal(1);
        assertThrows(OverMaxWithdrawalException.class, () -> {
            account.withdraw(5);
        });
    }

    @Test
    public void test_maxIntWithdrawal() throws NegativeInputException, OverMaxWithdrawalException, NotEnoughMoneyException {
        SavingsAccount account = new SavingsAccount(Integer.MAX_VALUE);
        account.setMaxWithdrawal(Integer.MAX_VALUE);
        account.withdraw(Integer.MAX_VALUE);
        assertEquals(0, account.getBalance());
    }


}
