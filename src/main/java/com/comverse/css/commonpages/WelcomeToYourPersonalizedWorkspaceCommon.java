/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class WelcomeToYourPersonalizedWorkspaceCommon extends CommonMenu {

    public WelcomeToYourPersonalizedWorkspaceCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getHomePageWelcomeMessage() throws Exception {

        return driver.findElement(By.xpath("/html/body/h1")).getText();
    }

    public ViewHierarchyCommon clickManageTelco() throws Exception {
        driver.findElement(By.id("mnu_TELCO")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(driver);
    }
}
