/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.WelcomeToYourPersonalizedWorkspaceCommon;

/**
 * 
 * @author iphilli
 */
public class WelcomeToYourPersonalizedWorkspace extends WelcomeToYourPersonalizedWorkspaceCommon {

    public WelcomeToYourPersonalizedWorkspace(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ViewHierarchy clickManageTelco() throws Exception {
        super.clickManageTelco();
        return new ViewHierarchy(driver);
    }
}
