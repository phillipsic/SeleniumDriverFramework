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
public class ChangeRolesCommon extends CommonMenu {

    public ChangeRolesCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Change Roles";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickRadioButtonOCMUser() throws Exception {

        driver.findElement(By.xpath("//input[@value='L2:30']")).click();

    }

    public void clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

    }

    public String getConfirmationMessage() throws Exception {

        return driver.findElement(By.cssSelector("span")).getText();
    }

    public void clickRadioButtonRetailerSubscriber() throws Exception {

        driver.findElement(By.xpath("(//input[@name='roles'])[2]")).click();

    }

}
