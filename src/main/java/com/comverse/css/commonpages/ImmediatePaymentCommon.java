/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class ImmediatePaymentCommon {

    private final WebDriver driver;

    public ImmediatePaymentCommon(WebDriver driver) {

        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Immediate Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setCardNumber(String value) throws Exception {

        driver.findElement(By.id("cardNumber")).clear();
        driver.findElement(By.id("cardNumber")).sendKeys(value);
    }

    public void setExpirationDate(String value) throws Exception {

        driver.findElement(By.id("cardExpirationDate")).clear();
        driver.findElement(By.id("cardExpirationDate")).sendKeys(value);
    }

    public void setCardHolderLastName(String value) throws Exception {

        driver.findElement(By.id("cardHolderName")).clear();
        driver.findElement(By.id("cardHolderName")).sendKeys(value);
    }

    public void setCardHolderFirstName(String value) throws Exception {

        driver.findElement(By.id("cardHolderFName")).clear();
        driver.findElement(By.id("cardHolderFName")).sendKeys(value);
    }

    public void setCardSecretCode(String value) throws Exception {

        driver.findElement(By.id("cardSecretCode")).clear();
        driver.findElement(By.id("cardSecretCode")).sendKeys(value);
    }

    public CheckoutConfirmationCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CheckoutConfirmationCommon(driver);
    }

    public void checkForExistingCreditCardDetailsAndClickNew() throws Exception {

        String existingCreditCard;

        existingCreditCard = this.isCreditCardNew();

        if (existingCreditCard.equals("New")) {
            this.clickCreditCardNew();
        }

    }

    public String isCreditCardNew() throws Exception {

        String creditCard = driver.findElement(By.xpath(".//*/div[3]/form/fieldset[1]/div/div/div[2]/span")).getText();
        System.out.println("Text is:" + creditCard);
        return creditCard;

    }

    public void clickCreditCardNew() throws Exception {

        driver.findElement(By.xpath("//fieldset/div/div/div/input[@value= 'CREDIT_CARD']")).click();
    }

}
