/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class YourFriendsAndFamilyNumbersCommon extends CommonMenu {
    static String expectedScreen = "Your Friends and Family numbers";

    public YourFriendsAndFamilyNumbersCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigurationOfYourFriendsAndFamilyNumbersCommon clickReconfigure() throws Exception {
        driver.findElement(By.xpath("//input[@value='Reconfigure']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigurationOfYourFriendsAndFamilyNumbersCommon(driver);
    }

    public void verifyPhoneNumber(String phoneNumber) throws Exception {
        Common.assertTextOnPage(driver, phoneNumber);
    }

    public void clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

}
