/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class AccountDepositsCommon extends CommonMenu {

    static String expectedScreen = "Account deposits";

    public AccountDepositsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddDepositCommon clickAdd() throws Exception {

        driver.findElement(By.linkText("Add")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddDepositCommon(driver);
    }

    public AccountDetailsCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new AccountDetailsCommon(driver);
    }
}
