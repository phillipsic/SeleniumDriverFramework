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
 * @author iphilli
 */
public class ModifyLevelLegalContactCommon extends CommonMenu {

    public ModifyLevelLegalContactCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Modify Level Legal Contact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(driver);
    }

    public void setNewLevelName(String uniqueString) throws Exception {

        driver.findElement(By.id("company_name")).clear();
        driver.findElement(By.id("company_name")).sendKeys(uniqueString);
    }

    public void setNewLevelState(String uniqueState) throws Exception {

        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(uniqueState);

    }

    public ModifyLevelLegalContactCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ModifyLevelLegalContactCommon(driver);
    }

    public ModifyLevelLegalContactCommon clickOkAgain() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ModifyLevelLegalContactCommon(driver);
    }

    public LevelLegalContactCommon clickOkButton() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new LevelLegalContactCommon(driver);
    }
}
