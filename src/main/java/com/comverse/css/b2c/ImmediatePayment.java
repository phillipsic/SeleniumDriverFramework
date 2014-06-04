package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImmediatePayment extends B2CMenu {
    
    public ImmediatePayment(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Immediate Payment";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public void enterCardNumber(String cardNumber) throws Exception {
        driver.findElement(By.id("cardNumber")).clear();
        driver.findElement(By.id("cardNumber")).sendKeys(cardNumber);
    }
    
    public void enterCardExpDate(String expirationDate) throws Exception {
        driver.findElement(By.id("cardExpirationDate")).clear();
        driver.findElement(By.id("cardExpirationDate")).sendKeys(expirationDate);
    }
    
    public void enterCardHolderLastName(String lastName) throws Exception {
        driver.findElement(By.id("cardHolderName")).clear();
        driver.findElement(By.id("cardHolderName")).sendKeys(lastName);
    }
    
    public void enterCardHolderFirstName(String firstName) throws Exception {
        driver.findElement(By.id("cardHolderFName")).clear();
        driver.findElement(By.id("cardHolderFName")).sendKeys(firstName);
    }
    
    public void enterCardSecretCode(String secretCode) throws Exception {
        driver.findElement(By.id("cardSecretCode")).clear();
        driver.findElement(By.id("cardSecretCode")).sendKeys(secretCode);
    }
    
    public CheckoutConfirmation clickContinue() throws Exception {
        
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CheckoutConfirmation(driver);
    }
}
