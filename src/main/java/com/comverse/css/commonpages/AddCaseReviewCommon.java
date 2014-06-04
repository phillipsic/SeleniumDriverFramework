/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class AddCaseReviewCommon extends CommonMenu {
    static String expectedScreen = "Add case - review";

    public AddCaseReviewCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCaseConfirmationCommon clickCreateCase() throws Exception {

        driver.findElement(By.name("ACTION_CREATE")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddCaseConfirmationCommon(driver);

    }
    
     public AddCaseConfirmationCommon clickCreateCaseAndClose() throws Exception {

        driver.findElement(By.name("ACTION_CREATE_AND_CLOSE")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddCaseConfirmationCommon(driver);

    }
}
