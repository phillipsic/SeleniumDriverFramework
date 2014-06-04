/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Koushic
 */
public class ModifyProfileInformationCommon extends CommonMenu {

    public ModifyProfileInformationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Profile Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setTimeZone(String timeZone) throws Exception {

        new Select(driver.findElement(By.id("timezone_field"))).selectByVisibleText(timeZone);
    }

    public ModifyProfileInformationConfirmationCommon clickOkToModify() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyProfileInformationConfirmationCommon(driver);
    }
}
