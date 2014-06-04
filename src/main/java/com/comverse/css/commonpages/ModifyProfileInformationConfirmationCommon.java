/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Koushic
 */
public class ModifyProfileInformationConfirmationCommon extends CommonMenu {

    public ModifyProfileInformationConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Profile Information - Confirmation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmissionCommon clickOkToConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RequestSubmissionCommon(driver);
    }
}
