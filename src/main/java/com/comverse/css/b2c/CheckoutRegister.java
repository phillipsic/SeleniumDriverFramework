/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class CheckoutRegister extends B2CMenu {

    public CheckoutRegister(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Checkout Register";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
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
        return new CheckOutBillingAccountInformation(driver);
    }

    public void selectSignMeUp() throws Exception {

        driver.findElement(By.id("sign_up_anonymous")).click();
    }

    public void setRegisteredLogin(String login) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public void setPassword(String password) throws Exception {

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public SignUpUser clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SignUpUser(driver);
    }

    public MyBasket clickCancel() throws Exception {

        driver.findElement(By.name("cancel")).click();
        return new MyBasket(driver);
    }

    public CheckOutBillingAccountInformation clickContinueExpectingCheckoutBillingAccountInformation() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckOutBillingAccountInformation(driver);
    }
}
