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
public class ModifyContactInformationConfirmationCommon extends CommonMenu {

    public ModifyContactInformationConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Contact Information - Confirmation";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmissionCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RequestSubmissionCommon(driver);
    }

    public RequestSubmissionCommon clickOkToConfirm() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RequestSubmissionCommon(driver);
    }

}
