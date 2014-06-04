/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class CustomerPrerequisite extends B2CMenu {

    public CustomerPrerequisite(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!"Myshape Consumer".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: CustomerPrerequisite, but got: " + currentScreen);
        }
    }

}
