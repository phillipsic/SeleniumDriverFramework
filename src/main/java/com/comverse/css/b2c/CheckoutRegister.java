/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutRegister extends B2CMenu {

    public CheckoutRegister(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Checkout Register";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SignUpUser selectSignMeUpAndClickContinue() throws Exception {

        this.selectSignMeUp();
        SignUpUser signUp = this.clickContinue();
        return signUp;
    }

    public CheckOutBillingAccountInformation enterRegisteredLoginDetailsAndClickContinue(String loginName, String password) throws Exception {

        this.setRegisteredLogin(loginName);
        this.setPassword(password);
        this.clickContinueExpectingCheckoutBillingAccountInformation();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public void selectSignMeUp() throws Exception {

        tool.driver.findElement(By.id("sign_up_anonymous")).click();
    }

    public void setRegisteredLogin(String login) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(login);
    }

    public void setPassword(String password) throws Exception {

        tool.driver.findElement(By.id("password")).clear();
        tool.driver.findElement(By.id("password")).sendKeys(password);
    }

    public SignUpUser clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SignUpUser(tool, test, user);
    }

    public MyBasket clickCancel() throws Exception {

        tool.driver.findElement(By.name("cancel")).click();
        return new MyBasket(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickContinueExpectingCheckoutBillingAccountInformation() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }
}
