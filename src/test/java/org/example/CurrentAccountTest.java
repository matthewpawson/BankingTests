package org.example;

import org.example.exceptions.CringeMatt;
import org.example.exceptions.NegativeInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrentAccountTest {

    @Test
    public void test_setGetInterest() throws NegativeInputException {
        CurrentAccount account = new CurrentAccount();
        int value = 1000;
        account.setInterestRate(value);
        assertEquals(value, account.getInterestRate());
    }

    @Test
    public void test_setInterestNegative() throws NegativeInputException {
        int baseMoney = 200483;
        CurrentAccount account = new CurrentAccount(baseMoney);
        assertThrows(NegativeInputException.class, () -> {
            account.setInterestRate(-5);
        });
    }

    @Test
    public void test_setInterestSmall() throws NegativeInputException, CringeMatt {
        int baseMoney = 200483;
        double small = 1e-323+1;
        CurrentAccount account = new CurrentAccount(baseMoney);
            account.setInterestRate(small);
            assertEquals(small, account.getInterestRate());
            account.calculateInterest();
            assertEquals(baseMoney,account.getBalance());
    }

    @Test
    public void test_setInterestOne() throws NegativeInputException {
        int baseMoney = 200483;
        CurrentAccount account = new CurrentAccount(baseMoney);
        account.setInterestRate(1);
        assertEquals(1, account.getInterestRate());
    }

    @Test
    public void test_overflowCalcInterest() throws NegativeInputException,CringeMatt {
        int baseMoney = Integer.MAX_VALUE-10;
        CurrentAccount account = new CurrentAccount(baseMoney);
        account.setInterestRate(1.5);
        assertThrows(CringeMatt.class, () -> {
            account.calculateInterest();
        });
    }

    @Test
    public void test_calcInterestGood() throws NegativeInputException, CringeMatt {
        int baseMoney = 200483;
        CurrentAccount account = new CurrentAccount(baseMoney);
        account.setInterestRate(1.1);
        account.calculateInterest();
        assertEquals(Math.round(1.1*baseMoney), account.getBalance());
    }


}
