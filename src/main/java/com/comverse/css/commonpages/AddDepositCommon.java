/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class AddDepositCommon extends CommonMenu {

    static String expectedScreen = "Add deposit";

    public AddDepositCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setDepositType(String depositType) throws Exception {

        driver.findElement(By.id("depositType")).sendKeys(depositType);
    }

    public void setBalance(String balanceName) throws Exception {

        new Select(driver.findElement(By.id("balance"))).selectByVisibleText(balanceName);

    }

    public void setDepositAmount(String depositAmount) throws Exception {

        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys(depositAmount);
    }

    public void selectPaymentMethod() throws Exception {

        //driver.findElement(By.id(paymentMethod)).click();
        driver.findElement(By.xpath("(//input[@name='paymentMethod'])[1]")).click();

    }

    public AddDepositReviewAndConfirmCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(driver);
    }
}
