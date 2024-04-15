package org.informatics.bank;

import org.junit.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountServiceTest {

    @Test
    public void testWithdrawSufficientFunds() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal withdrawnAmount = service.withdraw(new BigDecimal(500.00));
        
        assertEquals(new BigDecimal(500.00), withdrawnAmount);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal withdrawnAmount = service.withdraw(new BigDecimal(1500.00));
        
        assertEquals(new BigDecimal(1000.00), withdrawnAmount);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal withdrawnAmount = service.withdraw(new BigDecimal(-500.00));
        
        assertEquals(new BigDecimal(1000.00), withdrawnAmount);
    }

    @Test
    public void testAccumulateInterestNegativeRate() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal accumulatedInterest = service.accumulateInterest(new BigDecimal(-0.05));
        
        assertEquals(BigDecimal.ZERO, accumulatedInterest);
    }

    @Test
    public void testAccumulateInterestValidRate() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal accumulatedInterest = service.accumulateInterest(new BigDecimal(5.00).setScale(2));
        
        assertEquals(new BigDecimal(50.00).setScale(2), accumulatedInterest);
    }

    @Test
    public void testAccumulateInterestExcessiveRate() {
        BankAccount account = new BankAccount("123456789", new BigDecimal(1000.00));
        BankAccountService service = new BankAccountService(account);
        
        BigDecimal accumulatedInterest = service.accumulateInterest(new BigDecimal(150.00));
        
        assertEquals(BigDecimal.ZERO, accumulatedInterest);
    }
}
