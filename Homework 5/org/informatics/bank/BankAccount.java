package org.informatics.bank;

import java.math.BigDecimal;

public class BankAccount {
    private final String iban;
    private BigDecimal balance;

    public BankAccount(String iban, BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) >= 0) {
            this.balance = balance;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
