/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author gmaroth
 */
public class NonVoucherRechargeCommon extends CommonMenu {

    public NonVoucherRechargeCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Non voucher recharge";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public NonVoucherRechargeReviewCommon nonVoucherRechargeByCheck(String rechargeAmount) throws Exception {

        this.enterRechargeAmount(rechargeAmount);
        new Select(driver.findElement(By.id("rechargeClass"))).selectByVisibleText("Check");
        driver.findElement(By.name("payment_type")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeReviewCommon(driver);
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys(rechargeAmount);
    }

    public void selectPaymentMethodCreditCard() throws Exception {

        driver.findElement(By.xpath("(//input[@value='CREDIT_CARD'])")).click();
    }

    public void selectPaymentMethodCash() throws Exception {

        driver.findElement(By.xpath("(//input[@value='CASH'])")).click();
    }

    public NonVoucherRechargeCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeCommon(driver);
    }

    public NonVoucherRechargeReviewCommon clickContinueExpectingNonVoucherRechargeReview() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeReviewCommon(driver);
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

    public void enterEmail(String email) throws Exception {
        driver.findElement(By.id("cardEmail")).clear();
        driver.findElement(By.id("cardEmail")).sendKeys(email);
    }

    public NonVoucherRechargeReviewCommon clickSelect() throws Exception {

        driver.findElement(By.xpath("//input[@name='select']")).click();
        return new NonVoucherRechargeReviewCommon(driver);
    }
}
