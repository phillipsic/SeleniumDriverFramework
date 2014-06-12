/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class NonVoucherRechargeCommon extends CommonMenu {

    public NonVoucherRechargeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Non voucher recharge";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public NonVoucherRechargeReviewCommon nonVoucherRechargeByCheck(String rechargeAmount) throws Exception {

        this.enterRechargeAmount(rechargeAmount);
        new Select(tool.driver.findElement(By.id("rechargeClass"))).selectByVisibleText("Check");
        tool.driver.findElement(By.name("payment_type")).click();
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeReviewCommon(tool, test, user);
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {
        tool.driver.findElement(By.id("amount")).clear();
        tool.driver.findElement(By.id("amount")).sendKeys(rechargeAmount);
    }

    public void selectPaymentMethodCreditCard() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='CREDIT_CARD'])")).click();
    }

    public void selectPaymentMethodCash() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='CASH'])")).click();
    }

    public NonVoucherRechargeCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeCommon(tool, test, user);
    }

    public NonVoucherRechargeReviewCommon clickContinueExpectingNonVoucherRechargeReview() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new NonVoucherRechargeReviewCommon(tool, test, user);
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

    public void enterEmail(String email) throws Exception {
        tool.driver.findElement(By.id("cardEmail")).clear();
        tool.driver.findElement(By.id("cardEmail")).sendKeys(email);
    }

    public NonVoucherRechargeReviewCommon clickSelect() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='select']")).click();
        return new NonVoucherRechargeReviewCommon(tool, test, user);
    }
}
