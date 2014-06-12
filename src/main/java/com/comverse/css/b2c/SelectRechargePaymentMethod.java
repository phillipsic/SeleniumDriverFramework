package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectRechargePaymentMethod extends B2CMenu {

    public SelectRechargePaymentMethod(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Select recharge payment method";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
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

    public RechargeDone clickSelect() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='select']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RechargeDone(tool, test, user);
    }
}
