/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class ListCases extends B2CMenu {

    

    public ListCases(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "List Cases";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCase clickCreateCase() throws Exception {

        driver.findElement(By.id("smnu_CASE_ADD")).click();
        Common.sleepForNumberOfSeconds(1);
        return new AddCase(driver);
    }
    
    public ViewCase clickOnCaseIDLink(String caseID) throws Exception {

        driver.findElement(By.linkText(caseID)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCase(driver);
    }

}
