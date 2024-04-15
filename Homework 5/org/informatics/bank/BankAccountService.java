package org.informatics.bank;

import java.math.BigDecimal;

public class BankAccountService {
    private BankAccount bankAccount;

    public BankAccountService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public boolean enoughAmount(BigDecimal amount) {
        return this.bankAccount.getBalance().compareTo(amount) >= 0;
    }

    public BigDecimal deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.bankAccount.setBalance(this.getBankAccount().getBalance().add(amount));
        }
        return this.getBankAccount().getBalance();
    }

    public BigDecimal withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && enoughAmount(amount)) {
            this.bankAccount.setBalance(this.getBankAccount().getBalance().subtract(amount));
        }
        return this.getBankAccount().getBalance();
    }

    public BigDecimal accumulateInterest(BigDecimal interestRatePercentage) {
        if(interestRatePercentage.compareTo(BigDecimal.ZERO) > 0 &&
                interestRatePercentage.compareTo(BigDecimal.valueOf(100)) <= 0) {

            final BigDecimal accumulatedValue = this.bankAccount.getBalance()
                    .multiply(interestRatePercentage).divide(BigDecimal.valueOf(100));

            deposit(accumulatedValue);

            return accumulatedValue;
        }
        return BigDecimal.ZERO;
    }
    @Override
    public String toString() {
        return "BankAccountService{" +
                "bankAccount=" + bankAccount +
                '}';
    }
}
