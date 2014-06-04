/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class AddDepositReviewAndConfirmCommon extends CommonMenu {

    static String expectedScreen = "Add deposit - Review and Confirm";

    public AddDepositReviewAndConfirmCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddDepositReviewAndConfirmCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(driver);
    }

    public AccountDetailsCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDepositsCommon clickOkToViewDeposits() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDepositsCommon(driver);
    }
}
