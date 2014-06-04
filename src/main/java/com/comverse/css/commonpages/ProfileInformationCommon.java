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
public class ProfileInformationCommon extends CommonMenu {

    public ProfileInformationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Profile Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {
        driver.findElement(By.id("mnu_HIERARCHY")).click();
        return new ViewHierarchyCommon(driver);
    }

    public ModifyProfileInformationCommon clickModify() throws Exception {
        driver.findElement(By.id("modifyCustomer")).click();
        return new ModifyProfileInformationCommon(driver);
    }
}
