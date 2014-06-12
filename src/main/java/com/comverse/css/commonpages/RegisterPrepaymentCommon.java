package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterPrepaymentCommon extends CommonMenu {
    static String expectedScreen = "Register Prepayment";

    public RegisterPrepaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAmount(String amount) throws Exception {

        tool.driver.findElement(By.id("amount")).clear();
        tool.driver.findElement(By.id("amount")).sendKeys(amount);
    }

    public void selectPaymentMethod(String paymentMethod) throws Exception {

        // tool.driver.findElement(By.id(paymentmethod)).click();
        tool.driver.findElement(By.xpath("//input[@value='" + paymentMethod + "']")).click();

    }

    public RegisterPrepaymentCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RegisterPrepaymentCommon(tool, test, user);
    }

    public void enterCardNumber(String cardNumber) throws Exception {
        tool.driver.findElement(By.id("cardNumber")).clear();
        tool.driver.findElement(By.id("cardNumber")).sendKeys(cardNumber);
    }

    public void enterCardExpDate(String expirationDate) throws Exception {
        tool.driver.findElement(By.id("cardExpirationDate")).clear();
        tool.driver.findElement(By.id("cardExpirationDate")).sendKeys(expirationDate);
    }

    public void enterCardHolderLastName(String lastName) throws Exception {
        tool.driver.findElement(By.id("cardHolderName")).clear();
        tool.driver.findElement(By.id("cardHolderName")).sendKeys(lastName);
    }

    public void enterCardHolderFirstName(String firstName) throws Exception {
        tool.driver.findElement(By.id("cardHolderFName")).clear();
        tool.driver.findElement(By.id("cardHolderFName")).sendKeys(firstName);
    }

    public void enterCardSecretCode(String secretCode) throws Exception {
        tool.driver.findElement(By.id("cardSecretCode")).clear();
        tool.driver.findElement(By.id("cardSecretCode")).sendKeys(secretCode);
    }

    public RegisterPrepaymentConfirmCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterPrepaymentConfirmCommon(tool, test, user);
    }

    public void enterZipPostalCode(String postalCode) throws Exception {
        tool.driver.findElement(By.id("cardZipPostCode")).clear();
        tool.driver.findElement(By.id("cardZipPostCode")).sendKeys(postalCode);
    }
}
