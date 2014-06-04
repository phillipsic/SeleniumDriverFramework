/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

public class ModifyEmpContactConfCommon extends CommonMenu {

    public ModifyEmpContactConfCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Contact Information";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

}
