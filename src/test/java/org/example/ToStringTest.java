package org.example;

import org.example.exceptions.InvalidNameException;
import org.example.exceptions.NegativeInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringTest {
    @Test
    public void test_toStringBank() throws NegativeInputException, InvalidNameException {
        BankAccount acc = new BankAccount(1,"Broke Matt");
        assertEquals("Bank Account    | Account Holder: Broke Matt      | Balance: £0.01",acc.toString());
    }
}
