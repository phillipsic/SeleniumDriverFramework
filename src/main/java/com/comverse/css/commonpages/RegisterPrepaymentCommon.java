package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class RegisterPrepaymentCommon extends CommonMenu {
    static String expectedScreen = "Register Prepayment";

    public RegisterPrepaymentCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAmount(String amount) throws Exception {

        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    public void selectPaymentMethod(String paymentMethod) throws Exception {

        //driver.findElement(By.id(paymentmethod)).click();
        driver.findElement(By.xpath("//input[@value='" +paymentMethod+ "']")).click();

    }

    public RegisterPrepaymentCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RegisterPrepaymentCommon(driver);
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

    public RegisterPrepaymentConfirmCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RegisterPrepaymentConfirmCommon(driver);
    }

    public void enterZipPostalCode(String postalCode) throws Exception {
        driver.findElement(By.id("cardZipPostCode")).clear();
        driver.findElement(By.id("cardZipPostCode")).sendKeys(postalCode);
    }
}
