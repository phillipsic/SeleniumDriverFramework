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

public class RemoveLevelCommon extends CommonMenu {

    public RemoveLevelCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Remove Level";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//form[@id='form_OK']/div/input")).click();

        return new ViewHierarchyCommon(driver);

    }

    public RemoveLevelCommon clickOkToRemoveLevel() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new RemoveLevelCommon(driver);

    }

    public ViewHierarchyCommon clickOkToConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(driver);

    }

}
