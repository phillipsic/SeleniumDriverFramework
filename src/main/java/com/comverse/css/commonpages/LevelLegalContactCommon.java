/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class LevelLegalContactCommon extends CommonMenu {

    public LevelLegalContactCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Level Legal Contact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(driver);
    }

    public ModifyLevelLegalContactCommon clickModifyLevelLegalContact() throws Exception {
        driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyLevelLegalContactCommon(driver);
    }
}
