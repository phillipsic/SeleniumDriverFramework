/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author gmaroth
 */
public class OutboundCommunicationCommon extends CommonMenu {

    public OutboundCommunicationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Outbound Communication";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getSendOBCMessage() throws Exception {
        return driver.findElement(By.cssSelector("BODY")).getText();
    }
}
