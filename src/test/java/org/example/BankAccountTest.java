package org.example;

import org.example.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Test
    public void test_setGetBalance() throws NegativeInputException {
        BankAccount account = new BankAccount();
        int value = 1000;
        account.setBalance(value);
        assertEquals(value, account.getBalance());
    }

    @Test
    public void test_invalidBalanceConstructor() throws NegativeInputException {
        assertThrows(NegativeInputException.class, () -> {
            BankAccount account = new BankAccount(-100010);
        });
    }

    @Test
    public void test_invalidBalanceSetter() throws NegativeInputException, InvalidNameException {
        BankAccount account = new BankAccount(100, "Paul Mercer");
        assertThrows(NegativeInputException.class, () -> {
            account.setBalance(-50000);
        });
    }

    @Test
    public void test_invalidNameConstructor() throws InvalidNameException {
        assertThrows(InvalidNameException.class, () -> {
            BankAccount account = new BankAccount(80000, "Kupo123");
        });
        assertThrows(InvalidNameException.class, () -> {
            BankAccount account = new BankAccount(80000, "Victoria.");
        });
        assertThrows(InvalidNameException.class, () -> {
            BankAccount account = new BankAccount(80000, "A person/");
        });
    }

    @Test
    public void test_invalidNameConstructorFAIL() throws InvalidNameException {
        // this should throw an error as "   " is not a valid name, but it doesnt
        // actually doing proper name validation is really hard! so keeping this as an example failure
        assertThrows(InvalidNameException.class, () -> {
            BankAccount account = new BankAccount(0, "   ");
        });
    }

    @Test
    public void test_depositMoneyGood() throws NegativeInputException, CringeMatt {
        int baseMoney = 10000;
        int depositAmount = 15050;
        BankAccount account = new BankAccount(baseMoney);
        account.deposit(depositAmount);
        assertEquals(account.getBalance(), baseMoney + depositAmount);
    }

    @Test
    public void test_depositMoneyStupid() throws CringeMatt, NegativeInputException {

        int baseMoney = 200483;
        BankAccount account = new BankAccount(baseMoney);
        assertThrows(CringeMatt.class, () -> {
            account.deposit(Integer.MAX_VALUE);
        });

        account.setBalance(1);
        assertThrows(CringeMatt.class, () -> {
            account.deposit(Integer.MAX_VALUE);
        });
    }

    @Test
    public void test_depositMoneyBad() throws NegativeInputException {
        int baseMoney = 10000;
        int depositAmount = -15050;
        BankAccount account = new BankAccount(baseMoney);
        assertThrows(NegativeInputException.class, () -> {
            account.deposit(depositAmount);
        });
    }

    @Test
    public void test_withdrawMoneyGood() throws NegativeInputException, NotEnoughMoneyException, OverMaxWithdrawalException {
        BankAccount account = new BankAccount(10000);
        account.withdraw(2500);
        assertEquals(7500, account.getBalance());
        account.withdraw(7499);
        assertEquals(1, account.getBalance());
    }

    @Test
    public void test_withdrawMoneyBad() throws NegativeInputException, OverMaxWithdrawalException  {
        BankAccount account = new BankAccount(10000);
        assertThrows(NotEnoughMoneyException.class, () -> {
            account.withdraw(12500);
        });
        assertThrows(NotEnoughMoneyException.class, () -> {
            account.withdraw(10001);
        });
        assertThrows(NotEnoughMoneyException.class, () -> {
            account.withdraw(Integer.MAX_VALUE);
        });
    }

    @Test
    public void test_withdrawMoneyNegative() throws NegativeInputException {
        BankAccount account = new BankAccount(10000);
        assertThrows(NegativeInputException.class, () -> {
            account.withdraw(-10000);
        });
        assertThrows(NegativeInputException.class, () -> {
            account.withdraw(-1);
        });
    }
}
