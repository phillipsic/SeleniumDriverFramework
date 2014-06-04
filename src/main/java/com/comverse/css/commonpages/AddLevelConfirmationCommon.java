/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLevelConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add Level - Confirmation";

    public AddLevelConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddLevelCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddLevelCommon(driver);
    }
}
