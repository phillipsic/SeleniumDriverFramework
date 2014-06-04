/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddSubLevelLegalAddressCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Legal Address";

    public AddSubLevelLegalAddressCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setLevelName(String levelName) throws Exception {

        driver.findElement(By.id("company_name")).clear();
        driver.findElement(By.id("company_name")).sendKeys(levelName);
    }

    public void setLevelState(String levelState) throws Exception {

        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(levelState);
        /*
         * driver.findElement(By.id("home_state")).clear();
         * driver.findElement(By.id("home_state")).sendKeys(levelState);
         */
    }

    public RequestSubmissionCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new RequestSubmissionCommon(driver);
    }
}
